package com.android.Model;

import android.graphics.Bitmap;
import android.widget.ImageView;

public class StickerListing {
    private Object stk_imageview;
    private String Category;

    public StickerListing(Object stk_imageview, String category) {
        this.stk_imageview = stk_imageview;
        Category = category;
    }

    public Object getStk_imageview() {
        return stk_imageview;
    }

    public String getCategory() {
        return Category;
    }
}

