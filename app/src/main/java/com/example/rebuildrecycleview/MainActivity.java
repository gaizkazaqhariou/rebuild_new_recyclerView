package com.example.rebuildrecycleview;

import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

//import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.example.rebuildrecycleview.adapter.HotelAdapter;
import com.example.rebuildrecycleview.model.Hotel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Hotel> mList = new ArrayList<>();
    HotelAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mAdapter = new HotelAdapter(mList);
        recyclerView.setAdapter(mAdapter);

        this.fillData();
    }

    private void fillData() {
        Resources resources = getResources();
        String [] Judul = resources.getStringArray(R.array.places);
        String [] Deskripsi = resources.getStringArray(R.array.place_desc);
        TypedArray a = resources.obtainTypedArray(R.array.places_picture);
        Drawable [] Foto = new Drawable[a.length()];
        for (int i = 0; i < Foto.length; i++) {
            Foto[i] = a.getDrawable(i);
        }
        a.recycle();

        for (int i = 0; i < Judul.length; i++){
            mList.add(new Hotel(Judul[i], Deskripsi[i], Foto[i]));
        }
        mAdapter.notifyDataSetChanged();
    }
}