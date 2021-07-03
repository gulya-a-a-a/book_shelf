package ru.gulya.bookshelf.presentation.views.adapters.book;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import javax.inject.Inject;

import ru.gulya.bookshelf.presentation.R;
import ru.gulya.bookshelf.domain.models.Book;
import ru.gulya.bookshelf.presentation.views.adapters.BaseListAdapter;

public class BookListAdapter extends BaseListAdapter<Book, BookListAdapter.BookViewHolder> {

    @Inject
    public BookListAdapter() {
        super();
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new BookViewHolder(inflater, parent);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        holder.bindData(mItemsList.get(position));
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
            mAuthorName.setText(book.getAuthor().toString());
            itemView.setOnClickListener(v -> {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClicked(book);
                }
            });
        }
    }
}
