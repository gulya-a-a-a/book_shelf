package ru.gulya.bookshelf.presentation.views.adapters.book;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import ru.gulya.bookshelf.presentation.R;
import ru.gulya.bookshelf.domain.models.Book;

public class BookListAdapter extends RecyclerView.Adapter<BookListAdapter.BookViewHolder> {

    public interface OnBookClickListener {
        void onBookClicked(Book book);
    }

    private OnBookClickListener mOnBookClickListener;

    List<Book> mBookList;

    @Inject
    public BookListAdapter() {
        mBookList = Collections.emptyList();
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new BookViewHolder(inflater, parent);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        holder.bindData(mBookList.get(position));
    }

    @Override
    public int getItemCount() {
        return mBookList.size();
    }

    public void setBookList(List<Book> bookList) {
        mBookList = bookList;
        notifyDataSetChanged();
    }

    public void setOnBookClickListener(OnBookClickListener onBookClickListener) {
        mOnBookClickListener = onBookClickListener;
    }

    class BookViewHolder extends RecyclerView.ViewHolder {
        TextView mBookTitle, mAuthorName;

        public BookViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
            super(inflater.inflate(R.layout.book_list_item, parent, false));
            initControls();
        }

        private void initControls() {
            mBookTitle = itemView.findViewById(R.id.tv_book_title);
            mAuthorName = itemView.findViewById(R.id.tv_author_name);
        }

        private void bindData(Book book) {
            mBookTitle.setText(book.getTitle());
            itemView.setOnClickListener(v -> {
                if (mOnBookClickListener != null) {
                    mOnBookClickListener.onBookClicked(book);
                }
            });
        }
    }
}
