package ru.gulya.bookshelf.data.database.mapper;

import javax.inject.Inject;
import javax.inject.Singleton;

import ru.gulya.bookshelf.data.database.entity.BookEntity;
import ru.gulya.bookshelf.domain.models.Book;

@Singleton
public class BooksEntityMapper extends EntityMapper<Book, BookEntity> {

    @Inject
    BooksEntityMapper() {
    }

    @Override
    Book createItem(BookEntity entity) {
        Book book = new Book(entity.getId());
        book.setTitle(entity.getTitle());
        book.setAuthorId(entity.getAuthorId());
        book.setDescription(entity.getDescription());
        book.setYear(entity.getYear());
        book.setOrder(entity.getOrder());
        book.setShelfId(entity.getShelfId());
        return book;
    }

    @Override
    BookEntity createEntity(Book item) {
        BookEntity entity = new BookEntity();
        entity.setTitle(item.getTitle());
        entity.setAuthorId(item.getAuthorId());
        entity.setDescription(item.getDescription());
        entity.setYear(item.getYear());
        entity.setOrder(item.getOrder());
        entity.setShelfId(item.getShelfId());
        return entity;
    }
}
