package ru.gulya.bookshelf.presentation.presenters.books;

import android.util.Log;

import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;
import ru.gulya.bookshelf.domain.models.Book;
import ru.gulya.bookshelf.presentation.presenters.BaseListPresenter;
import ru.gulya.bookshelf.domain.interactor.books.GetBooksList;

public class BooksListPresenter extends BaseListPresenter<Book> {

    @Inject
    public BooksListPresenter(GetBooksList getBooksList) {
        super(getBooksList);
    }

    @Override
    public void getItemsList() {
        mView.showLoading();
        mGetListUseCase.execute(new BooksListObserver(), null);
    }

    private final class BooksListObserver extends DisposableObserver<List<Book>> {
        @Override
        public void onNext(List<Book> books) {
            mView.hideLoading();
            setModel(books);
            mView.showItemList(books);
        }

        @Override
        public void onError(Throwable e) {
            Log.d("TAG", Objects.requireNonNull(e.getLocalizedMessage()));
        }

        @Override
        public void onComplete() {
            mView.hideLoading();
            Log.d("TAG", "Complete");
        }
    }
}
