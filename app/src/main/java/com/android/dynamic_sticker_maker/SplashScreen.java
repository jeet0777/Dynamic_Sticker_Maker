package com.android.dynamic_sticker_maker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.android.Model.StickerListing;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

import static com.android.dynamic_sticker_maker.MainScreen.stickerListingList;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        stickerListingList=new ArrayList<>();

        StorageReference folderref= FirebaseStorage.getInstance().getReference("/");
        folderref.listAll().addOnSuccessListener(new OnSuccessListener<ListResult>() {

            @Override
            public void onSuccess(ListResult listResult) {

                for (StorageReference prefix : listResult.getPrefixes()) {
                    Log.d("TAG333",prefix.getName());
                    stickerListingList.add(new StickerListing(prefix.getName()));

//added all folder Done

//            StickerAdapter stickerAdapter=new StickerAdapter(stickerListingList,imgList);
//            rv.setHasFixedSize(true);
//            rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
//            rv.setAdapter(stickerAdapter);


                }//folder fetched
startActivity(new Intent(getApplicationContext(),MainScreen.class));
            }



        });




    }
}