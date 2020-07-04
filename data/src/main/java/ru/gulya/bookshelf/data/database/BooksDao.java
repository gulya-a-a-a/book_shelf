package ru.gulya.bookshelf.data.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import ru.gulya.bookshelf.data.database.entity.BookEntity;

@Dao
public interface BooksDao {

    @Insert
    Single<Long> insert(BookEntity book);

    @Update
    Completable update(BookEntity book);

    @Delete
    Single<Integer> delete(BookEntity book);

    @Query("DELETE FROM authors")
    Single<Integer> deleteAll();

    @Query("SELECT * FROM books")
    Observable<List<BookEntity>> getAllBooks();

    @Query("SELECT * FROM books WHERE id=:bookId")
    Observable<BookEntity> getBookById(long bookId);

    @Query("SELECT * FROM books WHERE shelf_id=:shelfId")
    Observable<List<BookEntity>> getAllBookByShelfId(long shelfId);
}
