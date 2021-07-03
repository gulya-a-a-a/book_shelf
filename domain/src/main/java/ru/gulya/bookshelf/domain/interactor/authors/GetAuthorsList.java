package ru.gulya.bookshelf.domain.interactor.authors;

import javax.inject.Inject;

import ru.gulya.bookshelf.domain.interactor.base.GetListUseCase;
import ru.gulya.bookshelf.domain.models.Author;
import ru.gulya.bookshelf.domain.BookShelfRepository;
import ru.gulya.bookshelf.domain.executors.PostExecutionThread;

public class GetAuthorsList extends GetListUseCase<Author> {

    @Inject
    public GetAuthorsList(BookShelfRepository<Author> bookShelfRepository,
                          PostExecutionThread postExecutionThread) {
        super(bookShelfRepository, postExecutionThread);
    }
}
