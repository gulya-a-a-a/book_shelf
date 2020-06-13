package ru.gulya.bookshelf.data.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "shelves",
        foreignKeys = @ForeignKey(entity = Bookcase.class, parentColumns = "id", childColumns = "bookcase_id")
)
public class Shelf {
    @PrimaryKey(autoGenerate = true)
    private long id;

    private String title;

    @ColumnInfo(name = "bookcase_id")
    private long bookcaseId;
}
