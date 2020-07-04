package ru.gulya.bookshelf.data.repository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import ru.gulya.bookshelf.data.database.BooksDao;
import ru.gulya.bookshelf.data.database.mapper.BooksEntityMapper;
import ru.gulya.bookshelf.domain.BookShelfRepository;
import ru.gulya.bookshelf.domain.models.Book;

public class BooksRepository implements BookShelfRepository<Book> {

    private final BooksEntityMapper mBooksEntityMapper;

    @Inject
    BooksDao mBooksDao;

    @Inject
    public BooksRepository(BooksEntityMapper booksEntityMapper) {
        mBooksEntityMapper = booksEntityMapper;
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
        return mBooksDao.getAllBooks().map(mBooksEntityMapper::transform);
    }

    @Override
    public Observable<Book> getById(long id) {
        return mBooksDao.getBookById(id).map(mBooksEntityMapper::transform);
    }

    @Override
    public Single<Integer> deleteAll() {
        return mBooksDao.deleteAll();
    }
}
