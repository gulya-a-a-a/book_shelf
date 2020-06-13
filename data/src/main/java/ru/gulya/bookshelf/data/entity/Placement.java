package ru.gulya.bookshelf.data.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "placement")
public class Placement {
    @PrimaryKey(autoGenerate = true)
    private long id;

    private String title;
}
