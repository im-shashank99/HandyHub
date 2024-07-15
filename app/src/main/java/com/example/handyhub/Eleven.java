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
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class Eleven extends AppCompatActivity {
    EditText e1;
    Button b1;
    String phone, otp;
    FirebaseAuth firebaseAuth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_eleven);
        phone=getIntent().getStringExtra("mobile").toString();
        e1=(EditText) findViewById(R.id.editTextText10);
        b1=(Button) findViewById(R.id.button19);
        firebaseAuth=FirebaseAuth.getInstance();
        genotp();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e1.getText().toString();
                if(s1.isEmpty()){
                    Toast.makeText(Eleven.this, "Fill it.", Toast.LENGTH_SHORT).show();
                }else{
                    if(s1.length()!=6){
                        Toast.makeText(Eleven.this, "Very bad", Toast.LENGTH_SHORT).show();
                    }else{
                        PhoneAuthCredential credential= PhoneAuthProvider.getCredential(otp,s1);
                        signInWithPhoneAuthCredential(credential);
                    }
                }
            }
        });
    }private void genotp()
    {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phone,
                60,
                TimeUnit.SECONDS,
                this,
                new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                    @Override
                    public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                        super.onCodeSent(s, forceResendingToken);
                        otp=s;
                    }
                    @Override
                    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                        signInWithPhoneAuthCredential(phoneAuthCredential);
                    }

                    @Override
                    public void onVerificationFailed(@NonNull FirebaseException e) {
                        Toast.makeText(Eleven.this, "OTP mismatch", Toast.LENGTH_SHORT).show();

                    }
                }
        );
    }
    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential)
    {
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(Eleven.this, "Database updated", Toast.LENGTH_SHORT).show();
                    Intent k=new Intent(Eleven.this,Ten.class);
                    startActivity(k);
                    finish();
                }
                else {
                    Toast.makeText(Eleven.this, "Database not updated", Toast.LENGTH_SHORT).show();
                }
            }
   });



    }
}