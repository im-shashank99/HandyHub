package com.example.handyhub;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Twenty extends AppCompatActivity {
    Button b1;
    EditText e1, e2;
    private int REQUEST_SMS_PERMISSION = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_twenty);
        b1 = (Button) findViewById(R.id.button34);
        e1 = (EditText) findViewById(R.id.editTextText15);
        e2 = (EditText) findViewById(R.id.editTextText16);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNo = e1.getText().toString().trim();
                String msg = e2.getText().toString().trim();
                if (phoneNo.equals("") || msg.equals("")) {
                    Toast.makeText(Twenty.this, "Fill both the sections.", Toast.LENGTH_SHORT).show();
                } else {
                    sendSMS(phoneNo, msg);
                }
            }
        });
//        if (ContextCompat.checkSelfPermission(Twenty.this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(Twenty.this, new String[]{Manifest.permission.SEND_SMS}, REQUEST_SMS_PERMISSION);
//        }
    }
    private void sendSMS(String phoneNo, String msg) {
        try {
            SmsManager sm = SmsManager.getDefault();
            sm.sendTextMessage(phoneNo, null, msg, null, null);
            Toast.makeText(Twenty.this, "Message sent!", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(Twenty.this, "Failed to send a message", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_SMS_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(Twenty.this, "SMS permission granted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(Twenty.this, "SMS permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
}