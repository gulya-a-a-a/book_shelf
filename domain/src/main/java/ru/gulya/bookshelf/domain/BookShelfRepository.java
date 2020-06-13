package ru.gulya.bookshelf.domain;


import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;

public interface BookShelfRepository<T> {
    Single<Long> insert(T item);

    Completable update(T item);

    Flowable<T> getAll();

    Flowable<T> getById(long id);

    Single<Integer> deleteAll();
}
