package ru.gulya.bookshelf.presentation.views.activities;

import ru.gulya.bookshelf.presentation.di.components.BookComponent;
import ru.gulya.bookshelf.presentation.di.components.DaggerBookComponent;

public abstract class BookActivity extends BaseActivity {

    private BookComponent mBookComponent;

    void initComponent() {
        mBookComponent = DaggerBookComponent
                .builder()
                .appComponent(getAppComponent())
                .build();
    }

    public BookComponent getBookComponent() {
        return mBookComponent;
    }
}
