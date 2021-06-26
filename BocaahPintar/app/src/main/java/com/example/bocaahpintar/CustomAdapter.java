package com.example.bocaahpintar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    public CustomAdapter(Context context, ArrayList<ItemModel> items) {
        this.context = context;
        this.items = items;
    }

    Context context;
    ArrayList<ItemModel> items;

    CustomAdapterListener listener;

    @NonNull
    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.user_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.ViewHolder holder, int position) {

        holder.itemId.setText(items.get(position).getId());
        holder.itemNamaAnak.setText(items.get(position).getNamaAnak());
        holder.itemJK.setText(items.get(position).getJk());
        holder.itemUsiaAnak.setText(items.get(position).getUsiaAnak());

        //Todo implement button delete
        holder.itemHapus.setOnClickListener(v -> listener.removeDataFromCustomAdapter(position));

        try {
            listener = (CustomAdapterListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement");
        }

        //Todo implement button edit
        holder.itemEdit.setOnClickListener(v -> listener.updateDataFromCustomAdapter(position));



    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView itemId, itemNamaAnak, itemJK, itemUsiaAnak;
        Button itemEdit, itemHapus;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemId = itemView.findViewById(R.id.itemId);
            itemNamaAnak = itemView.findViewById(R.id.itemNamaAnak);
            itemJK = itemView.findViewById(R.id.itemJK);
            itemUsiaAnak = itemView.findViewById(R.id.itemUsiaAnak);
            itemEdit = itemView.findViewById(R.id.itemEdit);
            itemHapus = itemView.findViewById(R.id.itemHapus);
        }
    }

    public interface CustomAdapterListener {
        void removeDataFromCustomAdapter(int position);

        void updateDataFromCustomAdapter(int position);
    }


}
