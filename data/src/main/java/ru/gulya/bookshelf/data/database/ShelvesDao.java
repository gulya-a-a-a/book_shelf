package ru.gulya.bookshelf.data.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import ru.gulya.bookshelf.data.database.entity.Shelf;

@Dao
public interface ShelvesDao {
    @Insert
    Maybe<Long> insert(Shelf shelf);

    @Update
    Completable update(Shelf shelf);

    @Delete
    Single<Integer> deleteAll(Shelf[] shelves);

    @Query("SELECT * FROM shelves")
    Flowable<List<Shelf>> getAllShelves();

    @Query("SELECT * FROM shelves WHERE id=:shelfId")
    Flowable<Shelf> getShelfById(long shelfId);
}
