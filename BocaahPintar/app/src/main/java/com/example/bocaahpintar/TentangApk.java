package com.example.bocaahpintar;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class TentangApk extends AppCompatActivity {

    String collectionName = "kritik_saran";

    EditText kritik;
    Button kirim_kritik;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tentang_apk);

        kritik = findViewById(R.id.kritik);
        kirim_kritik = findViewById(R.id.kirim_kritik);

        kirim_kritik.setOnClickListener(v -> {
            addKritik();
        });

        DocumentReference docRef = db.collection("kritik_saran").document();
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                    } else {
                        Log.d(TAG, "No such document");
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });
    }

    void addKritik(){
        String kritikan = kritik.getText().toString();

        KritikModel kritikModel = new KritikModel(null, kritikan);

        db.collection(collectionName).add(kritikModel)
                .addOnSuccessListener(documentReference -> {
                    Toast.makeText(this, "Data Berhasil Tersimpan", Toast.LENGTH_LONG).show();
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(this, "Data Gagal Tersimpan", Toast.LENGTH_LONG).show();
                });
    }

}