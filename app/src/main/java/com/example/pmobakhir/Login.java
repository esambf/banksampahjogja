package com.example.pmobakhir;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    String[] daftar;
    ListView ListView01;
    DataHelper dbHelper;
    Button login, signup, admin;
    String password= "";
    EditText username1, password1;
    protected Cursor cursor;
    DataHelper dbcenter;
    public static Login ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        dbHelper = new DataHelper(this);
        login = (Button) findViewById(R.id.btnLogin);
        signup = (Button) findViewById(R.id.btnSignup);
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

        signup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent inte = new Intent(Login.this, Signup.class);
                startActivity(inte);
            }
        });
        login.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent inte = new Intent(Login.this, Login2.class);
                startActivity(inte);
                return true;
            }
        });
        ma = this;
        dbcenter = new DataHelper(this);
        RefreshList();
    }

    public void RefreshList(){
        SQLiteDatabase db = dbcenter.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM tbluser",null);
        daftar = new String[cursor.getCount()];
        cursor.moveToFirst();
        for (int cc=0; cc < cursor.getCount(); cc++){
            cursor.moveToPosition(cc);
            daftar[cc] = cursor.getString(1).toString();
        }

    }

    private void autentikasi (String username){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM tbluser WHERE username = '" + username +"'", null);
        cursor.moveToFirst();

        if(cursor.getCount() > 0) {
            cursor.moveToPosition(0);
            password = cursor.getString(2).toString();
        }

        if(password.equalsIgnoreCase(password1.getText().toString())){
            Toast.makeText(getApplicationContext(),"Login Berhasil", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(Login.this, MainActivity.class);
            startActivity(intent);
        }

        else{
            AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
            builder.setMessage("Username atau Password salah!").setNegativeButton("Retry", null).create().show();
        }
    }

    @Override
    public void onBackPressed(){moveTaskToBack(true);}

}