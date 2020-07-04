package ru.gulya.bookshelf.domain.interactor.base;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.schedulers.Schedulers;
import ru.gulya.bookshelf.domain.executors.PostExecutionThread;

public abstract class UseCaseCompletable<T, Params> extends UseCase<T, Params, Completable> {

    public UseCaseCompletable(PostExecutionThread postExecutionThread) {
        super(postExecutionThread);
    }

    public void execute(CompletableObserver observer, Params params) {
        final Completable completable = this.buildUseCaseObservable(params)
                .subscribeOn(Schedulers.io())
                .observeOn(mPostExecutionThread.getScheduler());
        completable.subscribe(observer);
    }
}
