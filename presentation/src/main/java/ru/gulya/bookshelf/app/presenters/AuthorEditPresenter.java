package ru.gulya.bookshelf.app.presenters;

import android.util.Log;

import javax.inject.Inject;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import ru.gulya.bookshelf.domain.interactor.InsertAuthor;
import ru.gulya.bookshelf.domain.models.Author;

public class AuthorEditPresenter {

    private InsertAuthor mInsertAuthor;

    @Inject
    AuthorEditPresenter(InsertAuthor insertAuthor) {
        mInsertAuthor = insertAuthor;
    }

    public void insertAuthor() {
        Author author = new Author(0, "Fyodor", "Tyutchev");
        mInsertAuthor.execute(new InsertAuthorObserver(), author);
    }

    public static class InsertAuthorObserver implements SingleObserver<Long> {
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
}
