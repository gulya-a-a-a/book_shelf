package ru.gulya.bookshelf.data.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "authors")
public class Author {
    @PrimaryKey(autoGenerate = true)
    private long id;

    private String firstName;
    private String surname;

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
