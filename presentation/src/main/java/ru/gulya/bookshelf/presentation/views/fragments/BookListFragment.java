package ru.gulya.bookshelf.presentation.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

import ru.gulya.bookshelf.presentation.R;
import ru.gulya.bookshelf.presentation.presenters.books.BooksListPresenter;
import ru.gulya.bookshelf.presentation.views.ListView;
import ru.gulya.bookshelf.presentation.views.activities.BookListActivity;
import ru.gulya.bookshelf.presentation.views.adapters.book.BookListAdapter;
import ru.gulya.bookshelf.domain.models.Book;

public class BookListFragment extends Fragment implements ListView<Book> {

    private RecyclerView mRecyclerViewBooks;
    private ProgressBar mProgressBar;
    private Button mRetryButton;

    @Inject
    BookListAdapter mBookListAdapter;

    @Inject
    BooksListPresenter mBooksListPresenter;

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
        final View fragmentView = inflater.inflate(R.layout.fragment_list, container, false);
        initControls(fragmentView);
        return fragmentView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBooksListPresenter.setView(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        mBooksListPresenter.getItemsList();
    }

    private void initControls(View v) {
        mProgressBar = v.findViewById(R.id.loading_progress);
        mRetryButton = v.findViewById(R.id.btn_retry);

        mRetryButton.setOnClickListener(v1 -> {
            mBooksListPresenter.getItemsList();
        });

        mRecyclerViewBooks = v.findViewById(R.id.rv);
        mRecyclerViewBooks.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerViewBooks.setAdapter(mBookListAdapter);
    }

    @Override
    public void showItemList(List<Book> itemCollection) {
        mBookListAdapter.setBookList(itemCollection);
    }

    @Override
    public void showSpecificItem(Book item) {

    }

    @Override
    public void showLoading() {
        mRecyclerViewBooks.setVisibility(View.GONE);
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mProgressBar.setVisibility(View.GONE);
        mRecyclerViewBooks.setVisibility(View.VISIBLE);
    }

    @Override
    public void showError(String message) {

    }
}
