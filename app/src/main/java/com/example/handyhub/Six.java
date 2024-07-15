package com.example.handyhub;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Six extends AppCompatActivity {
    EditText e1, e2, e3;
    Button b1, b2;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_six);
        b1 = (Button) findViewById(R.id.button7);
        b2 = (Button) findViewById(R.id.button12);
        e1 = (EditText) findViewById(R.id.editTextText8);
        e2 = (EditText) findViewById(R.id.editTextText7);
        e3 = (EditText) findViewById(R.id.editTextText9);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString().trim();
                String s3 = e3.getText().toString();
                if (s1.equals("") | s2.equals("") | s3.equals("")) {
                    Toast.makeText(Six.this, "Please fill all.", Toast.LENGTH_SHORT).show();
                } else {
                    SQLiteDatabase data = openOrCreateDatabase("db", MODE_PRIVATE, null);
                    data.execSQL("create table if not exists tab(name varchar, email varchar, password varchar)");
                    String query = "select * from tab where(name='" + s1 + "' and email='" + s2 + "')";
                    Cursor cursor = data.rawQuery(query, null);
                    if (cursor.getCount() > 0) {
                        Toast.makeText(Six.this, "User already registered.", Toast.LENGTH_SHORT).show();
                    } else {
                        data.execSQL("insert into tab values('" + s1 + "', '" + s2 + "', '" + s3 +"')");
                        Toast.makeText(Six.this, "Database updated.", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(Six.this, Second.class);
                        startActivity(i);
                        finish();
                    }

                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Six.this, Fourth.class);
                startActivity(i);
                finish();
            }
        });
    }
}