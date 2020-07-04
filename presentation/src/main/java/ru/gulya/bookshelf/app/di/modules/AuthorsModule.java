package ru.gulya.bookshelf.app.di.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.gulya.bookshelf.data.repository.AuthorsRepository;
import ru.gulya.bookshelf.domain.BookShelfRepository;
import ru.gulya.bookshelf.domain.models.Author;

@Module
public class AuthorsModule {

    @Provides
    @Singleton
    BookShelfRepository<Author> provideAuthorRepository(AuthorsRepository authorsRepository) {
        return authorsRepository;
    }
}
