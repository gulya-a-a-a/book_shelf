package ru.gulya.bookshelf.app.views;

public interface LoadDataView {

    void showLoading();

    void hideLoading();

    void showError(String message);
}