package ru.gulya.bookshelf.data.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "bookcases",
        foreignKeys = @ForeignKey(entity = Placement.class, parentColumns = "id", childColumns = "room_id")
)
public class Bookcase {
    @PrimaryKey(autoGenerate = true)
    private long id;

    private String title;

    @ColumnInfo(name = "room_id")
    private long roomId;
}
