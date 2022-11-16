package com.android.dynamic_sticker_maker.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.Model.StickerListing;
import com.android.dynamic_sticker_maker.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StickerAdapter extends RecyclerView.Adapter<StickerAdapter.Viewholder> {
    List<StickerListing> list;
    public StickerAdapter(List<StickerListing> stickerListingList) {
        this.list=stickerListingList;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.sticker_itemview_lyt, parent, false);
        Viewholder viewHolder = new Viewholder(listItem);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
    StickerListing stickerListing=list.get(position);
    holder.imageView.setImageResource(R.drawable.ic_baseline_sentiment_satisfied_alt_24);
    holder.textView.setText(stickerListing.getCategory());

    }

    @Override
    public int getItemCount() {
        return list.size();

    }

    public class Viewholder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public ImageView imageView2;
        public ImageView imageView3;
        public TextView textView;
        public Viewholder(@NonNull View itemView) {
            super(itemView);

            this.imageView = (ImageView) itemView.findViewById(R.id.stk_img1);
            this.imageView2 = (ImageView) itemView.findViewById(R.id.stk_img2);
            this.imageView3 = (ImageView) itemView.findViewById(R.id.stk_img3);

            this.textView = (TextView) itemView.findViewById(R.id.category_tv);
        }
    }
}
