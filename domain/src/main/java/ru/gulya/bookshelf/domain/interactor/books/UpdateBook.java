package ru.gulya.bookshelf.domain.interactor.books;

import javax.inject.Inject;

import ru.gulya.bookshelf.domain.BookShelfRepository;
import ru.gulya.bookshelf.domain.executors.PostExecutionThread;
import ru.gulya.bookshelf.domain.interactor.base.UpdateUseCase;
import ru.gulya.bookshelf.domain.models.Book;

public class UpdateBook extends UpdateUseCase<Book> {

    @Inject
    public UpdateBook(BookShelfRepository<Book> bookBookShelfRepository,
                      PostExecutionThread postExecutionThread) {
        super(bookBookShelfRepository, postExecutionThread);
    }
}
