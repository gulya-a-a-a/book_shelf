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
import ru.gulya.bookshelf.data.database.entity.AuthorEntity;

@Dao
public interface AuthorDao {
    @Insert
    Single<Long> insert(AuthorEntity author);

    @Update
    Completable update(AuthorEntity author);

    @Delete
    Single<Integer> delete(AuthorEntity author);

    @Delete
    Single<Integer> deleteListOfUAuthors(List<AuthorEntity> authors);

    @Query("DELETE FROM authors")
    Single<Integer> deleteAllAuthors();

    @Query("SELECT * FROM authors")
    Observable<List<AuthorEntity>> getAll();

    @Query("SELECT * FROM authors WHERE id=:authorId")
    Observable<AuthorEntity> getAuthorById(long authorId);
}
