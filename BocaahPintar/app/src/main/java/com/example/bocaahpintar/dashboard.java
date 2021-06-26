package com.example.bocaahpintar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;


public class dashboard extends AppCompatActivity {

    MediaPlayer audioBackground;
    ImageView tentang;
    Button warna, angka, teman;
    TextView logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        audioBackground = MediaPlayer.create(this, R.raw.beranda);
        audioBackground.setVolume(1, 1);
        audioBackground.start();

        warna = findViewById(R.id.warna);
        angka = findViewById(R.id.angka);

        tentang = findViewById(R.id.tentang);
        tentang.setOnClickListener(v -> startActivity(new Intent(dashboard.this, TentangApk.class)));

        teman = findViewById(R.id.teman);
        teman.setOnClickListener(v -> startActivity(new Intent(dashboard.this, ListActivity.class)));

        warna.setOnClickListener(v -> startActivity(new Intent(dashboard.this, MainActivity2.class)));

        angka.setOnClickListener(v -> startActivity(new Intent(dashboard.this, MainActivity3.class)));

    }

}