package ru.gulya.bookshelf.domain.interactor.base;

import io.reactivex.Observable;
import ru.gulya.bookshelf.domain.BookShelfRepository;
import ru.gulya.bookshelf.domain.executors.PostExecutionThread;

public abstract class GetOneUseCase<T> extends UseCaseObservable<T, Long> {

    protected BookShelfRepository<T> mBookShelfRepository;

    public GetOneUseCase(BookShelfRepository<T> bookShelfRepository,
                         PostExecutionThread postExecutionThread) {
        super(postExecutionThread);
        mBookShelfRepository = bookShelfRepository;
    }

    @Override
    public Observable<T> buildUseCaseObservable(Long id) {
        return mBookShelfRepository.getById(id);
    }
}
