package com.example.pmobakhir;


import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;
import android.widget.Toast;

public class Update extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    Button ton1, ton2;
    EditText text1, text2, text3, text4, text5, text6, text7, text8, text9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        dbHelper = new DataHelper(this);
        text1 = (EditText) findViewById(R.id.editTextup1);
        text2 = (EditText) findViewById(R.id.editTextup2);
        text3 = (EditText) findViewById(R.id.editTextup3);
        text4 = (EditText) findViewById(R.id.editTextup4);
        text5 = (EditText) findViewById(R.id.editTextup5);
        text6 = (EditText) findViewById(R.id.editTextup6);
        text7 = (EditText) findViewById(R.id.editTextup7);
        text8 = (EditText) findViewById(R.id.editTextup8);
        text9 = (EditText) findViewById(R.id.editTextup9);

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM tblspbu WHERE nama = '" +
                getIntent().getStringExtra("nama") + "'",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0)
        {
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
        ton1 = (Button) findViewById(R.id.button1);
        ton2 = (Button) findViewById(R.id.button2);
        // daftarkan even onClick pada btnSimpan
        ton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("update tblspbu set nama='"+
                        text2.getText().toString() +"', alamat='" +
                        text3.getText().toString() +"', jam='"+
                        text4.getText().toString() +"', fasilitas='" +
                        text5.getText().toString() +"', urimap='" +
                        text6.getText().toString() +"', lat='" +
                        text7.getText().toString() +"', long='" +
                        text8.getText().toString() +"', im='" +
                        text9.getText().toString() +"' where no='" +
                        text1.getText().toString()+"'");
                Toast.makeText(getApplicationContext(), "Berhasil Update", Toast.LENGTH_LONG).show();
                MainActivity2.ma.RefreshList();
                finish();
            }
        });
        ton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                finish();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the main; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}