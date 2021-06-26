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

public class login extends AppCompatActivity {

    Button btnlogin;
    EditText email_log;
    EditText pass_login;
    TextView alternatif_reg;
    FirebaseAuth fAuth;

    ProgressBar progressBar2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email_log = findViewById(R.id.email_log);
        pass_login = findViewById(R.id.pass_login);
        progressBar2 = findViewById(R.id.progressBar2);
        btnlogin = findViewById(R.id.btnlogin);

        fAuth = FirebaseAuth.getInstance();


        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = email_log.getText().toString().trim();
                String password = pass_login.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    email_log.setError("Email harus diisi!");
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    pass_login.setError("Password harus diisi!");
                    return;
                }

                if (password.length() < 6) {
                    pass_login.setError("Password harus terdiri dari 6 karakter");
                    return;
                }

                progressBar2.setVisibility(View.VISIBLE);

                fAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(login.this, "Login Berhasil", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(getApplicationContext(), dashboard.class));
                        } else {
                            Toast.makeText(login.this, "ERROR !" + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            progressBar2.setVisibility(View.GONE);
                        }
                    }
                });


            }

        });
    }
}