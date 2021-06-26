package com.example.bocaahpintar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class register extends AppCompatActivity {

    String collectionName = "user_register";

    Button btnregister;
    EditText nama_reg;
    EditText usia_reg;
    EditText jk_reg;
    EditText email_reg, pass_reg;
    ProgressBar progressBar;
    TextView alternatif;
    FirebaseAuth fAuth;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nama_reg = findViewById(R.id.nama_reg);
        usia_reg = findViewById(R.id.usia_reg);
        jk_reg = findViewById(R.id.jk_reg);
        progressBar = findViewById(R.id.progressBar);
        btnregister = findViewById(R.id.btnregister);
        email_reg = findViewById(R.id.email_reg);
        pass_reg = findViewById(R.id.pass_reg);
        alternatif = findViewById(R.id.alternatif_login);

        fAuth = FirebaseAuth.getInstance();

        if(fAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), dashboard.class));
            finish();
        }

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = email_reg.getText().toString().trim();
                String password = pass_reg.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    email_reg.setError("Email harus diisi!");
                    return;
                }

                if(TextUtils.isEmpty(password)) {
                    pass_reg.setError("Password harus diisi!");
                    return;
                }

                if(password.length() < 6) {
                    pass_reg.setError("Password harus terdiri dari 6 karakter");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            addData();
                            Toast.makeText(register.this, "Berhasil Terdaftar", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(getApplicationContext(), dashboard.class));
                        }else {
                            Toast.makeText(register.this, "ERROR !" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                            Log.e("Testing Registrasi",task.getException().getMessage());
                        }
                    }
                });
            }
        });

        alternatif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), login.class));
            }
        });


    }

    void addData(){
        String namaAnak = nama_reg.getText().toString();
        String usiaAnak = usia_reg.getText().toString();
        String jk = jk_reg.getText().toString();

        RegisterModel registerModel = new RegisterModel(null, namaAnak, usiaAnak, jk);

        db.collection(collectionName).add(registerModel)
                .addOnSuccessListener(documentReference -> {
                    Toast.makeText(this, "Data Berhasil Tersimpan", Toast.LENGTH_LONG).show();
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(this, "Data Gagal Tersimpan", Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.GONE);
                });
    }


}