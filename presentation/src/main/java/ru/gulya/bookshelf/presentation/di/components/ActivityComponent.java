package ru.gulya.bookshelf.presentation.di.components;

import androidx.appcompat.app.AppCompatActivity;

import dagger.Component;
import ru.gulya.bookshelf.presentation.di.PerActivity;
import ru.gulya.bookshelf.presentation.di.modules.ActivityModule;

@PerActivity
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    AppCompatActivity activity();
}
