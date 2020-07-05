package ru.gulya.bookshelf.presentation.presenters;

public abstract class BasePresenter<View> {

    protected View view;

    public void setView(View view) {
        this.view = view;
    }

}
