package ru.gulya.bookshelf.app;

import android.app.Application;

import ru.gulya.bookshelf.app.di.components.AppComponent;
import ru.gulya.bookshelf.app.di.components.DaggerAppComponent;
import ru.gulya.bookshelf.app.di.modules.ApplicationModule;
import ru.gulya.bookshelf.app.di.modules.ContextModule;

public class BookShelfApplication extends Application {
    private static AppComponent sAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        sAppComponent = DaggerAppComponent
                .builder()
                .contextModule(new ContextModule(getApplicationContext()))
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public static AppComponent getAppComponent() {
        return sAppComponent;
    }
}
