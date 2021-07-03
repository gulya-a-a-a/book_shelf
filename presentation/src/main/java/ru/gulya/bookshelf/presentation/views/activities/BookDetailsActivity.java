package ru.gulya.bookshelf.presentation.views.activities;

import android.os.Bundle;

import androidx.annotation.Nullable;

import ru.gulya.bookshelf.domain.models.Book;
import ru.gulya.bookshelf.presentation.R;
import ru.gulya.bookshelf.presentation.views.ListFragmentOnClickListener;
import ru.gulya.bookshelf.presentation.views.fragments.book.BookDetailsFragment;

public class BookDetailsActivity extends BookActivity implements ListFragmentOnClickListener<Book> {

    private long mBookId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponent();
        if (savedInstanceState == null) {
            mBookId = getIntent().getLongExtra("BOOK_ID", -1);
            final BookDetailsFragment bookDetailsFragment = new BookDetailsFragment();
            final Bundle args = new Bundle();
            args.putLong("BOOK_ID", mBookId);
            bookDetailsFragment.setArguments(args);
            addFragment(R.id.fragment_container, bookDetailsFragment);
        }
    }

    @Override
    public void onItemSelectClicked(Book book) {
        mNavigator.goToEditSpecificBook(this, book);
    }

    @Override
    public void onAddItemClicked() {

    }
}
