package ru.gulya.bookshelf.data.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "books",
        foreignKeys = @ForeignKey(entity = Author.class, parentColumns = "id", childColumns = "author_id"))
public class Book {
    @PrimaryKey(autoGenerate = true)
    private long id;

    private String title;

    @ColumnInfo(name = "author_id")
    private long authorId;

    private int year;
    private String description;

    @ColumnInfo(name = "shelf_id")
    private long shelfId;

    private long order;
}
