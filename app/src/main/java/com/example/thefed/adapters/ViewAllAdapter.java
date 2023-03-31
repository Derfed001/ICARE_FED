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
import com.example.thefed.DonateMeActivity;
import com.example.thefed.R;
import com.example.thefed.models.ViewAllModel;

import java.util.List;

public class ViewAllAdapter extends RecyclerView.Adapter<ViewAllAdapter.ViewHolder> {
    private Context context;
    private List<ViewAllModel> viewAllModelList;
    public ViewAllAdapter(Context context, List<ViewAllModel> viewAllModelList) {
        this.context = context;
        this.viewAllModelList = viewAllModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      //  return null;
    //}
        return new ViewAllAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_all_item,parent,false));
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(viewAllModelList.get(position).getImage_url()).into(holder.popImg);
        holder.name.setText(viewAllModelList.get(position).getName());
        holder.benefitcontact.setText(viewAllModelList.get(position).getBenefitcontact());
        holder.donateamount.setText(viewAllModelList.get(position).getDonateamount());
        holder.donationperiod.setText(viewAllModelList.get(position).getDonationperiod());
        holder.description.setText(viewAllModelList.get(position).getDescription());
        holder.benefitname.setText(viewAllModelList.get(position).getBenefitname());
        //holder.bencontact.setText(popularModelList.get(position).getc());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DonateMeActivity.class);
                //intent.putExtra("category",viewAllModelList.get(position));
                //intent.putExtra("category",popularModelList.get(position).getCategory());
                //intent.putExtra("category",popularModelList.get(position).getCategory());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return viewAllModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView popImg;
        TextView name,benefitcontact,benefitname,donateamount,donationperiod,description;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            popImg=itemView.findViewById(R.id.img_viewall);
            name=itemView.findViewById(R.id.name_viewall);
            benefitname=itemView.findViewById(R.id.benefit_viewall);
            benefitcontact=itemView.findViewById(R.id.contact_viewall);
            donateamount=itemView.findViewById(R.id.amount_viewall);
            donationperiod=itemView.findViewById(R.id.period_viewall);
            description=itemView.findViewById(R.id.descr_viewall);
        }
    }
}
