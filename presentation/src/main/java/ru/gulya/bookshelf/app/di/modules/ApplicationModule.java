package ru.gulya.bookshelf.app.di.modules;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.gulya.bookshelf.app.service.UIThread;
import ru.gulya.bookshelf.domain.executors.PostExecutionThread;

@Module
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
}
