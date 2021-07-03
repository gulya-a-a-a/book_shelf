package ru.gulya.bookshelf.data.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import ru.gulya.bookshelf.data.database.entity.compositions.BookDetailedData;
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

    @Query("SELECT * FROM books WHERE book_id=:bookId")
    Observable<BookEntity> getBookById(long bookId);

    @Query("SELECT * FROM books WHERE shelfId=:shelfId")
    Observable<List<BookEntity>> getAllBookByShelfId(long shelfId);

    @Transaction
    @Query("SELECT * FROM books " +
            "JOIN authors " +
            "ON books.authorId == authors.author_id ")
    Observable<List<BookDetailedData>> getBooksWithAuthors();

    @Transaction
    @Query("SELECT * FROM books " +
            "JOIN authors " +
            "ON books.authorId == authors.author_id " +
            "LEFT JOIN shelves ON books.shelfId == shelves.shelf_id " +
            "LEFT JOIN bookcases ON shelves.bookcaseId == bookcases.bookcase_id " +
            "LEFT JOIN placement ON bookcases.room_id == placement.placement_id " +
            "WHERE books.book_id=:bookId")
    Observable<BookDetailedData> getDetailedBookData(long bookId);
}
