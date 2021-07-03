package ru.gulya.bookshelf.presentation.views;

import java.util.List;

public interface ListView<T> extends LoadDataView {

    void showItemList(List<T> itemCollection);

    void showSpecificItem(T item);
}
