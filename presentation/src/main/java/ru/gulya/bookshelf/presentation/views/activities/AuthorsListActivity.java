package ru.gulya.bookshelf.presentation.views.activities;

import android.os.Bundle;

import androidx.annotation.Nullable;

import ru.gulya.bookshelf.presentation.R;
import ru.gulya.bookshelf.presentation.views.ListFragmentOnClickListener;
import ru.gulya.bookshelf.presentation.views.fragments.author.AuthorListFragment;

public class AuthorsListActivity extends BookActivity implements ListFragmentOnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponent();
        if (savedInstanceState == null) {
            addFragment(R.id.fragment_container, new AuthorListFragment());
        }
    }

    @Override
    public void onItemSelectClicked(Object item) {
    }

    @Override
    public void onAddItemClicked() {
    }
}
