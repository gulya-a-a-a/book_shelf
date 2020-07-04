package ru.gulya.bookshelf.app.di.components;

import javax.inject.Singleton;

import dagger.Component;
import ru.gulya.bookshelf.app.MainActivity;
import ru.gulya.bookshelf.app.di.modules.ApplicationModule;
import ru.gulya.bookshelf.app.di.modules.AuthorsModule;
import ru.gulya.bookshelf.app.di.modules.ContextModule;
import ru.gulya.bookshelf.app.di.modules.RoomModule;

@Singleton
@Component(modules = {ContextModule.class,
        ApplicationModule.class,
        AuthorsModule.class,
        RoomModule.class})
public interface AppComponent {
    void inject(MainActivity activity);
}
