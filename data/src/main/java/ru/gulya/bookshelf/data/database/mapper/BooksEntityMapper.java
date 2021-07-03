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
        book.setAuthorId(entity.getAuthorId());
        book.setShelfId(entity.getShelfId());
        book.setTitle(entity.getTitle());
        book.setDescription(entity.getDescription());
        book.setYear(entity.getYear());
        book.setOrder(entity.getOrder());
        return book;
    }

    @Override
    BookEntity createEntity(Book item) {
        BookEntity entity = new BookEntity();
        entity.setId(item.getId());
        entity.setTitle(item.getTitle());
        entity.setAuthorId(item.getAuthorId());
        entity.setShelfId(item.getShelfId());
        entity.setDescription(item.getDescription());
        entity.setYear(item.getYear());
        entity.setOrder(item.getOrder());
        return entity;
    }
}
