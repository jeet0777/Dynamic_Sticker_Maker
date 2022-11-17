package com.android.Model;

import android.graphics.Bitmap;
import android.widget.ImageView;

public class StickerListing {
    private final String Category;

    public StickerListing(String category) {
        Category = category;
    }


    public String getCategory() {
        return Category;
    }
}

