package ru.gulya.bookshelf.domain.interactor;

import io.reactivex.Completable;
import io.reactivex.schedulers.Schedulers;
import ru.gulya.bookshelf.domain.executors.PostExecutionThread;

public abstract class UseCaseCompletable<T, Params> extends UseCase<T, Params, Completable> {

    UseCaseCompletable(PostExecutionThread postExecutionThread) {
        super(postExecutionThread);
    }

    public void execute(Params params) {
        final Completable completable = this.buildUseCaseObservable(params)
                .subscribeOn(Schedulers.io())
                .observeOn(mPostExecutionThread.getScheduler());
        addDisposable(completable.subscribe());
    }
}
