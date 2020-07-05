package ru.gulya.bookshelf.presentation.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Objects;

import javax.inject.Inject;

import ru.gulya.bookshelf.presentation.R;
import ru.gulya.bookshelf.presentation.presenters.books.BookPresenter;
import ru.gulya.bookshelf.presentation.views.DetailView;
import ru.gulya.bookshelf.presentation.views.activities.BookDetailsActivity;
import ru.gulya.bookshelf.domain.models.Book;

public class BookDetailsFragment extends Fragment implements DetailView<Book> {

    private TextView mBookTitle;

    @Inject
    BookPresenter mBookPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((BookDetailsActivity) Objects.requireNonNull(getActivity()))
                .getBookComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View fragmentView = inflater.inflate(R.layout.fragment_book_details, container, false);
        initControls(fragmentView);
        return fragmentView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBookPresenter.setView(this);
        mBookPresenter.getItem(getArguments().getLong("BOOK_ID"));
    }

    private void initControls(View fragmentView) {
        mBookTitle = fragmentView.findViewById(R.id.tv_detail_book_title);
    }

    @Override
    public void showItemDetails(Book item) {
        mBookTitle.setText(item.getTitle());
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError(String message) {

    }
}
