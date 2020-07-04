package ru.gulya.bookshelf.domain.interactor;

import javax.inject.Inject;

import io.reactivex.Observable;
import ru.gulya.bookshelf.domain.BookShelfRepository;
import ru.gulya.bookshelf.domain.executors.PostExecutionThread;
import ru.gulya.bookshelf.domain.models.Author;

public class GetAuthorById extends UseCaseObservable<Author, Long> {

    private final BookShelfRepository<Author> mBookShelfRepository;

    @Inject
    public GetAuthorById(BookShelfRepository<Author> bookShelfRepository,
                         PostExecutionThread postExecutionThread) {
        super(postExecutionThread);
        mBookShelfRepository = bookShelfRepository;
    }

    @Override
    Observable<Author> buildUseCaseObservable(Long id) {
        return mBookShelfRepository.getById(id);
    }
}
