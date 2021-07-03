package ru.gulya.bookshelf.presentation.views.adapters;

import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.List;

public abstract class BaseListAdapter<T, ViewHolder extends RecyclerView.ViewHolder>
        extends RecyclerView.Adapter<ViewHolder> {

    protected OnItemClickListener<T> mOnItemClickListener;

    protected List<T> mItemsList;

    public BaseListAdapter() {
        mItemsList = Collections.emptyList();
    }

    @Override
    public int getItemCount() {
        return mItemsList.size();
    }

    public void setItemList(List<T> itemsList) {
        mItemsList = itemsList;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener<T> onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener<T> {
        void onItemClicked(T item);
    }
}
