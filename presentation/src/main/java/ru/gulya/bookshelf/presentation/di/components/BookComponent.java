package ru.gulya.bookshelf.presentation.di.components;

import dagger.Component;
import ru.gulya.bookshelf.presentation.di.PerActivity;
import ru.gulya.bookshelf.presentation.di.modules.ActivityModule;
import ru.gulya.bookshelf.presentation.di.modules.BookModule;
import ru.gulya.bookshelf.presentation.views.fragments.BookDetailsFragment;
import ru.gulya.bookshelf.presentation.views.fragments.BookListFragment;


@PerActivity
@Component(dependencies = AppComponent.class,
        modules = {
                ActivityModule.class,
                BookModule.class
        })
public interface BookComponent {
    void inject(BookListFragment bookListFragment);

    void inject(BookDetailsFragment bookListFragment);
}
