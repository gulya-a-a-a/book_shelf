package ru.gulya.bookshelf.presentation.views;

import ru.gulya.bookshelf.domain.models.Book;

public interface ListFragmentOnClickListener<T> {
    void onItemSelectClicked(T item);

    void onAddItemClicked();
}
