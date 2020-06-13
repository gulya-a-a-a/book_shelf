package ru.gulya.bookshelf.data.database;

import androidx.room.Dao;
import androidx.room.Insert;

import io.reactivex.Maybe;
import ru.gulya.bookshelf.data.database.entity.Book;
import ru.gulya.bookshelf.data.database.entity.Temp;

@Dao
public interface BooksDao {

    @Insert
    Maybe<Long> insert(Book book);
}
