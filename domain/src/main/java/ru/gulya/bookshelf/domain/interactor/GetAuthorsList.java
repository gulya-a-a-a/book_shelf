package ru.gulya.bookshelf.domain.interactor;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import ru.gulya.bookshelf.domain.models.Author;
import ru.gulya.bookshelf.domain.BookShelfRepository;
import ru.gulya.bookshelf.domain.executors.PostExecutionThread;

public class GetAuthorsList extends UseCaseObservable<List<Author>, Void> {

    private final BookShelfRepository<Author> mBookShelfRepository;

    @Inject
    public GetAuthorsList(BookShelfRepository<Author> bookShelfRepository,
                          PostExecutionThread postExecutionThread) {
        super(postExecutionThread);
        mBookShelfRepository = bookShelfRepository;
    }

    @Override
    public Observable<List<Author>> buildUseCaseObservable(Void aVoid) {
        return mBookShelfRepository.getAll();
    }

    public BookShelfRepository<Author> getBookShelfRepository() {
        return mBookShelfRepository;
    }
}
