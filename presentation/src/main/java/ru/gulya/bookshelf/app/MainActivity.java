package ru.gulya.bookshelf.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import javax.inject.Inject;

import ru.gulya.bookshelf.app.presenters.authors.AuthorEditPresenter;
import ru.gulya.bookshelf.app.presenters.authors.AuthorListPresenter;
import ru.gulya.bookshelf.app.presenters.authors.AuthorPresenter;

public class MainActivity extends AppCompatActivity {

    @Inject
    AuthorListPresenter mAuthorListPresenter;

    @Inject
    AuthorPresenter mAuthorPresenter;

    @Inject
    AuthorEditPresenter mAuthorEditPresenter;

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BookShelfApplication.getAppComponent().inject(this);

        mAuthorListPresenter.setMainActivity(this);

        initControls();
    }

    private void initControls() {
        editText = findViewById(R.id.text_id);
        findViewById(R.id.button).setOnClickListener(v -> {
            mAuthorListPresenter.getAuthors();
        });

        findViewById(R.id.button_get_by_id).setOnClickListener(v -> {
            String id = String.valueOf(editText.getText());
            long val = Long.parseLong(id);
            mAuthorPresenter.getAuthor(val);
        });

        findViewById(R.id.button_insert).setOnClickListener(v -> {
            mAuthorEditPresenter.insertAuthor();
        });
    }

    public void showNumberOfAuthors(long val) {
        editText.setText(String.format("%d", val));
    }
}
