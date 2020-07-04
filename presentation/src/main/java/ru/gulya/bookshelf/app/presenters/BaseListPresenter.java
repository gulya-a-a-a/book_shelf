package ru.gulya.bookshelf.app.presenters;

import ru.gulya.bookshelf.domain.interactor.base.GetListUseCase;

public abstract class BaseListPresenter<T> extends BasePresenter {

    protected final GetListUseCase<T> mGetListUseCase;

    public BaseListPresenter(GetListUseCase<T> getListUseCase) {
        mGetListUseCase = getListUseCase;
    }

    public abstract void getItemsList();

    public void destroy() {
        mGetListUseCase.dispose();
    }
}
