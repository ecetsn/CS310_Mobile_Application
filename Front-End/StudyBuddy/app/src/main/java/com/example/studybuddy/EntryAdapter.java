package com.example.studybuddy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class EntryAdapter extends RecyclerView.Adapter<EntryAdapter.EntryViewHolder>{

    Context ctx;
    List<Entry> data;

    public EntryAdapter(Context ctx, List<Entry> data) {
        this.ctx = ctx;
        this.data = data;
    }

    @NonNull
    @Override
    public EntryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View root = LayoutInflater.from(ctx).inflate(R.layout.entry_row_layout, parent, false);

        EntryViewHolder holder = new EntryViewHolder(root);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull EntryViewHolder holder, int position) {
        holder.txtUserName.setText(data.get(position).getUser().getName());
        holder.txtLocation.setText(data.get(position).getLocation());
        holder.txtDate.setText(data.get(position).getDateStudy().toString());

        holder.row.setOnClickListener(v->{
            // Set Toast Output
            String desc = data.get(position).getDescription();
            if(desc.isEmpty()){desc = "There is no description given by the user.";}

            Toast toast = Toast.makeText(ctx, desc, Toast.LENGTH_LONG);

            // Change Toast Appearance
            ViewGroup group = (ViewGroup) toast.getView();
            TextView message = (TextView) group.getChildAt(0);
            message.setTextSize(22);
            TextView toastMessage = toast.getView().findViewById(android.R.id.message);
            toastMessage.setGravity(Gravity.CENTER);

            toast.show();


            Bundle bundle = new Bundle();
            bundle.putString("id", data.get(holder.getAdapterPosition()).getID());

        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class EntryViewHolder extends RecyclerView.ViewHolder{

        ConstraintLayout row;

        TextView txtUserName;
        TextView txtLocation;
        TextView txtDate;


        public EntryViewHolder(@NonNull View itemView) {
            super(itemView);
            txtUserName = itemView.findViewById(R.id.txtListName);
            txtLocation = itemView.findViewById(R.id.txtLocation);
            txtDate = itemView.findViewById(R.id.txtDate);
            row = itemView.findViewById(R.id.row_list);
        }
    }

}
