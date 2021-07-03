package ru.gulya.bookshelf.presentation.views;

public interface DetailView<T> extends LoadDataView {
    void showItemDetails(T item);
}
