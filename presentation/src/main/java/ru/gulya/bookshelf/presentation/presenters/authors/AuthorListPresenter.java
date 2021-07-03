package ru.gulya.bookshelf.presentation.presenters.authors;

import android.util.Log;

import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;
import ru.gulya.bookshelf.domain.interactor.authors.GetAuthorsList;
import ru.gulya.bookshelf.domain.models.Author;
import ru.gulya.bookshelf.presentation.presenters.BaseListPresenter;

public class AuthorListPresenter extends BaseListPresenter<Author> {

    @Inject
    public AuthorListPresenter(GetAuthorsList getAuthorsList) {
        super(getAuthorsList);
    }

    @Override
    public void getItemsList() {
        mGetListUseCase.execute(new AuthorsListObserver(), null);
    }

    private final class AuthorsListObserver extends DisposableObserver<List<Author>> {
        @Override
        public void onNext(List<Author> authors) {
            if (mView != null) {
                mView.showItemList(authors);
            }
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
