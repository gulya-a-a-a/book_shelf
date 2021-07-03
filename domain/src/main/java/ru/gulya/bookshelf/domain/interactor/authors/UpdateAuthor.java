package ru.gulya.bookshelf.domain.interactor.authors;

import javax.inject.Inject;

import ru.gulya.bookshelf.domain.BookShelfRepository;
import ru.gulya.bookshelf.domain.executors.PostExecutionThread;
import ru.gulya.bookshelf.domain.interactor.base.UpdateUseCase;
import ru.gulya.bookshelf.domain.models.Author;

public class UpdateAuthor extends UpdateUseCase<Author> {

    @Inject
    UpdateAuthor(BookShelfRepository<Author> authorBookShelfRepository,
                 PostExecutionThread postExecutionThread) {
        super(authorBookShelfRepository, postExecutionThread);
    }
}
