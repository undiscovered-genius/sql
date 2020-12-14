package com.example.bank;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<String> titles;
    List<Integer> images;
    LayoutInflater inflater;
    public Adapter(Context cxt, List<String> titles, List<Integer> images){
        this.titles = titles;
        this.images = images;
        this.inflater = LayoutInflater.from(cxt);
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_grid_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.title.setText(titles.get(position));
        viewHolder.gridIcon.setImageResource(images.get(position));
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        ImageView gridIcon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.textView);
            gridIcon = itemView.findViewById(R.id.imageView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (title.getText() == "ADD ACCOUNT"){
                        Intent display = new Intent(view.getContext(),details.class);
                        view.getContext().startActivity(display);
                    }else if (title.getText() == "CUSTOMER DETAILS"){
                        Intent display = new Intent(view.getContext(),ListDataActivity.class);
                        view.getContext().startActivity(display);
                    }else if (title.getText() == "TRANSFER MONEY"){
                        Intent display = new Intent(view.getContext(),ListDataActivity.class);
                        view.getContext().startActivity(display);
                    }

                }
            });
        }
    }
}
