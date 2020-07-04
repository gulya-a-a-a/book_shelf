package ru.gulya.bookshelf.data.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import ru.gulya.bookshelf.data.database.entity.AuthorEntity;
import ru.gulya.bookshelf.data.database.entity.BookEntity;
import ru.gulya.bookshelf.data.database.entity.BookcaseEntity;
import ru.gulya.bookshelf.data.database.entity.PlacementEntity;
import ru.gulya.bookshelf.data.database.entity.ShelfEntity;

@Database(entities = {BookEntity.class, BookcaseEntity.class, ShelfEntity.class, PlacementEntity.class, AuthorEntity.class},
        version = 1, exportSchema = false)
public abstract class BookShelfDatabase extends RoomDatabase {
    public abstract BooksDao getBooksDao();

    public abstract ShelvesDao getShelvesDao();

    public abstract AuthorDao getAuthorDao();
}
