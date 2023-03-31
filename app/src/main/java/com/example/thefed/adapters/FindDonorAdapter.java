package com.example.thefed.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thefed.R;
import com.example.thefed.models.FindDonorModel;

import java.util.List;

public class FindDonorAdapter extends RecyclerView.Adapter<FindDonorAdapter.ViewHolder> {

    Context context;
    List<FindDonorModel> list;
    public FindDonorAdapter(Context context, List<FindDonorModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public FindDonorAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FindDonorAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.find_donor_resource,parent,false));
    }
    @Override
    public void onBindViewHolder(@NonNull FindDonorAdapter.ViewHolder holder, int position) {
        //Glide.with(context).load(list.get(position).getImage_url()).into(holder.imageView);
        holder.name.setText(list.get(position).getName());
        holder.email.setText(list.get(position).getEmail());
        holder.contact.setText(list.get(position).getContact());
        holder.interests.setText(list.get(position).getInterests());


       /* holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MyActivity.class);
                //intent.putExtra("category",popularModelList.get(position));
                //intent.putExtra("category",popularModelList.get(position).getCategory());
                //intent.putExtra("category",popularModelList.get(position).getCategory());
                context.startActivity(intent);
            }
        });*/
    }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            //ImageView imageView;
            TextView name,email,contact,interests;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                //imageView=itemView.findViewById(R.id.img_impact);
                name=itemView.findViewById(R.id.donorName_vertical);
                email=itemView.findViewById(R.id.donor_email);
                interests=itemView.findViewById(R.id.donor_interests);
                contact=itemView.findViewById(R.id.donor_contact);
            }
        }

    }


