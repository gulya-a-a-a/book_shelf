package ru.gulya.bookshelf.presentation.presenters.authors;

import android.util.Log;

import javax.inject.Inject;

import io.reactivex.CompletableObserver;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import ru.gulya.bookshelf.domain.interactor.authors.GetAuthorById;
import ru.gulya.bookshelf.domain.interactor.authors.GetAuthorsList;
import ru.gulya.bookshelf.domain.interactor.authors.InsertAuthor;
import ru.gulya.bookshelf.domain.interactor.authors.UpdateAuthor;
import ru.gulya.bookshelf.domain.models.Author;
import ru.gulya.bookshelf.domain.models.Book;
import ru.gulya.bookshelf.presentation.presenters.BaseItemPresenter;

public class AuthorPresenter extends BaseItemPresenter<Author> {

    @Inject
    AuthorPresenter(GetAuthorById getAuthorById,
                    InsertAuthor insertAuthor,
                    UpdateAuthor updateAuthor) {
        super(getAuthorById, insertAuthor, updateAuthor);
    }

    @Override
    public void getItem(long id) {
        mGetOneUseCase.execute(new AuthorObservable(), id);
    }

    @Override
    public void insertItem() {
        Author author = new Author(0, "Fyodor", "Tyutchev");
        mAddUseCase.execute(new InsertAuthorObserver(), author);
    }

    @Override
    public void updateItem() {
        mUpdateUseCase.execute(new AuthorCompletable(), mModel);
    }

    @Override
    public void saveItem() {
        if (mModel.getId() == 0)
            insertItem();
        else
            updateItem();
    }

    private class InsertAuthorObserver implements SingleObserver<Long> {
        @Override
        public void onSubscribe(Disposable d) {

        }

        @Override
        public void onSuccess(Long id) {
            Log.d("INSERT", String.format("Next id: %d", id));
        }

        @Override
        public void onError(Throwable e) {

        }
    }

    private class AuthorObservable extends DisposableObserver<Author> {
        @Override
        public void onNext(Author author) {
            setModel(author);
        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onComplete() {

        }
    }

    private class AuthorCompletable implements CompletableObserver {
        @Override
        public void onSubscribe(Disposable d) {

        }

        @Override
        public void onComplete() {

        }

        @Override
        public void onError(Throwable e) {

        }
    }
}
