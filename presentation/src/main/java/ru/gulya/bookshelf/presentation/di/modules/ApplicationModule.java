package ru.gulya.bookshelf.presentation.di.modules;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.gulya.bookshelf.presentation.service.UIThread;
import ru.gulya.bookshelf.data.repository.AuthorsRepository;
import ru.gulya.bookshelf.data.repository.BooksRepository;
import ru.gulya.bookshelf.domain.BookShelfRepository;
import ru.gulya.bookshelf.domain.executors.PostExecutionThread;
import ru.gulya.bookshelf.domain.models.Author;
import ru.gulya.bookshelf.domain.models.Book;

@Module(includes = RoomModule.class)
public class ApplicationModule {
    private Application app;

    public ApplicationModule(Application application) {
        this.app = application;
    }

    @Provides
    @Singleton
    PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }

    @Provides
    @Singleton
    BookShelfRepository<Book> provideBooksRepository(BooksRepository booksRepository) {
        return booksRepository;
    }

    @Provides
    @Singleton
    BookShelfRepository<Author> provideAuthorRepository(AuthorsRepository authorsRepository) {
        return authorsRepository;
    }
}
