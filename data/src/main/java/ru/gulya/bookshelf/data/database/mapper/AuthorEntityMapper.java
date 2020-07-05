package ru.gulya.bookshelf.data.database.mapper;

import javax.inject.Inject;
import javax.inject.Singleton;

import ru.gulya.bookshelf.data.database.entity.AuthorEntity;
import ru.gulya.bookshelf.domain.models.Author;

@Singleton
public class AuthorEntityMapper extends EntityMapper<Author, AuthorEntity> {
    @Inject
    AuthorEntityMapper() {
    }

    @Override
    Author createItem(AuthorEntity entity) {
        return new Author(entity.getId(),
                entity.getFirstName(), entity.getSurname());
    }

    @Override
    AuthorEntity createEntity(Author item) {
        return new AuthorEntity(item.getId(),
                item.getFirstName(), item.getSurname());
    }
}
