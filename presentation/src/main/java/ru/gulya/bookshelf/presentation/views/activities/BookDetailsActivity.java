package ru.gulya.bookshelf.presentation.views.activities;

import android.os.Bundle;

import androidx.annotation.Nullable;

import ru.gulya.bookshelf.presentation.R;
import ru.gulya.bookshelf.presentation.di.components.BookComponent;
import ru.gulya.bookshelf.presentation.di.components.DaggerBookComponent;
import ru.gulya.bookshelf.presentation.views.fragments.BookDetailsFragment;

public class BookDetailsActivity extends BaseActivity {

    private BookComponent mBookComponent;
    private long mBookId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initInjection();
        if (savedInstanceState == null) {
            mBookId = getIntent().getLongExtra("BOOK_ID", -1);
            final BookDetailsFragment bookDetailsFragment = new BookDetailsFragment();
            final Bundle args = new Bundle();
            args.putLong("BOOK_ID", mBookId);
            bookDetailsFragment.setArguments(args);
            addFragment(R.id.fragment_container, bookDetailsFragment);
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
