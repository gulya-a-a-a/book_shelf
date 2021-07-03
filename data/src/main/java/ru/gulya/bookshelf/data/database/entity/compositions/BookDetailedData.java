package ru.gulya.bookshelf.data.database.entity.compositions;

import androidx.room.Embedded;

import ru.gulya.bookshelf.data.database.entity.AuthorEntity;
import ru.gulya.bookshelf.data.database.entity.BookEntity;
import ru.gulya.bookshelf.data.database.entity.BookcaseEntity;
import ru.gulya.bookshelf.data.database.entity.PlacementEntity;
import ru.gulya.bookshelf.data.database.entity.ShelfEntity;

public class BookDetailedData {
    @Embedded
    private BookEntity mBookEntity;

    @Embedded
    private AuthorEntity mAuthorEntity;

    @Embedded
    private ShelfEntity mShelfEntity;

    @Embedded
    private BookcaseEntity mBookcaseEntity;

    @Embedded
    private PlacementEntity mPlacementEntity;

    public BookEntity getBookEntity() {
        return mBookEntity;
    }

    public void setBookEntity(BookEntity bookEntity) {
        mBookEntity = bookEntity;
    }

    public AuthorEntity getAuthorEntity() {
        return mAuthorEntity;
    }

    public void setAuthorEntity(AuthorEntity authorEntity) {
        mAuthorEntity = authorEntity;
    }

    public ShelfEntity getShelfEntity() {
        return mShelfEntity;
    }

    public void setShelfEntity(ShelfEntity shelfEntity) {
        mShelfEntity = shelfEntity;
    }

    public BookcaseEntity getBookcaseEntity() {
        return mBookcaseEntity;
    }

    public void setBookcaseEntity(BookcaseEntity bookcaseEntity) {
        mBookcaseEntity = bookcaseEntity;
    }

    public PlacementEntity getPlacementEntity() {
        return mPlacementEntity;
    }

    public void setPlacementEntity(PlacementEntity placementEntity) {
        mPlacementEntity = placementEntity;
    }
}
