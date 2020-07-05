package ru.gulya.bookshelf.presentation.presenters;

import ru.gulya.bookshelf.presentation.views.ListView;
import ru.gulya.bookshelf.domain.interactor.base.GetListUseCase;

public abstract class BaseListPresenter<T> extends BasePresenter<ListView<T>> {

    protected final GetListUseCase<T> mGetListUseCase;

    protected ListView<T> mListView;

    public BaseListPresenter(GetListUseCase<T> getListUseCase) {
        mGetListUseCase = getListUseCase;
    }

    public abstract void getItemsList();

    public void destroy() {
        mGetListUseCase.dispose();
    }
}
