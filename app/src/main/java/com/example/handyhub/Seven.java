package com.example.handyhub;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
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

public class Seven extends AppCompatActivity {
    EditText e1, e2;
    Button b1, b2;
    FirebaseAuth firebaseAuth;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_seven);
        b1 = (Button) findViewById(R.id.button20);
        b2 = (Button) findViewById(R.id.button21);
        e1 = (EditText) findViewById(R.id.editTextText12);
        e2 = (EditText) findViewById(R.id.editTextText13);
        e2.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
        firebaseAuth = FirebaseAuth.getInstance();
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Seven.this, Third.class);
                startActivity(i);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = e1.getText().toString().trim();
                String s2 = e2.getText().toString();
                if (s1.isEmpty()) {
                    e1.setError("Fill email");
                    return;
                } else {
                    if (s2.isEmpty()) {
                        e2.setError("Fill password");
                        return;
                    } else {
                        firebaseAuth.signInWithEmailAndPassword(s1, s2).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(Seven.this, "Logged in", Toast.LENGTH_SHORT).show();
                                    Intent k = new Intent(Seven.this, Ten.class);
                                    startActivity(k);
                                    finish();
                                } else {
                                    Toast.makeText(Seven.this, "Mismatched      ", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                }

            }
        });
    }
}