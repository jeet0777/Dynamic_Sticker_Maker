package com.android.dynamic_sticker_maker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

public class MainScreen extends AppCompatActivity {
    RecyclerView rv;
    List<StickerListing> stickerListingList;
    List<ImageList> imgList;
    ImageView imgv;
    String path;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        rv=findViewById(R.id.rv_sticker_list);
       stickerListingList=new ArrayList<>();
       imgList=new ArrayList<>();
        imgv = findViewById(R.id.tempImage);


        StorageReference folderref= FirebaseStorage.getInstance().getReference("/");



        folderref.listAll().addOnSuccessListener(new OnSuccessListener<ListResult>() {

        @Override
        public void onSuccess(ListResult listResult) {

        for (StorageReference prefix : listResult.getPrefixes()) {
        Log.d("TAG333",prefix.getName());


            folderref.child(prefix.getName()).listAll().addOnSuccessListener(new OnSuccessListener<ListResult>() {
                @Override
                public void onSuccess(ListResult listResult) {

                    for(StorageReference ref : listResult.getItems()){

                      ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                          @Override
                          public void onSuccess(Uri uri) {
                              path = uri.toString();

                              stickerListingList.add(new StickerListing(prefix.getName()));
                              imgList.add(new ImageList(path));

                          }
                      });



                        Picasso.get().load(path).into(imgv);

                        Toast.makeText(MainScreen.this, ref.getName(), Toast.LENGTH_SHORT).show();
                    }
                }
            });

            StickerAdapter stickerAdapter=new StickerAdapter(stickerListingList,imgList);
            rv.setHasFixedSize(true);
            rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            rv.setAdapter(stickerAdapter);
   }





    }
});




    }
}