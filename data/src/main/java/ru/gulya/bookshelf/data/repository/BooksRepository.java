package ru.gulya.bookshelf.data.repository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import ru.gulya.bookshelf.data.database.BooksDao;
import ru.gulya.bookshelf.data.database.mapper.BookDetailedMapper;
import ru.gulya.bookshelf.data.database.mapper.BooksEntityMapper;
import ru.gulya.bookshelf.domain.BookShelfRepository;
import ru.gulya.bookshelf.domain.models.Book;

public class BooksRepository implements BookShelfRepository<Book> {

    private final BooksEntityMapper mBooksEntityMapper;
    private final BookDetailedMapper mBookDetailedMapper;

    @Inject
    BooksDao mBooksDao;

    @Inject
    public BooksRepository(BooksEntityMapper booksEntityMapper,
                           BookDetailedMapper bookDetailedMapper) {
        mBooksEntityMapper = booksEntityMapper;
        mBookDetailedMapper = bookDetailedMapper;
    }

    @Override
    public Single<Long> insert(Book item) {
        return mBooksDao.insert(mBooksEntityMapper.transformTo(item));
    }

    @Override
    public Completable update(Book item) {
        return mBooksDao.update(mBooksEntityMapper.transformTo(item));
    }

    @Override
    public Observable<List<Book>> getAll() {
        return mBooksDao.getBooksWithAuthors().map(mBookDetailedMapper::transform);
    }

    @Override
    public Observable<Book> getShortInfoById(long id) {
        return mBooksDao.getBookById(id).map(mBooksEntityMapper::transform);
    }

    @Override
    public Observable<Book> getDetailedInfoById(long id) {
        return mBooksDao.getDetailedBookData(id).map(mBookDetailedMapper::transform);
    }

    @Override
    public Single<Integer> deleteAll() {
        return mBooksDao.deleteAll();
    }
}
