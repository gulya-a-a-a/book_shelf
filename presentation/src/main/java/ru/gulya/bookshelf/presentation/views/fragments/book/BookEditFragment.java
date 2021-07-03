package ru.gulya.bookshelf.presentation.views.fragments.book;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import ru.gulya.bookshelf.domain.models.Author;
import ru.gulya.bookshelf.domain.models.Book;
import ru.gulya.bookshelf.domain.models.Shelf;
import ru.gulya.bookshelf.presentation.R;
import ru.gulya.bookshelf.presentation.presenters.books.BookPresenter;
import ru.gulya.bookshelf.presentation.views.BookEditDetailedView;
import ru.gulya.bookshelf.presentation.views.DetailView;
import ru.gulya.bookshelf.presentation.views.activities.BookEditActivity;

public class BookEditFragment extends Fragment implements BookEditDetailedView {

    private EditText mEditTitle, mEditYear, mEditDescription;
    private Spinner mAuthorSelection;

    private CompositeDisposable mCompositeDisposable;

    @Inject
    BookPresenter mBookPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCompositeDisposable = new CompositeDisposable();
        ((BookEditActivity) Objects.requireNonNull(getActivity()))
                .getBookComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View fragmentView = inflater.inflate(R.layout.fragment_book_edit,
                container, false);
        initControls(fragmentView);
        return fragmentView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBookPresenter.setView(this);

        assert getArguments() != null;
        mBookPresenter.setBook((Book) getArguments().getSerializable("BOOK_ID"));
        mBookPresenter.getAuthors();
    }

    private void initControls(View view) {
        mAuthorSelection = view.findViewById(R.id.spinner_edit_book_authors);
        mEditTitle = view.findViewById(R.id.et_edit_book_title);
        mEditYear = view.findViewById(R.id.et_edit_book_year);
        mEditDescription = view.findViewById(R.id.et_edit_book_description);

        mCompositeDisposable.add(mBookPresenter.fromEditText(mEditTitle)
                .subscribe(string -> mBookPresenter.getModel().setTitle(string.toString())));

        mCompositeDisposable.add(mBookPresenter.fromEditText(mEditYear)
                .subscribe(string -> mBookPresenter.getModel().setYear(Integer.parseInt(string.toString()))));

        mCompositeDisposable.add(mBookPresenter.fromEditText(mEditDescription)
                .subscribe(string -> mBookPresenter.getModel().setDescription(string.toString())));

        view.findViewById(R.id.btn_edit_book_save)
                .setOnClickListener(v -> mBookPresenter.saveItem());
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void showItemDetails(Book item) {
        mEditTitle.setText(item.getTitle());
        mEditDescription.setText(item.getDescription());
        mEditYear.setText(String.format("%d", item.getYear()));
    }

    @Override
    public void setAuthorsList(List<Author> authorsList) {
        final ArrayAdapter<Author> authorAdapter = new ArrayAdapter<>(
                Objects.requireNonNull(getActivity()),
                android.R.layout.simple_spinner_item, authorsList);

        authorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mAuthorSelection.setOnItemSelectedListener((SimpleAdapterViewListener)
                (parent, view, position, id) -> mBookPresenter.setAuthor(position));

        mAuthorSelection.setAdapter(authorAdapter);

        mAuthorSelection.setSelection(authorsList.indexOf(mBookPresenter.getModel().getAuthor()));
    }

    @Override
    public void setShelfList(List<Shelf> shelfList) {

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

    interface SimpleAdapterViewListener extends AdapterView.OnItemSelectedListener {
        @Override
        default void onNothingSelected(AdapterView<?> parent) {
        }
    }
}


