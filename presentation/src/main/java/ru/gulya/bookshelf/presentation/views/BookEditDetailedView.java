package ru.gulya.bookshelf.presentation.views;

import java.util.List;

import ru.gulya.bookshelf.domain.models.Author;
import ru.gulya.bookshelf.domain.models.Book;
import ru.gulya.bookshelf.domain.models.Shelf;

public interface BookEditDetailedView extends DetailView<Book> {

    void setAuthorsList(List<Author> authorsList);

    void setShelfList(List<Shelf> shelfList);

}
