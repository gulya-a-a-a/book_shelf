package ru.gulya.bookshelf.domain.interactor;

import dagger.internal.Preconditions;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import ru.gulya.bookshelf.domain.executors.PostExecutionThread;

public abstract class UseCase<T, Params, RxType> {

    protected final PostExecutionThread mPostExecutionThread;
    protected final CompositeDisposable mDisposables;

    public UseCase(PostExecutionThread postExecutionThread) {
        mPostExecutionThread = postExecutionThread;
        mDisposables = new CompositeDisposable();
    }

    abstract RxType buildUseCaseObservable(Params params);

    public void dispose() {
        if (!mDisposables.isDisposed()) {
            mDisposables.dispose();
        }
    }

    protected void addDisposable(Disposable disposable) {
        Preconditions.checkNotNull(disposable);
        Preconditions.checkNotNull(mDisposables);
        mDisposables.add(disposable);
    }
}
