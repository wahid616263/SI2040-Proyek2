package com.example.bocaahpintar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button reg_utama, login_utama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main15);

        reg_utama = findViewById(R.id.reg_utama);
        login_utama = findViewById(R.id.login_utama);
    }

    public void register (View view) {
        Intent intent = new Intent(MainActivity.this, register.class);
        startActivity((intent));
    }
    public void login (View view) {
        Intent intent = new Intent (MainActivity.this, login.class);
        startActivity(intent);
    }
}