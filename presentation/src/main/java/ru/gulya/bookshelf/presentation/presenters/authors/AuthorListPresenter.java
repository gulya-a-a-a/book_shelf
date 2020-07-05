package ru.gulya.bookshelf.presentation.presenters.authors;

import android.util.Log;

import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;
import ru.gulya.bookshelf.domain.interactor.authors.GetAuthorsList;
import ru.gulya.bookshelf.domain.models.Author;

public class AuthorListPresenter {

    private GetAuthorsList mGetAuthorsList;

    @Inject
    public AuthorListPresenter(GetAuthorsList getAuthorsList) {
        mGetAuthorsList = getAuthorsList;
    }

    public void getAuthors() {
        mGetAuthorsList.execute(new AuthorsListObserver(), null);
    }

    private final class AuthorsListObserver extends DisposableObserver<List<Author>> {
        @Override
        public void onNext(List<Author> authors) {
            Log.d("TAG", authors.get(0).getFirstName());
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
