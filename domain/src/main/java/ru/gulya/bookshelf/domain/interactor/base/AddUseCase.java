package ru.gulya.bookshelf.domain.interactor.base;

import javax.inject.Inject;

import io.reactivex.Single;
import ru.gulya.bookshelf.domain.BookShelfRepository;
import ru.gulya.bookshelf.domain.executors.PostExecutionThread;

public abstract class AddUseCase<T> extends UseCaseSingle<Long, T> {

    protected final BookShelfRepository<T> mBookShelfRepository;

    @Inject
    public AddUseCase(BookShelfRepository<T> bookShelfRepository,
                      PostExecutionThread postExecutionThread) {
        super(postExecutionThread);
        mBookShelfRepository = bookShelfRepository;
    }

    @Override
    public Single<Long> buildUseCaseObservable(T item) {
        return mBookShelfRepository.insert(item);
    }
}
