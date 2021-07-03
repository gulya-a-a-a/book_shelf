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
import ru.gulya.bookshelf.data.database.entity.ShelfEntity;

@Dao
public interface ShelvesDao {
    @Insert
    Single<Long> insert(ShelfEntity shelf);

    @Update
    Completable update(ShelfEntity shelf);

    @Delete
    Single<Integer> deleteAll(ShelfEntity[] shelves);

    @Query("SELECT * FROM shelves")
    Flowable<List<ShelfEntity>> getAllShelves();

    @Query("SELECT * FROM shelves WHERE shelf_id=:shelfId")
    Flowable<ShelfEntity> getShelfById(long shelfId);
}
