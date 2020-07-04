package ru.gulya.bookshelf.app.views;

import java.util.Collection;

public interface ListView<T> extends LoadDataView {

    void showItemList(Collection<T> itemCollection);

    void viewSpecificItem(T item);
}
