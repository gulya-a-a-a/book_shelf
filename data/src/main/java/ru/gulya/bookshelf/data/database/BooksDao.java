package ru.gulya.bookshelf.data.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;
import ru.gulya.bookshelf.data.database.entity.Book;

@Dao
public interface BooksDao {

    @Insert
    Single<Long> insert(Book book);

    @Update
    Completable update(Book book);

    @Delete
    Single<Integer> deleteAll(Book[] books);

    @Query("SELECT * FROM books")
    Flowable<List<Book>> getAllBooks();

    @Query("SELECT * FROM books WHERE id=:bookId")
    Flowable<Book> getBookById(long bookId);

    @Query("SELECT * FROM books WHERE shelf_id=:shelfId")
    Flowable<List<Book>> getAllBookByShelfId(long shelfId);
}
