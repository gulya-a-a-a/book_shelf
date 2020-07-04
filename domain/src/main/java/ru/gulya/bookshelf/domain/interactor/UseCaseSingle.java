package ru.gulya.bookshelf.domain.interactor;

import dagger.internal.Preconditions;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.schedulers.Schedulers;
import ru.gulya.bookshelf.domain.executors.PostExecutionThread;

public abstract class UseCaseSingle<T, Params> extends UseCase<T, Params, Single<T>> {

    UseCaseSingle(PostExecutionThread postExecutionThread) {
        super(postExecutionThread);
    }

    public void execute(SingleObserver<T> observer, Params params) {
        Preconditions.checkNotNull(observer);
        final Single<T> single = this.buildUseCaseObservable(params)
                .subscribeOn(Schedulers.io())
                .observeOn(mPostExecutionThread.getScheduler());
        single.subscribe(observer);
    }
}

