package com.example.thefed.adapters;

import android.annotation.SuppressLint;
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
import com.example.thefed.DonateMeActivity;
import com.example.thefed.R;
import com.example.thefed.models.PopularModel;

import java.util.List;

public class PopularAdapters extends RecyclerView.Adapter<PopularAdapters.ViewHolder> {
    private Context context;
    private List<PopularModel> popularModelList;
    public PopularAdapters(Context context, List<PopularModel> popularModelList) {
        this.context = context;
        this.popularModelList = popularModelList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_horizontal_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        Glide.with(context).load(popularModelList.get(position).getImage_url()).into(holder.popImg);
        holder.name.setText(popularModelList.get(position).getName());
        holder.benefitcontact.setText(popularModelList.get(position).getBenefitcontact());
        holder.donateamount.setText(popularModelList.get(position).getDonateamount());
        holder.donationperiod.setText(popularModelList.get(position).getDonationperiod());
        holder.description.setText(popularModelList.get(position).getDescription());
        holder.benefitname.setText(popularModelList.get(position).getBenefitname());
        //holder.bencontact.setText(popularModelList.get(position).getc());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DonateMeActivity.class);
                //intent.putExtra("category",popularModelList.get(position));
                //intent.putExtra("category",popularModelList.get(position).getCategory());
                //intent.putExtra("category",popularModelList.get(position).getCategory());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return popularModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView popImg;
        TextView name,benefitcontact,benefitname,donateamount,donationperiod,description;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            popImg=itemView.findViewById(R.id.ver_ing);
            name=itemView.findViewById(R.id.requestName);
            benefitname=itemView.findViewById(R.id.textView_benefit);
            benefitcontact=itemView.findViewById(R.id.beneficiary_contact);
            donateamount=itemView.findViewById(R.id.textView_amount);
            donationperiod=itemView.findViewById(R.id.period_time);
            description=itemView.findViewById(R.id.textView_description);

        }
    }
}
