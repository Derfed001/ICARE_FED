package com.example.thefed.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thefed.R;
import com.example.thefed.models.Mydonations;

import java.util.List;

public class MyDonationsAdapter extends RecyclerView.Adapter<MyDonationsAdapter.ViewHolder> {

    Context context;
    List<Mydonations> list;
    public MyDonationsAdapter(Context context, List<Mydonations> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyDonationsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyDonationsAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.donateme,parent,false));
    }


    @Override
    public void onBindViewHolder(@NonNull MyDonationsAdapter.ViewHolder holder, int position) {
        //Glide.with(context).load(list.get(position).getImage_url()).into(holder.imageView);
        holder.name.setText(list.get(position).getName());
        holder.benefitname.setText(list.get(position).getBenefitname());
        holder.donateamount.setText(list.get(position).getDonateamount());
        holder.category.setText(list.get(position).getCategory());


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
        TextView name,donateamount,category,benefitname;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //imageView=itemView.findViewById(R.id.img_impact);
            name=itemView.findViewById(R.id.my_title);
            category=itemView.findViewById(R.id.my_category);
            benefitname=itemView.findViewById(R.id.my_benefit);
            donateamount=itemView.findViewById(R.id.my_amount_donate);
        }
    }

}

