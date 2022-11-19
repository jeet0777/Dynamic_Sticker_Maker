package com.android.dynamic_sticker_maker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.Model.ImageList;
import com.android.Model.StickerListing;
import com.android.dynamic_sticker_maker.Adapter.StickerAdapter;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class MainScreen extends AppCompatActivity {
    RecyclerView rv;
    public static List<StickerListing> stickerListingList;
    List<List<ImageList>> superImageList=new ArrayList<>();
    List<ImageList> imgList;
    ImageView imgv;
    String path;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        rv=findViewById(R.id.rv_sticker_list);
//       stickerListingList=new ArrayList<>();
       imgList=new ArrayList<>();
        imgv = findViewById(R.id.tempImage);
    for(int i=0;i!=stickerListingList.size();i++)
    {
        StorageReference storageReference=FirebaseStorage.getInstance().getReference("/");

        storageReference.child(stickerListingList.get(i).getCategory()).listAll().addOnSuccessListener(new OnSuccessListener<ListResult>() {
            @Override
            public void onSuccess(ListResult listResult) {

                for(StorageReference ref:listResult.getItems()){
                    ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            path=uri.toString();
                            imgList.add(new ImageList(path));
                            Log.d("TAG33",path);

                        }
                    });
                }//Loop: iamge for each folder
            superImageList.add(imgList);
         imgList.clear();       //setadapter();


            }




        });


if(i==2){
    StickerAdapter stickerAdapter=new StickerAdapter(stickerListingList,superImageList);
    rv.setHasFixedSize(true);
    rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    rv.setAdapter(stickerAdapter);
break;
}

    }




    }

    private void setadapter() {

    }
}