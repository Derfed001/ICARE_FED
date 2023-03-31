package com.example.thefed.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.thefed.MyActivity;
import com.example.thefed.R;
import com.example.thefed.models.ImpactModel;

import java.util.List;

public class ImpactAdapter extends RecyclerView.Adapter<ImpactAdapter.ViewHolder> {

    Context context;
    List<ImpactModel> list;
    public ImpactAdapter(Context context, List<ImpactModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ImpactAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.account_about,parent,false));
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(list.get(position).getImage_url()).into(holder.imageView);
        holder.name.setText(list.get(position).getName());
        holder.description.setText(list.get(position).getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MyActivity.class);
                //intent.putExtra("category",popularModelList.get(position));
                //intent.putExtra("category",popularModelList.get(position).getCategory());
                //intent.putExtra("category",popularModelList.get(position).getCategory());
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name,description;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.img_impact);
            name=itemView.findViewById(R.id.name_impact);
            //benname=itemView.findViewById(R.id.benefi_cat);
            //bencontact=itemView.findViewById(R.id.cont_cat);
            description=itemView.findViewById(R.id.descr_impact);
        }
    }

    }
