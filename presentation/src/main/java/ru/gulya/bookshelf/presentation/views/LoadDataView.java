package ru.gulya.bookshelf.presentation.views;

public interface LoadDataView {

    void showLoading();

    void hideLoading();

    void showError(String message);
}