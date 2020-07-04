package ru.gulya.bookshelf.domain.interactor;

import dagger.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import ru.gulya.bookshelf.domain.executors.PostExecutionThread;

public abstract class UseCaseObservable<T, Params> extends UseCase<T, Params, Observable<T>> {

    public UseCaseObservable(PostExecutionThread postExecutionThread) {
        super(postExecutionThread);
    }

    public void execute(DisposableObserver<T> observer, Params params) {
        Preconditions.checkNotNull(observer);
        final Observable<T> observable = this.buildUseCaseObservable(params)
                .subscribeOn(Schedulers.io())
                .observeOn(mPostExecutionThread.getScheduler());
        addDisposable(observable.subscribeWith(observer));
    }
}
