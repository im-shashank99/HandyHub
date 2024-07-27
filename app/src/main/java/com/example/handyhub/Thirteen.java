package com.example.handyhub;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class Thirteen extends AppCompatActivity {
    EditText e2, e3;
    TextView t5;
    Button b14, b15, b16, b17, b18;
    TextToSpeech ts;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_thirteen);
        e2 = (EditText) findViewById(R.id.editText14);
        e3 = (EditText) findViewById(R.id.editText15);
        t5 = (TextView) findViewById(R.id.textView5);
        b14 = (Button) findViewById(R.id.button36);
        b15 = (Button) findViewById(R.id.button42);
        b16 = (Button) findViewById(R.id.button43);
        b17 = (Button) findViewById(R.id.button44);
        b18 = (Button) findViewById(R.id.button45);
        ts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                ts.setLanguage(Locale.ENGLISH);
                ts.setSpeechRate(0.8f);
            }
        });
        b14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Float f1 = Float.parseFloat(e2.getText().toString());
                Float f2 = Float.parseFloat(e3.getText().toString());
                String s = Float.toString(f1 + f2);
                ts.speak("The addition result is" + s, TextToSpeech.QUEUE_FLUSH, null);
                Toast.makeText(Thirteen.this, "Addition: " + s, Toast.LENGTH_SHORT).show();
                t5.setText(s);
            }
        });
        b15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Float f1 = Float.parseFloat(e2.getText().toString());
                Float f2 = Float.parseFloat(e3.getText().toString());
                String s = Float.toString(f1 - f2);
                ts.speak("The subtraction result is" + s, TextToSpeech.QUEUE_FLUSH, null);
                Toast.makeText(Thirteen.this, "Subtraction: " + s, Toast.LENGTH_SHORT).show();
                t5.setText(s);
            }
        });
        b16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Float f1 = Float.parseFloat(e2.getText().toString());
                Float f2 = Float.parseFloat(e3.getText().toString());
                String s = Float.toString(f1 * f2);
                ts.speak("The multiplication result is" + s, TextToSpeech.QUEUE_FLUSH, null);
                Toast.makeText(Thirteen.this, "Multiplication: " + s, Toast.LENGTH_SHORT).show();
                t5.setText(s);
            }
        });
        b17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Float f1 = Float.parseFloat(e2.getText().toString());
                Float f2 = Float.parseFloat(e3.getText().toString());
                String s = Float.toString(f1 / f2);
                ts.speak("The division result is" + s, TextToSpeech.QUEUE_FLUSH, null);
                Toast.makeText(Thirteen.this, "Division: " + s, Toast.LENGTH_SHORT).show();
                t5.setText(s);
            }
        });
        b18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ts.speak("Back to index", TextToSpeech.QUEUE_FLUSH, null);
                Intent i = new Intent(Thirteen.this, Ten.class);
                startActivity(i);
                finish();
            }
        });
    }
}