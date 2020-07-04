package ru.gulya.bookshelf.app.views.fragments;

import androidx.fragment.app.Fragment;

import java.util.Collection;

import ru.gulya.bookshelf.app.presenters.books.BooksListPresenter;
import ru.gulya.bookshelf.app.views.ListView;
import ru.gulya.bookshelf.domain.models.Book;

public class BookListFragment extends Fragment implements ListView<Book> {

    private BooksListPresenter mBooksListPresenter;

    BookListFragment() {
        setRetainInstance(true);
    }

    @Override
    public void showItemList(Collection<Book> itemCollection) {

    }

    @Override
    public void viewSpecificItem(Book item) {

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
