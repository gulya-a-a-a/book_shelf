package ru.gulya.bookshelf.presentation.views.activities;

import android.os.Bundle;

import androidx.annotation.Nullable;

import ru.gulya.bookshelf.domain.models.Book;
import ru.gulya.bookshelf.presentation.R;
import ru.gulya.bookshelf.presentation.views.ListFragmentOnClickListener;
import ru.gulya.bookshelf.presentation.views.fragments.book.BookListFragment;

public class BookListActivity extends BookActivity
        implements ListFragmentOnClickListener<Book> {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponent();
        if (savedInstanceState == null) {
            addFragment(R.id.fragment_container, new BookListFragment());
        }
    }

    @Override
    public void onItemSelectClicked(Book book) {
        mNavigator.goToSpecificBook(this, book.getId());
    }

    @Override
    public void onAddItemClicked() {
        mNavigator.goToEditSpecificBook(this, new Book());
    }
}
