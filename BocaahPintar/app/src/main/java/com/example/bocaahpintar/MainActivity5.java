package com.example.bocaahpintar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity5 extends AppCompatActivity {

    ImageView imageView21, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        imageView21 = findViewById(R.id.imageView21);
        imageView21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity5.this, MainActivity9.class));
            }
        });

        back = findViewById(R.id.back_brokol_hijau);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity5.this, dashboard.class));
            }
        });
    }
}