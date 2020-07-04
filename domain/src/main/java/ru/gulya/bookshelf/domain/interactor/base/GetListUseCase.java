package ru.gulya.bookshelf.domain.interactor.base;

import java.util.List;

import io.reactivex.Observable;
import ru.gulya.bookshelf.domain.BookShelfRepository;
import ru.gulya.bookshelf.domain.executors.PostExecutionThread;

public abstract class GetListUseCase<T> extends UseCaseObservable<List<T>, Void> {

    protected BookShelfRepository<T> mBookShelfRepository;

    public GetListUseCase(BookShelfRepository<T> bookShelfRepository,
                          PostExecutionThread postExecutionThread) {
        super(postExecutionThread);
        mBookShelfRepository = bookShelfRepository;
    }

    @Override
    public Observable<List<T>> buildUseCaseObservable(Void aVoid) {
        return mBookShelfRepository.getAll();
    }
}
