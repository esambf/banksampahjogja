package com.example.pmobakhir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.text.NumberFormat;
import java.util.Locale;

public class Rekap extends AppCompatActivity {
    TextView pilbs, pilhasil2, pilperiode, pilhasil;
    String texto;
    Spinner spin;
    Button ton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rekap);

        pilbs = (TextView) findViewById(R.id.pil1);
        pilperiode = (TextView) findViewById(R.id.pil2);
        pilhasil = (TextView) findViewById(R.id.pil4);
        pilhasil2 = (TextView) findViewById(R.id.pil5);
        ton2 = (Button) findViewById(R.id.btnBack);

        ton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                finish();
            }
        });


        String harga = getIntent().getExtras().getString("hargap");
        String harga2 = getIntent().getExtras().getString("hargab");
        String periode = getIntent().getExtras().getString("periode");
        int hasil = Integer.parseInt(harga) * 5000;
        int hasil2 = Integer.parseInt(harga2) * 10000 + hasil;
        int hasil3 = (Integer.parseInt(harga2) * 10000 + hasil)*Integer.parseInt(periode);

        pilbs.setText(getIntent().getExtras().getString("bank"));

        pilperiode.setText(periode);
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
        pilhasil.setText(formatRupiah.format((double)hasil2));
        pilhasil2.setText(formatRupiah.format((double)hasil3));
    }
}