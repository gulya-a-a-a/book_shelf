package ru.gulya.bookshelf.data.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "placement")
public class PlacementEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "placement_id")
    private long id;

    @ColumnInfo(name = "placement_title")
    private String title;

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

}
