package ru.gulya.bookshelf.data.database.mapper;

import javax.inject.Inject;

import ru.gulya.bookshelf.data.database.entity.compositions.BookDetailedData;
import ru.gulya.bookshelf.domain.models.Book;

public class BookDetailedMapper extends EntityMapper<Book, BookDetailedData> {

    @Inject
    BooksEntityMapper mBooksEntityMapper;

    @Inject
    AuthorEntityMapper mAuthorEntityMapper;

    @Inject
    public BookDetailedMapper() {
    }

    @Override
    Book createItem(BookDetailedData entity) {
        Book book = mBooksEntityMapper.createItem(entity.getBookEntity());
        book.getAuthor().setId(entity.getAuthorEntity().getId());
        book.setAuthor(mAuthorEntityMapper.createItem(entity.getAuthorEntity()));
        return book;
    }

    @Override
    BookDetailedData createEntity(Book item) {
        return null;
    }
}
