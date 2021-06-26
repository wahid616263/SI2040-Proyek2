package com.example.bocaahpintar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity4 extends AppCompatActivity {
    ImageView imageView10;
    ImageView imageView13, back_apel_hijau;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        imageView10 = findViewById(R.id.imageView10);
        imageView10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity4.this, MainActivity7.class));

                imageView13 = findViewById(R.id.imageView13);
                imageView13.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(MainActivity4.this, MainActivity8.class));
                    }
                });
            }
        });

        back_apel_hijau = findViewById(R.id.back_apel_hijau);
        back_apel_hijau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity4.this, dashboard.class));
            }
        });
    }
}