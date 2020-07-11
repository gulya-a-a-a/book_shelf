package ru.gulya.bookshelf.data.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "shelves",
        foreignKeys = @ForeignKey(entity = BookcaseEntity.class, parentColumns = "bookcase_id",
                childColumns = "bookcaseId", onDelete = CASCADE),
        indices = @Index("bookcaseId")
)
public class ShelfEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "shelf_id")
    private long id;

    @ColumnInfo(name = "shelf_title")
    private String title;

    @ColumnInfo(name = "bookcaseId")
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
