package ru.gulya.bookshelf.data.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "books",
        foreignKeys = {
                @ForeignKey(entity = Author.class, parentColumns = "id",
                        childColumns = "author_id", onDelete = CASCADE),
                @ForeignKey(entity = Shelf.class, parentColumns = "id",
                        childColumns = "shelf_id", onDelete = CASCADE)
        },
        indices = {
                @Index("author_id"),
                @Index("shelf_id")
        }
)
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

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getShelfId() {
        return shelfId;
    }

    public void setShelfId(long shelfId) {
        this.shelfId = shelfId;
    }

    public long getOrder() {
        return order;
    }

    public void setOrder(long order) {
        this.order = order;
    }
}
