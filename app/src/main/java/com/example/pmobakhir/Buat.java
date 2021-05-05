package com.example.pmobakhir;


import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Buat extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    Button ton1, ton2;
    EditText text1, text2, text3, text4, text5, text6, text7, text8, text9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buat);

        dbHelper = new DataHelper(this);
        text1 = (EditText) findViewById(R.id.editText1);
        text2 = (EditText) findViewById(R.id.editText2);
        text3 = (EditText) findViewById(R.id.editText3);
        text4 = (EditText) findViewById(R.id.editText4);
        text5 = (EditText) findViewById(R.id.editText5);
        text6 = (EditText) findViewById(R.id.editText6);
        text7 = (EditText) findViewById(R.id.editText7);
        text8 = (EditText) findViewById(R.id.editText8);
        text9 = (EditText) findViewById(R.id.editText9);
        ton1 = (Button) findViewById(R.id.button1);
        ton2 = (Button) findViewById(R.id.button2);

        ton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("insert into tblspbu(no, nama, alamat, jam, fasilitas, urimap, lat, long, im) values('" +
                        text1.getText().toString()+"','"+
                        text2.getText().toString() +"','" +
                        text3.getText().toString()+"','"+
                        text4.getText().toString() +"','" +
                        text5.getText().toString() +"','" +
                        text6.getText().toString() +"','" +
                        text7.getText().toString() +"','" +
                        text8.getText().toString() +"','" +
                        text9.getText().toString() + "')");
                Toast.makeText(getApplicationContext(),"Berhasil Buat", Toast.LENGTH_LONG).show();
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
