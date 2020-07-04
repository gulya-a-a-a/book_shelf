package ru.gulya.bookshelf.domain.interactor.base;

import io.reactivex.Completable;
import ru.gulya.bookshelf.domain.BookShelfRepository;
import ru.gulya.bookshelf.domain.executors.PostExecutionThread;

public abstract class UpdateUseCase<T> extends UseCaseCompletable<Void, T> {

    protected final BookShelfRepository<T> mBookShelfRepository;

    public UpdateUseCase(BookShelfRepository<T> bookShelfRepository,
                         PostExecutionThread postExecutionThread) {
        super(postExecutionThread);
        mBookShelfRepository = bookShelfRepository;
    }

    @Override
    public Completable buildUseCaseObservable(T item) {
        return mBookShelfRepository.update(item);
    }
}
