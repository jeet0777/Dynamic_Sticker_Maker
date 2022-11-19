package com.android.dynamic_sticker_maker.Adapter;

import android.graphics.Bitmap;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.Model.ImageList;
import com.android.Model.StickerListing;
import com.android.dynamic_sticker_maker.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StickerAdapter extends RecyclerView.Adapter<StickerAdapter.Viewholder> {
    List<StickerListing> list;
    List<List<ImageList>> imgList;
    int counter = 0;
    public StickerAdapter(List<StickerListing> stickerListingList,List<List<ImageList>> imgList) {
        this.list=stickerListingList;
        this.imgList = imgList;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.sticker_itemview_lyt, parent, false);
        return new Viewholder(listItem);

    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
    StickerListing stickerListing=list.get(position);


   // for(int i=0;i<=2;i++){

        Picasso.get().load(String.valueOf(
                imgList.get(0).get(0).getImagePath())).into(holder.imageView);
    Picasso.get().load(String.valueOf(
                imgList.get(0).get(0).getImagePath())).into(holder.imageView2);
    Picasso.get().load(String.valueOf(
                imgList.get(0).get(0).getImagePath())).into(holder.imageView3);



    //}


    holder.textView.setText(stickerListing.getCategory());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class Viewholder extends RecyclerView.ViewHolder {

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
