package com.android.dynamic_sticker_maker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.Model.StickerListing;
import com.android.dynamic_sticker_maker.Adapter.StickerAdapter;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

public class MainScreen extends AppCompatActivity {
RecyclerView rv;
List<StickerListing> stickerListingList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
    rv=findViewById(R.id.rv_sticker_list);
stickerListingList=new ArrayList<>();

        StorageReference folderref= FirebaseStorage.getInstance().getReference("/");
folderref.listAll().addOnSuccessListener(new OnSuccessListener<ListResult>() {
    @Override
    public void onSuccess(ListResult listResult) {


        for (StorageReference prefix : listResult.getPrefixes()) {
Log.d("TAG333",prefix.getName());
        stickerListingList.add(new StickerListing(
                R.drawable.ic_baseline_sentiment_satisfied_alt_24,
                prefix.getName()
                ));

   }
        for (StorageReference item : listResult.getItems()) {
            // All the items under the folder would here available.

        }


        StickerAdapter stickerAdapter=new StickerAdapter(stickerListingList);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rv.setAdapter(stickerAdapter);

    }
}).addOnCanceledListener(new OnCanceledListener() {
    @Override
    public void onCanceled() {
    }

});




    }
}