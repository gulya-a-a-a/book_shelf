package ru.gulya.bookshelf.data.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "shelves",
        foreignKeys = @ForeignKey(entity = Bookcase.class, parentColumns = "id", childColumns = "bookcase_id"),
        indices = @Index("bookcase_id")
)
public class Shelf {
    @PrimaryKey(autoGenerate = true)
    private long id;

    private String title;

    @ColumnInfo(name = "bookcase_id")
    private long bookcaseId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getBookcaseId() {
        return bookcaseId;
    }

    public void setBookcaseId(long bookcaseId) {
        this.bookcaseId = bookcaseId;
    }
}
