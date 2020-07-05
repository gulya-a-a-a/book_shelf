package ru.gulya.bookshelf.presentation.views.activities;

import android.os.Bundle;

import androidx.annotation.Nullable;

import ru.gulya.bookshelf.presentation.R;
import ru.gulya.bookshelf.presentation.di.components.BookComponent;
import ru.gulya.bookshelf.presentation.di.components.DaggerBookComponent;
import ru.gulya.bookshelf.presentation.views.fragments.BookListFragment;

public class BookListActivity extends BaseActivity {

    private BookComponent mBookComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initInjection();
        if (savedInstanceState == null) {
            addFragment(R.id.fragment_container, new BookListFragment());
        }
    }

    private void initInjection() {
        mBookComponent = DaggerBookComponent
                .builder()
                .appComponent(getAppComponent())
                .build();
    }

    public BookComponent getBookComponent() {
        return mBookComponent;
    }
}
