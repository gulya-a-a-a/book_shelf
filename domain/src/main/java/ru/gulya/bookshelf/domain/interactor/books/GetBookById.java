package ru.gulya.bookshelf.domain.interactor.books;

import javax.inject.Inject;

import ru.gulya.bookshelf.domain.BookShelfRepository;
import ru.gulya.bookshelf.domain.executors.PostExecutionThread;
import ru.gulya.bookshelf.domain.interactor.base.GetOneUseCase;
import ru.gulya.bookshelf.domain.models.Book;

public class GetBookById extends GetOneUseCase<Book> {

    @Inject
    GetBookById(BookShelfRepository<Book> bookBookShelfRepository,
                PostExecutionThread postExecutionThread) {
        super(bookBookShelfRepository, postExecutionThread);
    }
}
