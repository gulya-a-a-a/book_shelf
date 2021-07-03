package ru.gulya.bookshelf.domain.interactor.authors;

import javax.inject.Inject;

import ru.gulya.bookshelf.domain.BookShelfRepository;
import ru.gulya.bookshelf.domain.executors.PostExecutionThread;
import ru.gulya.bookshelf.domain.interactor.base.AddUseCase;
import ru.gulya.bookshelf.domain.models.Author;

public class InsertAuthor extends AddUseCase<Author> {

    @Inject
    public InsertAuthor(BookShelfRepository<Author> bookShelfRepository,
                        PostExecutionThread postExecutionThread) {
        super(bookShelfRepository, postExecutionThread);
    }
}
