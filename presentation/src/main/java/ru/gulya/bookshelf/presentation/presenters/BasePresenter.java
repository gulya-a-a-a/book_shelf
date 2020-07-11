package ru.gulya.bookshelf.presentation.presenters;

public abstract class BasePresenter<View, Model> {

    protected View mView;
    protected Model mModel;

    public void setView(View view) {
        this.mView = view;
    }

    public View getView() {
        return mView;
    }

    public Model getModel() {
        return mModel;
    }

    public void setModel(Model model) {
        mModel = model;
    }

}
