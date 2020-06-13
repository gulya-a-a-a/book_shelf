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
import ru.gulya.bookshelf.data.database.entity.Author;

@Dao
public interface AuthorDao {
    @Insert
    Single<Long> insert(Author author);

    @Update
    Completable update(Author author);

    @Delete
    Single<Integer> delete(Author author);

    @Delete
    Single<Integer> deleteListOfUAuthors(List<Author> authors);

    @Query("DELETE FROM authors")
    Single<Integer> deleteAllAuthors();

    @Query("SELECT * FROM authors")
    Flowable<Author> getAll();

    @Query("SELECT * FROM authors WHERE id=:authorId")
    Flowable<Author> getAuthorById(long authorId);
}
