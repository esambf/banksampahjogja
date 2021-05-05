package com.example.pmobakhir;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Lihat extends AppCompatActivity implements OnMapReadyCallback {
    protected Cursor cursor;
    DataHelper dbHelper;
    Button ton2, ton1;
    TextView text1, text2, text3, text4, text5, text6, text7, text8, text9;
    private GoogleMap mMap;
    public static double lla, llo, lah, loh;
    ImageView imageView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat);

        imageView = (ImageView)findViewById(R.id.foto);

        dbHelper = new DataHelper(this);
        text1 = (TextView) findViewById(R.id.textViewliat1);
        text2 = (TextView) findViewById(R.id.textViewliat2);
        text3 = (TextView) findViewById(R.id.textViewliat3);
        text4 = (TextView) findViewById(R.id.textViewliat4);
        text5 = (TextView) findViewById(R.id.textViewliat5);
        text6 = (TextView) findViewById(R.id.textViewliat6);
        text7 = (TextView) findViewById(R.id.textViewliat7);
        text8 = (TextView) findViewById(R.id.textViewliat8);
        text9 = (TextView) findViewById(R.id.textViewliat9);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM tblspbu WHERE nama = '" + getIntent().getStringExtra("nama") + "'", null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            cursor.moveToPosition(0);
            text1.setText(cursor.getString(0).toString());
            text2.setText(cursor.getString(1).toString());
            text3.setText(cursor.getString(2).toString());
            text4.setText(cursor.getString(3).toString());
            text5.setText(cursor.getString(4).toString());
            text6.setText(cursor.getString(5).toString());
            text7.setText(cursor.getString(6).toString());
            text8.setText(cursor.getString(7).toString());
            text9.setText(cursor.getString(8).toString());
        }
        final String maa = text6.getText().toString();
        final String laa = text7.getText().toString();
        final String loo = text8.getText().toString();
        final String urlg = text9.getText().toString();

        lla = Double.parseDouble(laa);
        llo = Double.parseDouble(loo);

        Glide.with(Lihat.this)
                // LOAD URL DARI INTERNET
                .load(urlg)
                // LOAD GAMBAR AWAL SEBELUM GAMBAR UTAMA MUNCUL, BISA DARI LOKAL DAN INTERNET
                .placeholder(R.drawable.load)
                //. LOAD GAMBAR SAAT TERJADI KESALAHAN MEMUAT GMBR UTAMA
                .error(R.drawable.load)
                .into(imageView);

        ton2 = (Button) findViewById(R.id.button1);
        ton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                finish();
            }
        });


        ton1 = (Button) findViewById(R.id.button2);
        ton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(maa)));

            }
        });

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the main; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        lah=lla;
        loh=llo;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(lla, llo);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Lokasi Bank Sampah"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        float zoomLevel = 16.0f; //This goes up to 21
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, zoomLevel));

    }




}
