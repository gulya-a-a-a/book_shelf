package ru.gulya.bookshelf.presentation.views.adapters.author;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import javax.inject.Inject;

import ru.gulya.bookshelf.domain.models.Author;
import ru.gulya.bookshelf.presentation.R;
import ru.gulya.bookshelf.presentation.views.adapters.BaseListAdapter;

public class AuthorListAdapter extends BaseListAdapter<Author, AuthorListAdapter.AuthorViewHolder> {

    @Inject
    public AuthorListAdapter() {
        super();
    }

    @NonNull
    @Override
    public AuthorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new AuthorViewHolder(inflater, parent);
    }

    @Override
    public void onBindViewHolder(@NonNull AuthorViewHolder holder, int position) {
        holder.bindData(mItemsList.get(position));
    }

    class AuthorViewHolder extends RecyclerView.ViewHolder {
        TextView mAuthorFirstName, mAuthorSurname;

        public AuthorViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
            super(inflater.inflate(R.layout.author_list_item, parent, false));
            initControls();
        }

        private void initControls() {
            mAuthorFirstName = itemView.findViewById(R.id.tv_author_list_firstname);
            mAuthorSurname = itemView.findViewById(R.id.tv_author_list_surname);
        }

        private void bindData(Author author) {
            mAuthorFirstName.setText(author.getFirstName());
            mAuthorSurname.setText(author.getSurname());
            itemView.setOnClickListener(v -> {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClicked(author);
                }
            });
        }
    }
}
