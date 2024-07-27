package com.example.handyhub;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class Fifteen extends AppCompatActivity {
    Button b12, b13;
    EditText e1;
    TextToSpeech ts;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fifteen);
        b12 = (Button) findViewById(R.id.button51);
        b13 = (Button) findViewById(R.id.button52);
        e1 = (EditText) findViewById(R.id.editTextText14);
        ts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                ts.setLanguage(Locale.ENGLISH);
                ts.setSpeechRate(0.7f);
            }
        });
        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = e1.getText().toString();
                ts.speak(s, TextToSpeech.QUEUE_FLUSH, null);
                Toast.makeText(Fifteen.this, "Your text: " + s, Toast.LENGTH_SHORT).show();
            }
        });
        b13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ts.speak("Back to index", TextToSpeech.QUEUE_FLUSH, null);
                Intent i = new Intent(Fifteen.this, Ten.class);
                startActivity(i);
                finish();
            }
        });
    }
}