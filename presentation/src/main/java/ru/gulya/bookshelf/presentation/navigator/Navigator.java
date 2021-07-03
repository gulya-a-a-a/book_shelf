package ru.gulya.bookshelf.presentation.navigator;

import android.content.Context;
import android.content.Intent;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.internal.Preconditions;
import ru.gulya.bookshelf.domain.models.Book;
import ru.gulya.bookshelf.presentation.views.activities.AuthorsListActivity;
import ru.gulya.bookshelf.presentation.views.activities.BookDetailsActivity;
import ru.gulya.bookshelf.presentation.views.activities.BookEditActivity;
import ru.gulya.bookshelf.presentation.views.activities.BookListActivity;

@Singleton
public class Navigator {

    @Inject
    Navigator() {
    }

    public void goToBookList(Context context) {
        Preconditions.checkNotNull(context);
        Intent intent = new Intent(context, BookListActivity.class);
        context.startActivity(intent);
    }

    public void goToSpecificBook(Context context, long bookId) {
        Preconditions.checkNotNull(context);
        Intent intent = new Intent(context, BookDetailsActivity.class);
        intent.putExtra("BOOK_ID", bookId);
        context.startActivity(intent);
    }

    public void goToEditSpecificBook(Context context, Book book) {
        Preconditions.checkNotNull(context);
        Intent intent = new Intent(context, BookEditActivity.class);
        intent.putExtra("BOOK_ID", book);
        context.startActivity(intent);
    }

    public void goToAuthorsList(Context context) {
        Preconditions.checkNotNull(context);
        Intent intent = new Intent(context, AuthorsListActivity.class);
        context.startActivity(intent);
    }

    public void goToSpecificAuthor(Context context, long bookId) {
//        Preconditions.checkNotNull(context);
//        Intent intent = new Intent(context, AuthorsListActivity.class);
//        intent.putExtra("BOOK_ID", bookId);
//        context.startActivity(intent);
    }
}
