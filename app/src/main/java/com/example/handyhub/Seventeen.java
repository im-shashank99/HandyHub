package com.example.handyhub;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import android.annotation.SuppressLint;
import android.os.Build;
import android.provider.Settings;

import java.util.Locale;

public class Seventeen extends AppCompatActivity {
    ImageButton ib7, ib8, ib9;
    Button b26;
    TextToSpeech ts;
    WifiManager wm;
    BluetoothAdapter ba;
    CameraManager cm;
    private boolean wifi = false, blue = false, camera = false;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_seventeen);
        ib7 = (ImageButton) findViewById(R.id.imageButton7);
        ib8 = (ImageButton) findViewById(R.id.imageButton8);
        ib9 = (ImageButton) findViewById(R.id.imageButton9);
        b26 = (Button) findViewById(R.id.button59);
        wm = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
        ba = BluetoothAdapter.getDefaultAdapter();
        cm = (CameraManager) getSystemService(CAMERA_SERVICE);
        ts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                ts.setLanguage(Locale.ENGLISH);
                ts.setSpeechRate(0.7f);
            }
        });
        ib7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (wifi == false) {
                    ts.speak("Wifi turned on", TextToSpeech.QUEUE_FLUSH, null);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                        Intent panelIntent = new Intent(Settings.Panel.ACTION_WIFI);
                        startActivityForResult(panelIntent, 0);
                    } else {
                        wm.setWifiEnabled(true);
                    }
                    wifi = true;
                    ib7.setImageResource(R.drawable.wn);
                    Toast.makeText(Seventeen.this, "Wifi turned on", Toast.LENGTH_SHORT).show();
                } else {
                    ts.speak("Wifi turned off", TextToSpeech.QUEUE_FLUSH, null);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                        Intent panelIntent = new Intent(Settings.Panel.ACTION_WIFI);
                        startActivityForResult(panelIntent, 0);
                    } else {
                        wm.setWifiEnabled(false);
                    }
                    wifi = false;
                    ib7.setImageResource(R.drawable.wo);
                    Toast.makeText(Seventeen.this, "Wifi turned off", Toast.LENGTH_SHORT).show();
                }
            }
        });
        ib8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (blue == false) {
                    ts.speak("Blue tooth turned on", TextToSpeech.QUEUE_FLUSH, null);
                    if (ActivityCompat.checkSelfPermission(Seventeen.this, android.Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.
                    }
                    ba.enable();
                    blue = true;
                    ib8.setImageResource(R.drawable.bo);
                    Toast.makeText(Seventeen.this, "Bluetooth turned on", Toast.LENGTH_SHORT).show();
                } else {
                    ts.speak("Blue tooth turned off", TextToSpeech.QUEUE_FLUSH, null);
                    ba.disable();
                    blue = false;
                    ib8.setImageResource(R.drawable.bf);
                    Toast.makeText(Seventeen.this, "Bluetooth turned off", Toast.LENGTH_SHORT).show();
                }
            }
        });
        ib9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (camera == false) {
                    try {
                        ts.speak("Torch turned on", TextToSpeech.QUEUE_FLUSH, null);
                        String id = cm.getCameraIdList()[0];
                        cm.setTorchMode(id, true);
                        camera = true;
                        ib9.setImageResource(R.drawable.to);
                        Toast.makeText(Seventeen.this, "Torch turned on", Toast.LENGTH_SHORT).show();
                    } catch (CameraAccessException e) {}
                } else {
                    try {
                        ts.speak("Torch turned off", TextToSpeech.QUEUE_FLUSH, null);
                        String id = cm.getCameraIdList()[0];
                        cm.setTorchMode(id, false);
                        camera = false;
                        ib9.setImageResource(R.drawable.tf);
                        Toast.makeText(Seventeen.this, "Torch turned off", Toast.LENGTH_SHORT).show();
                    } catch (CameraAccessException e) {}
                }
            }
        });
        b26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ts.speak("Back to index", TextToSpeech.QUEUE_FLUSH, null);
                Intent i = new Intent(Seventeen.this, Ten.class);
                startActivity(i);
                finish();
            }
        });
    }
}