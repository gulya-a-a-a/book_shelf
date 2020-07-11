package ru.gulya.bookshelf.presentation.di.components;

import javax.inject.Singleton;

import dagger.Component;
import ru.gulya.bookshelf.domain.models.Author;
import ru.gulya.bookshelf.presentation.di.modules.ApplicationModule;
import ru.gulya.bookshelf.presentation.di.modules.ContextModule;
import ru.gulya.bookshelf.presentation.di.modules.RoomModule;
import ru.gulya.bookshelf.presentation.views.activities.BaseActivity;
import ru.gulya.bookshelf.domain.BookShelfRepository;
import ru.gulya.bookshelf.domain.executors.PostExecutionThread;
import ru.gulya.bookshelf.domain.models.Book;

@Singleton
@Component(modules = {ContextModule.class,
        ApplicationModule.class,
        RoomModule.class})
public interface AppComponent {
    void inject(BaseActivity activity);

    PostExecutionThread postExecutionThread();

    BookShelfRepository<Book> getBooksRepository();

    BookShelfRepository<Author> getAuthorsRepository();
}
