package ru.gulya.bookshelf.data.database.entity.compositions;

import androidx.room.Embedded;

import ru.gulya.bookshelf.data.database.entity.BookcaseEntity;
import ru.gulya.bookshelf.data.database.entity.ShelfEntity;

public class ShelfDetailedData {

    @Embedded
    ShelfEntity mShelfEntity;

    @Embedded
    BookcaseEntity mBookcaseEntity;

}
