package com.example.handyhub;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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

public class Nine extends AppCompatActivity {
    EditText e1, e2;
    Button b1, b2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_nine);
        e1 = (EditText) findViewById(R.id.editTextText);
        e2 = (EditText) findViewById(R.id.editTextText2);
        b1 = (Button) findViewById(R.id.button14);
        b2 = (Button) findViewById(R.id.button15);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Nine.this, Third.class);
                startActivity(i);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = e1.getText().toString().trim();
                String s2 = e2.getText().toString();
                if (s1.equals("") | s2.equals("")) {
                    Toast.makeText(Nine.this, "Fill all.", Toast.LENGTH_SHORT).show();
                } else {
                    SQLiteDatabase data = openOrCreateDatabase("db", MODE_PRIVATE, null);
                    data.execSQL("create table if not exists tab(name varchar, email varchar, password varchar)");
                    String query = "select * from tab where(email='" + s1 + "' and password='" + s2 + "')";
                    Cursor cursor = data.rawQuery(query, null);
                    if (cursor.getCount() > 0) {
                        Toast.makeText(Nine.this, "Login successful.", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(Nine.this, Ten.class);
                        startActivity(i);
                        finish();
                    } else {
                        Toast.makeText(Nine.this, "Failed!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}