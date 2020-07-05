package ru.gulya.bookshelf.presentation.presenters;

import ru.gulya.bookshelf.domain.interactor.base.GetOneUseCase;
import ru.gulya.bookshelf.presentation.views.DetailView;

public abstract class BaseItemPresenter<T> extends BasePresenter<DetailView<T>> {

    protected final GetOneUseCase<T> mGetOneUseCase;

    protected DetailView<T> mDetailView;

    public BaseItemPresenter(GetOneUseCase<T> getOneUseCase) {
        mGetOneUseCase = getOneUseCase;
    }

    public abstract void getItem(long item);

    public void destroy() {
        mGetOneUseCase.dispose();
    }
}
