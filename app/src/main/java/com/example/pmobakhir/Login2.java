package com.example.pmobakhir;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Login2 extends AppCompatActivity {

    protected Cursor cursor;
    DataHelper dbHelper;
    Button login, back;
    String password= "";
    EditText username1, password1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        dbHelper = new DataHelper(this);
        login = (Button) findViewById(R.id.btnLogin2);
        back = (Button) findViewById(R.id.btnBack2);
        username1 = (EditText) findViewById(R.id.usern);
        password1 = (EditText) findViewById(R.id.pass);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                if (password1.length()==0 || username1.length()==0) {
                    Toast.makeText(getApplication(), "Username atau Password Harus diisi!", Toast.LENGTH_SHORT).show();
                }
                else{ autentikasi(username1.getText().toString());}
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                finish();
            }
        });
    }

    private void autentikasi (String username){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM tbladmin WHERE username = '" + username +"'", null);
        cursor.moveToFirst();

        if(cursor.getCount() > 0) {
            cursor.moveToPosition(0);
            password = cursor.getString(2).toString();
        }

        if(password.equalsIgnoreCase(password1.getText().toString())){
            Toast.makeText(getApplicationContext(),"Login Berhasil", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(Login2.this, MainActivity2.class);
            startActivity(intent);
        }

        else{
            AlertDialog.Builder builder = new AlertDialog.Builder(Login2.this);
            builder.setMessage("Username atau Password salah!").setNegativeButton("Retry", null).create().show();
        }
    }

    @Override
    public void onBackPressed(){moveTaskToBack(true);}

}
