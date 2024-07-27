package com.example.handyhub;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Sixteen extends AppCompatActivity {
    ImageButton ib1, ib2, ib3, ib4, ib5;
    Button b19, b20, b21, b22, b23, b24;
    MediaPlayer mp1, mp2, mp3, mp4, mp5;
    TextToSpeech ts;
    private boolean check = false, check1 = false, check2 = false, check3 = false, check4 = false, check5 = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sixteen);
        ib1 = (ImageButton) findViewById(R.id.imageButton2);
        ib2 = (ImageButton) findViewById(R.id.imageButton3);
        ib3 = (ImageButton) findViewById(R.id.imageButton4);
        ib4 = (ImageButton) findViewById(R.id.imageButton5);
        ib5 = (ImageButton) findViewById(R.id.imageButton6);
        b19 = (Button) findViewById(R.id.button53);
        b20 = (Button) findViewById(R.id.button54);
        b21 = (Button) findViewById(R.id.button55);
        b22 = (Button) findViewById(R.id.button56);
        b23 = (Button) findViewById(R.id.button57);
        b24 = (Button) findViewById(R.id.button58);
        mp1 = MediaPlayer.create(this, R.raw.ma);
        mp2 = MediaPlayer.create(this, R.raw.mc);
        mp3 = MediaPlayer.create(this, R.raw.me);
        mp4 = MediaPlayer.create(this, R.raw.md);
        mp5 = MediaPlayer.create(this, R.raw.mb);
        b19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (check == false) {
                    mp1.start();
                    ib1.setImageResource(R.drawable.on);
                    check = true;
                    check1 = true;
                } else {
                    if(check1 == true) {
                        mp1.pause();
                        ib1.setImageResource(R.drawable.off);
                        check = false;
                        check1 = false;
                    } else {
                        check2 = false;
                        check3 = false;
                        check4 = false;
                        check5 = false;
                        mp2.pause();
                        mp3.pause();
                        mp4.pause();
                        mp5.pause();
                        ib2.setImageResource(R.drawable.off);
                        ib3.setImageResource(R.drawable.off);
                        ib4.setImageResource(R.drawable.off);
                        ib5.setImageResource(R.drawable.off);
                        mp1.start();
                        ib1.setImageResource(R.drawable.on);
                        check1 = true;
                    }
                }
            }
        });
        b20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (check == false) {
                    mp2.start();
                    ib2.setImageResource(R.drawable.on);
                    check = true;
                    check2 = true;
                } else {
                    if(check2 == true) {
                        mp2.pause();
                        ib2.setImageResource(R.drawable.off);
                        check = false;
                        check2 = false;
                    } else {
                        check1 = false;
                        check3 = false;
                        check4 = false;
                        check5 = false;
                        mp1.pause();
                        mp3.pause();
                        mp4.pause();
                        mp5.pause();
                        ib1.setImageResource(R.drawable.off);
                        ib3.setImageResource(R.drawable.off);
                        ib4.setImageResource(R.drawable.off);
                        ib5.setImageResource(R.drawable.off);

                        mp2.start();
                        ib2.setImageResource(R.drawable.on);
                        check2 = true;
                    }
                }
            }
        });
        b21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (check == false) {
                    mp3.start();
                    ib3.setImageResource(R.drawable.on);
                    check = true;
                    check3 = true;
                } else {
                    if(check3 == true) {
                        mp3.pause();
                        ib3.setImageResource(R.drawable.off);
                        check = false;
                        check3 = false;
                    } else {
                        check1 = false;
                        check2 = false;
                        check4 = false;
                        check5 = false;
                        mp1.pause();
                        mp2.pause();
                        mp4.pause();
                        mp5.pause();
                        ib1.setImageResource(R.drawable.off);
                        ib2.setImageResource(R.drawable.off);
                        ib4.setImageResource(R.drawable.off);
                        ib5.setImageResource(R.drawable.off);

                        mp3.start();
                        ib3.setImageResource(R.drawable.on);
                        check3 = true;
                    }
                }
            }
        });
        b22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (check == false) {
                    mp4.start();
                    ib4.setImageResource(R.drawable.on);
                    check = true;
                    check4 = true;
                } else {
                    if(check4 == true) {
                        mp4.pause();
                        ib4.setImageResource(R.drawable.off);
                        check = false;
                        check4 = false;
                    } else {
                        check1 = false;
                        check2 = false;
                        check3 = false;
                        check5 = false;
                        mp1.pause();
                        mp2.pause();
                        mp3.pause();
                        mp5.pause();
                        ib1.setImageResource(R.drawable.off);
                        ib2.setImageResource(R.drawable.off);
                        ib3.setImageResource(R.drawable.off);
                        ib5.setImageResource(R.drawable.off);

                        mp4.start();
                        ib4.setImageResource(R.drawable.on);
                        check4 = true;
                    }
                }
            }
        });
        b23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (check == false) {
                    mp5.start();
                    ib5.setImageResource(R.drawable.on);
                    check = true;
                    check5 = true;
                } else {
                    if(check5 == true) {
                        mp5.pause();
                        ib5.setImageResource(R.drawable.off);
                        check = false;
                        check5 = false;
                    } else {
                        check1 = false;
                        check2 = false;
                        check3 = false;
                        check4 = false;
                        mp1.pause();
                        mp2.pause();
                        mp3.pause();
                        mp4.pause();
                        ib1.setImageResource(R.drawable.off);
                        ib2.setImageResource(R.drawable.off);
                        ib3.setImageResource(R.drawable.off);
                        ib4.setImageResource(R.drawable.off);

                        mp5.start();
                        ib5.setImageResource(R.drawable.on);
                        check5 = true;
                    }
                }
            }
        });
        b24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check = false;
                check1 = false;
                check2 = false;
                check3 = false;
                check4 = false;
                check5 = false;
                mp1.pause();
                mp2.pause();
                mp3.pause();
                mp4.pause();
                mp4.pause();
                ib1.setImageResource(R.drawable.off);
                ib2.setImageResource(R.drawable.off);
                ib3.setImageResource(R.drawable.off);
                ib4.setImageResource(R.drawable.off);
                ib5.setImageResource(R.drawable.off);
                Intent i = new Intent(Sixteen.this, Ten.class);
                startActivity(i);
                finish();
            }
        });
    }
}