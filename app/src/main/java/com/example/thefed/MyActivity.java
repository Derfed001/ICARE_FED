package com.example.thefed;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.thefed.adapters.ImpactAdapter;
import com.example.thefed.models.ImpactModel;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class MyActivity extends AppCompatActivity {
    ImpactAdapter impactAdapter;
    List<ImpactModel> impactModelList;
    RecyclerView myActivity;
    FirebaseFirestore dbbb;
    ImageView iew5;
    TextView iew42,iew53;
    //ProgressBar progressBar1;
    //PopularModel popularModel=null;
    ImpactModel impactModel=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        dbbb = FirebaseFirestore.getInstance();

        iew5=findViewById(R.id.impactImg);
        iew42=findViewById(R.id.impactTitle);
        iew53=findViewById(R.id.impactDescription);
       // myActivity = findViewById(R.id.mydonations_recycler);
        myActivity.setLayoutManager(new LinearLayoutManager(this));
        impactModelList = new ArrayList<>();
        impactAdapter = new ImpactAdapter(this, impactModelList);
        myActivity.setAdapter(impactAdapter);
      //  hangeListener();



    final Object object=getIntent().getSerializableExtra("category");
        if(object instanceof ImpactModel){
        impactModel=(ImpactModel) object;
    }
        if(impactModel !=null){
        Glide.with(getApplicationContext()).load(impactModel.getImage_url()).into(iew5);
       // view27.setText(popularModel.getName());
        // Glide.with(context).load(popularModelList.get(position).getImage_url()).into(holder.popImg);
        //holder.name.setText(popularModelList.get(position).getName());

        //view40.setText(popularModel.getDescription());
       // view51.setText(popularModel.getDonateamount());
        //description.setText(popularModel.getDescription());
       // view54.setText(popularModel.getBenefitcontact());
        iew42.setText(impactModel.getName());
        //holder.description.setText(popularModelList.get(position).getDescription());
        iew53.setText(impactModel.getDescription());

    }





    /*    private void hangeListener() {

            dbbb.collection("ImpactOfDonation")
                    .addSnapshotListener(new EventListener<QuerySnapshot>() {
                        @Override
                        public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                            if (error != null) {
                                Log.e("Error", error.getMessage());
                                return;
                            }
                            for (DocumentChange dc : value.getDocumentChanges()) {
                                if (dc.getType() == DocumentChange.Type.ADDED) {
                                    impactModelList.add(dc.getDocument().toObject(ImpactModel.class));


                                    // progressBar.setVisibility(View.GONE);
                                    // scrollView.setVisibility(View.VISIBLE);

                                }
                                impactAdapter.notifyDataSetChanged();
                            }
                        }
                    });*/

        }
}