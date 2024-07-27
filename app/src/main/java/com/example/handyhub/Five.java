package com.example.handyhub;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Five extends AppCompatActivity {
    EditText e1, e2, e3, e4;
    Button b1, b2;
    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_five);
        b1 = (Button) findViewById(R.id.button6);
        b2 = (Button) findViewById(R.id.button13);
        e1 = (EditText) findViewById(R.id.editTextText5);
        e2 = (EditText) findViewById(R.id.editTextText11);
        e3 = (EditText) findViewById(R.id.editTextText4);
        e4 = (EditText) findViewById(R.id.editTextText6);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Five.this, Fourth.class);
                startActivity(i);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference = firebaseDatabase.getReference("Users");
                String s3 = e1.getText().toString();
                String s4 = e2.getText().toString();
                String s1 = e3.getText().toString();
                String s2 = e4.getText().toString();
                if (s1.isEmpty()) {
                    e1.setError("fill email");
                    return;
                } else {
                    if (s2.isEmpty()) {
                        e2.setError("fill password");
                    } else {
                        firebaseAuth.createUserWithEmailAndPassword(s1, s2).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    if (s4.length() != 10) {
                                        Toast.makeText(Five.this, "Wrong number", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Users users = new Users(s3, s4, s1, s2);
                                        databaseReference.child(s4).setValue(users);
                                    }
                                    Toast.makeText(Five.this, "database updated", Toast.LENGTH_SHORT).show();
                                    Intent j = new Intent(Five.this, Second.class);
                                    startActivity(j);
                                    finish();
                                } else {
                                    Toast.makeText(Five.this, "database not updated", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                }
            }
        });
    }
}