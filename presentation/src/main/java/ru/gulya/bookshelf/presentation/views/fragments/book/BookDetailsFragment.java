package ru.gulya.bookshelf.presentation.views.fragments.book;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Objects;

import javax.inject.Inject;

import ru.gulya.bookshelf.presentation.R;
import ru.gulya.bookshelf.presentation.presenters.books.BookPresenter;
import ru.gulya.bookshelf.presentation.views.ListFragmentOnClickListener;
import ru.gulya.bookshelf.presentation.views.DetailView;
import ru.gulya.bookshelf.presentation.views.activities.BookDetailsActivity;
import ru.gulya.bookshelf.domain.models.Book;

public class BookDetailsFragment extends Fragment implements DetailView<Book> {

    private TextView mBookTitle, mAuthorName;
    private Button mInsertButton;
    private FloatingActionButton mFloatingActionButton;

    @Inject
    BookPresenter mBookPresenter;

    ListFragmentOnClickListener mBookListOnClickListener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((BookDetailsActivity) Objects.requireNonNull(getActivity()))
                .getBookComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final View fragmentView = inflater.inflate(R.layout.fragment_book_details,
                container, false);
        initControls(fragmentView);
        return fragmentView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBookPresenter.setView(this);
        assert getArguments() != null;
        mBookPresenter.getItem(getArguments().getLong("BOOK_ID"));

        Activity activity = getActivity();
        if (activity instanceof BookDetailsActivity) {
            mBookListOnClickListener = (ListFragmentOnClickListener) activity;
        }
    }

    private void initControls(View fragmentView) {
        mBookTitle = fragmentView.findViewById(R.id.tv_detail_book_title);
        mAuthorName = fragmentView.findViewById(R.id.tv_detail_book_author_name);
        mInsertButton = fragmentView.findViewById(R.id.btn_insert_book);
        mInsertButton.setOnClickListener(v -> mBookPresenter.insertItem());
        mFloatingActionButton = fragmentView.findViewById(R.id.fp_edit_book);
        mFloatingActionButton.setOnClickListener(v -> {
            mBookListOnClickListener.onItemSelectClicked(mBookPresenter.getModel());
        });
    }

    @Override
    public void showItemDetails(Book item) {
        mBookTitle.setText(item.getTitle());
        mAuthorName.setText(item.getAuthor().toString());
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
