package ru.gulya.bookshelf.data.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import ru.gulya.bookshelf.data.database.entity.Author;
import ru.gulya.bookshelf.data.database.entity.Book;
import ru.gulya.bookshelf.data.database.entity.Bookcase;
import ru.gulya.bookshelf.data.database.entity.Placement;
import ru.gulya.bookshelf.data.database.entity.Shelf;

@Database(entities = {Book.class, Bookcase.class, Shelf.class, Placement.class, Author.class},
        version = 1, exportSchema = false)
public abstract class BookShelfDatabase extends RoomDatabase {
    public abstract BookShelfDao getDao();
}
