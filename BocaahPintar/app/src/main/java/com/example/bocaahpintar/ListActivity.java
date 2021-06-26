package com.example.bocaahpintar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity implements CustomAdapter.CustomAdapterListener{

    RecyclerView listRecyclerView;
    ArrayList<ItemModel> items = new ArrayList<>();
    CustomAdapter customAdapter;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listRecyclerView = findViewById(R.id.listRecyclerView);
        customAdapter = new CustomAdapter(this, items);
        listRecyclerView.setAdapter(customAdapter);
        listRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        readData();

    }

    void readData(){
        db.collection("user_register").get().addOnCompleteListener(task -> {
            if(task.isSuccessful()) {

                if (task.getResult() != null) {
                    items.clear();
                    for(QueryDocumentSnapshot document : (task.getResult())) {
                        ItemModel itemModel = new ItemModel(document.getId(),
                                document.getString("namaAnak"),
                                document.getString("jk"), document.getString("usiaAnak"));
                        items.add(itemModel);
                    }
                }
                customAdapter.notifyDataSetChanged();
            }
            else {
                Toast.makeText(ListActivity.this, "Gagal Membaca Data", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void removeDataFromCustomAdapter(int position) {
        ItemModel itemModel = items.get(position);

        db.collection("user_register").document(itemModel.getId()).delete()
                .addOnSuccessListener(unused -> readData())
                
                .addOnFailureListener(e -> Toast.makeText(ListActivity.this, "Gagal Menghapus Data",
                        Toast.LENGTH_LONG).show());
    }

    @Override
    public void updateDataFromCustomAdapter(int position) {
        ItemModel itemModel = items.get(position);

    }

}