package ru.gulya.bookshelf.data.repository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import ru.gulya.bookshelf.data.database.AuthorDao;
import ru.gulya.bookshelf.data.database.mapper.AuthorEntityMapper;
import ru.gulya.bookshelf.domain.BookShelfRepository;
import ru.gulya.bookshelf.domain.models.Author;

@Singleton
public class AuthorsRepository implements BookShelfRepository<Author> {

    @Inject
    AuthorDao mAuthorDao;

    private final AuthorEntityMapper mAuthorEntityMapper;

    @Inject
    public AuthorsRepository(AuthorEntityMapper authorEntityMapper) {
        mAuthorEntityMapper = authorEntityMapper;
    }

    @Override
    public Single<Long> insert(Author item) {
        return mAuthorDao.insert(mAuthorEntityMapper.transformTo(item));
    }

    @Override
    public Completable update(Author item) {
        return mAuthorDao.update(mAuthorEntityMapper.transformTo(item));
    }

    @Override
    public Observable<List<Author>> getAll() {
        return mAuthorDao.getAll().map(mAuthorEntityMapper::transform);
    }

    @Override
    public Observable<Author> getById(long id) {
        return mAuthorDao.getAuthorById(id).map(mAuthorEntityMapper::transform);
    }

    @Override
    public Single<Integer> deleteAll() {
        return mAuthorDao.deleteAllAuthors();
    }
}
