package ru.gulya.bookshelf.domain.interactor.books;

import javax.inject.Inject;

import ru.gulya.bookshelf.domain.BookShelfRepository;
import ru.gulya.bookshelf.domain.executors.PostExecutionThread;
import ru.gulya.bookshelf.domain.interactor.base.AddUseCase;
import ru.gulya.bookshelf.domain.models.Book;

public class InsertBook extends AddUseCase<Book> {

    @Inject
    InsertBook(BookShelfRepository<Book> bookBookShelfRepository,
               PostExecutionThread postExecutionThread) {
        super(bookBookShelfRepository, postExecutionThread);
    }
}
