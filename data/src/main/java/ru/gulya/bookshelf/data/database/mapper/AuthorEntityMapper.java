package ru.gulya.bookshelf.data.database.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import ru.gulya.bookshelf.data.database.entity.AuthorEntity;
import ru.gulya.bookshelf.domain.models.Author;

@Singleton
public class AuthorEntityMapper {
    @Inject
    AuthorEntityMapper() {
    }

    public Author transform(AuthorEntity entity) {
        Author author = null;
        if (entity != null) {
            author = new Author(entity.getId());
            author.setFirstName(entity.getFirstName());
            author.setSurname(entity.getSurname());
        }
        return author;
    }

    public List<Author> transform(Collection<AuthorEntity> authorEntities) {
        final List<Author> authorList = new ArrayList<>(50);
        for (AuthorEntity entity : authorEntities) {
            final Author author = transform(entity);
            if (author != null) {
                authorList.add(author);
            }
        }
        return authorList;
    }

    public AuthorEntity transformTo(Author author) {
        AuthorEntity entity = null;
        if (author != null) {
            entity = new AuthorEntity(author.getId(),
                    author.getFirstName(), author.getSurname());
        }
        return entity;
    }
}
