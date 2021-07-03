package ru.gulya.bookshelf.presentation.views.activities;

import android.os.Bundle;

import androidx.annotation.Nullable;

import ru.gulya.bookshelf.domain.models.Book;
import ru.gulya.bookshelf.presentation.R;
import ru.gulya.bookshelf.presentation.views.fragments.book.BookEditFragment;

public class BookEditActivity extends BookActivity {

    private Book mBook;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponent();

        if (savedInstanceState == null) {
            mBook = (Book) getIntent().getSerializableExtra("BOOK_ID");
            final BookEditFragment bookEditFragment = new BookEditFragment();
            final Bundle args = new Bundle();
            args.putSerializable("BOOK_ID", mBook);
            bookEditFragment.setArguments(args);
            addFragment(R.id.fragment_container, bookEditFragment);
        }
    }
}
