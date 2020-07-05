package ru.gulya.bookshelf.presentation.di.modules;

import androidx.appcompat.app.AppCompatActivity;

import dagger.Module;
import dagger.Provides;
import ru.gulya.bookshelf.presentation.di.PerActivity;

@Module
public class ActivityModule {
    private final AppCompatActivity activity;

    public ActivityModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Provides
    @PerActivity
    AppCompatActivity activity() {
        return this.activity;
    }
}
