package com.example.pmobakhir;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class Signup extends AppCompatActivity {

    protected Cursor cursor;
    DataHelper dbHelper;
    Button signup;
    EditText text1, text2, text3, text4, text5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        dbHelper = new DataHelper(this);
        text1 = (EditText) findViewById(R.id.nik);
        text2 = (EditText) findViewById(R.id.nama);
        text3 = (EditText) findViewById(R.id.passi);
        text4 = (EditText) findViewById(R.id.userni);
        text5 = (EditText) findViewById(R.id.alamato);
        signup = (Button) findViewById(R.id.btnSignup);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("insert into tbluser(no, nama, alamat, username, password) values('" +
                        text1.getText().toString()+"','"+
                        text2.getText().toString() +"','" +
                        text3.getText().toString()+"','"+
                        text4.getText().toString() +"','" +
                        text5.getText().toString() + "')");
                Toast.makeText(getApplicationContext(),"Berhasil Buat Akun", Toast.LENGTH_LONG).show();
                Login.ma.RefreshList();
                finish();
            }
        });

    }



}