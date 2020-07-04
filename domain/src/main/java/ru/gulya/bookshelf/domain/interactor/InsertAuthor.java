package ru.gulya.bookshelf.domain.interactor;

import javax.inject.Inject;

import io.reactivex.Single;
import ru.gulya.bookshelf.domain.BookShelfRepository;
import ru.gulya.bookshelf.domain.executors.PostExecutionThread;
import ru.gulya.bookshelf.domain.models.Author;

public class InsertAuthor extends UseCaseSingle<Long, Author> {

    private final BookShelfRepository<Author> mBookShelfRepository;

    @Inject
    public InsertAuthor(BookShelfRepository<Author> bookShelfRepository,
                        PostExecutionThread postExecutionThread) {
        super(postExecutionThread);
        mBookShelfRepository = bookShelfRepository;
    }

    @Override
    Single<Long> buildUseCaseObservable(Author author) {
        return mBookShelfRepository.insert(author);
    }
}
