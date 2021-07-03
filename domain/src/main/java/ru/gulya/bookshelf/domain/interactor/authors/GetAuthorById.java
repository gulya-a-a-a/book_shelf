package ru.gulya.bookshelf.domain.interactor.authors;

import javax.inject.Inject;

import ru.gulya.bookshelf.domain.BookShelfRepository;
import ru.gulya.bookshelf.domain.executors.PostExecutionThread;
import ru.gulya.bookshelf.domain.interactor.base.GetOneUseCase;
import ru.gulya.bookshelf.domain.models.Author;

public class GetAuthorById extends GetOneUseCase<Author> {

    @Inject
    public GetAuthorById(BookShelfRepository<Author> bookShelfRepository,
                         PostExecutionThread postExecutionThread) {
        super(bookShelfRepository, postExecutionThread);
    }
}
