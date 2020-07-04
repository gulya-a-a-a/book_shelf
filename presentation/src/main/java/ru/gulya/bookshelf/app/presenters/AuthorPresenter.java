package ru.gulya.bookshelf.app.presenters;

import android.util.Log;

import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;
import ru.gulya.bookshelf.domain.interactor.GetAuthorById;
import ru.gulya.bookshelf.domain.models.Author;

public class AuthorPresenter {

    private GetAuthorById mGetAuthorById;

    @Inject
    AuthorPresenter(GetAuthorById getAuthorById) {
        mGetAuthorById = getAuthorById;
    }

    public void getAuthor(long id) {
        mGetAuthorById.execute(new AuthorObserver(), id);
    }


    private static final class AuthorObserver extends DisposableObserver<Author> {
        @Override
        public void onNext(Author author) {
            Log.d("TAG", author.getFirstName());
        }

        @Override
        public void onError(Throwable e) {
            Log.d("TAG", Objects.requireNonNull(e.getLocalizedMessage()));
        }

        @Override
        public void onComplete() {
            Log.d("TAG", "Complete");
        }
    }
}
