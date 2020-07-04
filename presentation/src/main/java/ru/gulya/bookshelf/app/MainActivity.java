package ru.gulya.bookshelf.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import javax.inject.Inject;

import ru.gulya.bookshelf.app.presenters.AuthorListPresenter;

public class MainActivity extends AppCompatActivity {

    @Inject
    AuthorListPresenter mAuthorListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BookShelfApplication.getAppComponent().inject(this);

        initControls();
    }

    private void initControls() {
        findViewById(R.id.button).setOnClickListener(v -> {
            mAuthorListPresenter.getAuthors();
        });

        findViewById(R.id.button_insert).setOnClickListener(v -> {
        });
    }
}
