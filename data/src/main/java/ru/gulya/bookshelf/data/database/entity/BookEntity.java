package ru.gulya.bookshelf.data.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "books",
        foreignKeys = {
                @ForeignKey(entity = AuthorEntity.class, parentColumns = "author_id",
                        childColumns = "authorId", onDelete = CASCADE),
                @ForeignKey(entity = ShelfEntity.class, parentColumns = "shelf_id",
                        childColumns = "shelfId", onDelete = CASCADE)
        },
        indices = {
                @Index("authorId"),
                @Index("shelfId")
        }
)
public class BookEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "book_id")
    private long id;

    @ColumnInfo(name = "book_title")
    private String title;

    @ColumnInfo(name = "authorId")
    private long authorId;

    private int year;
    private String description;

    @ColumnInfo(name = "shelfId")
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
