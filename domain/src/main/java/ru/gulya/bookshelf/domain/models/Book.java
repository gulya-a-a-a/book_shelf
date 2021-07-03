package ru.gulya.bookshelf.domain.models;

import java.io.Serializable;

public class Book implements Serializable {

    private BookShortInfo mBook;

    private Author mAuthor;
    private Shelf mShelf;
    private Placement mPlacement;
    private Bookcase mBookcase;

    public Book() {
        this(0);
    }

    public Book(long id) {
        mBook = new BookShortInfo(id);
        this.mBook.setId(id);
    }

    public Placement getPlacement() {
        return mPlacement;
    }

    public void setPlacement(Placement placement) {
        mPlacement = placement;
    }

    public Bookcase getBookcase() {
        return mBookcase;
    }

    public void setBookcase(Bookcase bookcase) {
        mBookcase = bookcase;
    }

    public long getId() {
        return mBook.getId();
    }

    public void setId(long id) {
        this.mBook.setId(id);
    }

    public String getTitle() {
        return mBook.getTitle();
    }

    public void setTitle(String title) {
        this.mBook.setTitle(title);
    }

    public int getYear() {
        return mBook.getYear();
    }

    public void setYear(int year) {
        this.mBook.setYear(year);
    }

    public String getDescription() {
        return mBook.getDescription();
    }

    public void setDescription(String description) {
        this.mBook.setDescription(description);
    }

    public long getOrder() {
        return mBook.getOrder();
    }

    public void setOrder(long order) {
        this.mBook.setOrder(order);
    }

    public void setAuthorId(long id) {
        mBook.setAuthorId(id);
        if (mAuthor == null) mAuthor = new Author(id);
        else mAuthor.setId(id);
    }

    public long getAuthorId() {
        return mBook.getAuthorId();
    }

    public void setShelfId(long id) {
        mBook.setShelfId(id);
        if (mShelf == null) mShelf = new Shelf(id);
        else mShelf.setId(id);
    }

    public long getShelfId() {
        return mBook.getShelfId();
    }

    public Author getAuthor() {
        if (mAuthor == null)
            mAuthor = new Author(0);
        return mAuthor;
    }

    public void setAuthor(Author author) {
        mAuthor = author;
        mBook.setAuthorId(author.getId());
    }

    public Shelf getShelf() {
        return mShelf;
    }

    public void setShelf(Shelf shelf) {
        mShelf = shelf;
        mBook.setShelfId(shelf.getId());
    }

    public BookShortInfo getBookInfo() {
        return mBook;
    }

    public void setBookInfo(BookShortInfo book) {
        mBook = book;
    }
}
