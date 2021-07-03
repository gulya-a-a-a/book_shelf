package ru.gulya.bookshelf.domain;


import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

public interface BookShelfRepository<T> {

    Single<Long> insert(T item);

    Completable update(T item);

    Observable<List<T>> getAll();

    Observable<T> getShortInfoById(long id);

    Observable<T> getDetailedInfoById(long id);

    Single<Integer> deleteAll();
}
