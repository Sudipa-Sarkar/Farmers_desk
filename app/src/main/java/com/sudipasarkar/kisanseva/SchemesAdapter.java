package com.sudipasarkar.kisanseva;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SchemesAdapter extends RecyclerView.Adapter<SchemesAdapter.ViewHolder> {
private ArrayList<Schemes> sch;
private Context context;

    public SchemesAdapter(ArrayList<Schemes> sch, Context context) {
        this.sch = sch;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.scheme,parent,false);
        return new SchemesAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
     final Schemes scheme = sch.get(position);
     holder.subtitle.setText(scheme.getDesc());
     holder.title.setText(scheme.getTitle());
     holder.itemView.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent i= new Intent(context,SchemedetailActivity.class);
             i.putExtra("title",scheme.getTitle());
             i.putExtra("desc",scheme.getDesc());
             i.putExtra("link",scheme.getLink());
             context.startActivity(i);
         }
     });
    }

    @Override
    public int getItemCount() {
        return sch.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title,subtitle;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.heading);
            subtitle=itemView.findViewById(R.id.subheading);

        }
    }
}
