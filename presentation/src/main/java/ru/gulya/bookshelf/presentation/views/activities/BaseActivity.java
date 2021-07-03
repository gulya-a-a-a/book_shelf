package ru.gulya.bookshelf.presentation.views.activities;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import javax.inject.Inject;

import ru.gulya.bookshelf.presentation.BookShelfApplication;
import ru.gulya.bookshelf.presentation.di.components.AppComponent;
import ru.gulya.bookshelf.presentation.navigator.Navigator;

public abstract class BaseActivity extends AppCompatActivity {

    @Inject
    Navigator mNavigator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getAppComponent().inject(this);
    }

    protected AppComponent getAppComponent() {
        return BookShelfApplication.getAppComponent();
    }

    protected void addFragment(int containerId, Fragment fragment) {
        this.getSupportFragmentManager().
                beginTransaction().
                add(containerId, fragment).
                commit();
    }
}
