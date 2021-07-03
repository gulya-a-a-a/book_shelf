package ru.gulya.bookshelf.presentation.presenters.books;

import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.CompletableObserver;
import io.reactivex.Observable;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import ru.gulya.bookshelf.domain.interactor.authors.GetAuthorsList;
import ru.gulya.bookshelf.domain.interactor.books.GetBookById;
import ru.gulya.bookshelf.domain.interactor.books.InsertBook;
import ru.gulya.bookshelf.domain.interactor.books.UpdateBook;
import ru.gulya.bookshelf.domain.models.Author;
import ru.gulya.bookshelf.domain.models.Book;
import ru.gulya.bookshelf.domain.models.Shelf;
import ru.gulya.bookshelf.presentation.presenters.BaseItemPresenter;
import ru.gulya.bookshelf.presentation.views.BookEditDetailedView;

public class BookPresenter extends BaseItemPresenter<Book> {

    @Inject
    GetAuthorsList mGetAuthorsList;

    List<Author> mAuthors;

    @Inject
    BookPresenter(GetBookById getBookById,
                  InsertBook insertBook,
                  UpdateBook updateBook,
                  GetAuthorsList getAuthorsList) {
        super(getBookById, insertBook, updateBook);
        mGetAuthorsList = getAuthorsList;
    }

    @Override
    public void getItem(long id) {
        mGetOneUseCase.execute(new BookObservable(), id);
    }

    @Override
    public void insertItem() {
        mAddUseCase.execute(new BookInsertSingle(), mModel);
    }

    @Override
    public void updateItem() {
        if (mModel != null)
            mUpdateUseCase.execute(new BookCompletable(), mModel);
    }

    @Override
    public void saveItem() {
        //TODO Remove this and change to shelf selection
        mModel.setShelf(new Shelf(1));

        if (mModel.getId() == 0)
            insertItem();
        else
            updateItem();
    }

    public void setBook(Book book) {
        setModel(book);
        mView.showItemDetails(book);
    }

    public void setAuthors(List<Author> authors) {
        mAuthors = authors;
        if (mView instanceof BookEditDetailedView)
            ((BookEditDetailedView) mView).setAuthorsList(authors);
    }

    public void getAuthors() {
        mGetAuthorsList.execute(new AuthorsListObserver(), null);
    }

    public void setAuthor(int position) {
        mModel.setAuthor(mAuthors.get(position));
    }

    private class BookObservable extends DisposableObserver<Book> {
        @Override
        public void onNext(Book book) {
            setBook(book);
        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onComplete() {

        }
    }

    private static class BookInsertSingle implements SingleObserver<Long> {
        @Override
        public void onSubscribe(Disposable d) {

        }

        @Override
        public void onSuccess(Long aLong) {
            Log.d("Insert", String.format("Book inserted with %d id", aLong));
        }

        @Override
        public void onError(Throwable e) {
            Log.d("Insert", e.getLocalizedMessage());
        }
    }

    private static class BookCompletable implements CompletableObserver {
        @Override
        public void onSubscribe(Disposable d) {

        }

        @Override
        public void onComplete() {
            Log.d("Update", "Book saved");
        }

        @Override
        public void onError(Throwable e) {

        }
    }

    private class AuthorsListObserver extends DisposableObserver<List<Author>> {

        @Override
        public void onNext(List<Author> authors) {
            setAuthors(authors);
        }

        @Override
        public void onError(Throwable e) {
        }

        @Override
        public void onComplete() {
        }
    }


}
