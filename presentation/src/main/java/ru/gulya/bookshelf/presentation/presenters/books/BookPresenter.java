package ru.gulya.bookshelf.presentation.presenters.books;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;
import ru.gulya.bookshelf.domain.interactor.books.GetBookById;
import ru.gulya.bookshelf.domain.models.Book;
import ru.gulya.bookshelf.presentation.presenters.BaseItemPresenter;

public class BookPresenter extends BaseItemPresenter<Book> {

    @Inject
    BookPresenter(GetBookById getBookById) {
        super(getBookById);
    }

    @Override
    public void getItem(long id) {
        mGetOneUseCase.execute(new BookObservable(), id);
    }

    private class BookObservable extends DisposableObserver<Book> {
        @Override
        public void onNext(Book book) {
            view.showItemDetails(book);
        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onComplete() {

        }
    }
}
