package ru.gulya.bookshelf.data.repository;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;
import ru.gulya.bookshelf.data.database.AuthorDao;
import ru.gulya.bookshelf.data.database.entity.Author;
import ru.gulya.bookshelf.domain.BookShelfRepository;

@Singleton
public class AuthorsRepository implements BookShelfRepository<Author> {

    @Inject
    AuthorDao mAuthorDao;

    @Override
    public Single<Long> insert(Author item) {
        return mAuthorDao.insert(item);
    }

    @Override
    public Completable update(Author item) {
        return mAuthorDao.update(item);
    }

    @Override
    public Flowable<Author> getAll() {
        return mAuthorDao.getAll();
    }

    @Override
    public Flowable<Author> getById(long id) {
        return mAuthorDao.getAuthorById(id);
    }

    @Override
    public Single<Integer> deleteAll() {
        return mAuthorDao.deleteAllAuthors();
    }
}
