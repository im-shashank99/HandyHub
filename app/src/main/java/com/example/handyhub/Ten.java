package com.example.handyhub;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class Ten extends AppCompatActivity {
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12;
    FirebaseAuth firebaseAuth;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ten);
        b1 = (Button) findViewById(R.id.button16);
        b2 = (Button) findViewById(R.id.button25);
        b3 = (Button) findViewById(R.id.button5);
        b4 = (Button) findViewById(R.id.button29);
        b5 = (Button) findViewById(R.id.button41);
        b6 = (Button) findViewById(R.id.button40);
        b7 = (Button) findViewById(R.id.button22);
        b8 = (Button) findViewById(R.id.button23);
        b9 = (Button) findViewById(R.id.button24);
        b10 = (Button) findViewById(R.id.button26);
        b11 = (Button) findViewById(R.id.button27);
        b12 = (Button) findViewById(R.id.button28);
        firebaseAuth = FirebaseAuth.getInstance();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth.signOut();
                Intent i = new Intent(Ten.this, Second.class);
                startActivity(i);
                finish();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Ten.this, Twelve.class);
                startActivity(i);
                finish();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Ten.this, Thirteen.class);
                startActivity(i);
                finish();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Ten.this, Eighteen.class);
                startActivity(i);
                finish();
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Ten.this, Fourteen.class);
                startActivity(i);
                finish();
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Ten.this, Sixteen.class);
                startActivity(i);
                finish();
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Ten.this, Twenty.class);
                startActivity(i);
                finish();
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Ten.this, Seventeen.class);
                startActivity(i);
                finish();
            }
        });
        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Ten.this, Fifteen.class);
                startActivity(i);
                finish();
            }
        });
    }
}