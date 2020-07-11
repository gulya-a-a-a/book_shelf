package ru.gulya.bookshelf.presentation.views.fragments.book;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Objects;

import ru.gulya.bookshelf.presentation.R;
import ru.gulya.bookshelf.presentation.presenters.books.BooksListPresenter;
import ru.gulya.bookshelf.presentation.views.activities.BookListActivity;
import ru.gulya.bookshelf.presentation.views.adapters.book.BookListAdapter;
import ru.gulya.bookshelf.domain.models.Book;
import ru.gulya.bookshelf.presentation.views.fragments.BaseListFragment;

public class BookListFragment extends BaseListFragment<Book, BooksListPresenter, BookListAdapter> {

    public BookListFragment() {
        setRetainInstance(true);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((BookListActivity) Objects.requireNonNull(getActivity()))
                .getBookComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View fragmentView = inflater.inflate(R.layout.fragment_list,
                container, false);
        initControls(fragmentView, R.id.rv);
        return fragmentView;
    }

    @Override
    protected void initControls(View fragmentView, int recyclerViewId) {
        super.initControls(fragmentView, recyclerViewId);
        fragmentView.findViewById(R.id.btn_list_add_item).setOnClickListener(btn -> {
            mFragmentOnClickListener.onAddItemClicked();
        });
    }
}
