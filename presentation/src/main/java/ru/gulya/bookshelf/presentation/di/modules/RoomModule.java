package ru.gulya.bookshelf.presentation.di.modules;

import android.content.Context;

import androidx.room.Room;

import dagger.Module;
import dagger.Provides;
import ru.gulya.bookshelf.data.database.AuthorDao;
import ru.gulya.bookshelf.data.database.BookShelfDatabase;
import ru.gulya.bookshelf.data.database.BooksDao;

@Module(includes = ContextModule.class)
public class RoomModule {

    @Provides
    public AuthorDao provideAuthorsDao(BookShelfDatabase db) {
        return db.getAuthorDao();
    }

    @Provides
    public BooksDao provideBookssDao(BookShelfDatabase db) {
        return db.getBooksDao();
    }

    @Provides
    public BookShelfDatabase provideDatabase(Context context) {
        return Room.databaseBuilder(context,
                BookShelfDatabase.class,
                "bookshelf.sqlite").build();
    }
}
