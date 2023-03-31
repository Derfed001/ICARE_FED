package com.example.thefed;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thefed.adapters.PopularAdapters;
import com.example.thefed.adapters.ViewAllAdapter;
import com.example.thefed.models.PopularModel;
import com.example.thefed.models.ViewAllModel;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ViewAllActivity extends AppCompatActivity {
    //FirebaseFirestore firestore;
    List<ViewAllModel> viewAllModelList;
    ViewAllAdapter viewAllAdapter;
    RecyclerView viewallRec;
    FirebaseFirestore db;
    List<PopularModel> popularModelList;
    PopularAdapters popularAdapters;

    //ProgressBar progressBar2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);

        db = FirebaseFirestore.getInstance();

        //String category = getIntent().getStringExtra("category");
        viewallRec = findViewById(R.id.recyclerViewall);
        viewallRec.setLayoutManager(new LinearLayoutManager(this));

        popularModelList = new ArrayList<>();
        popularAdapters = new PopularAdapters(this, popularModelList);
        viewallRec.setAdapter(popularAdapters);
        entChangeListener();

        //viewAllModelList = new ArrayList<>();
        //viewAllAdapter = new ViewAllAdapter(this, viewAllModelList);
       // viewallRec.setAdapter(viewAllAdapter);
        entChangeListener();
        //mmChaneListener();

       /* if (category != null && category.equalsIgnoreCase("Education")) {
            firestore.collection("MainRequests").whereEqualTo("category", "Education").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @SuppressLint("NotifyDataSetChanged")
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    for (DocumentSnapshot documentSnapshot : task.getResult().getDocuments()) {
                        ViewAllModel viewAllModel = documentSnapshot.toObject(ViewAllModel.class);
                        viewAllModelList.add(viewAllModel);
                        viewAllAdapter.notifyDataSetChanged();
                    }

                }
            });*/
        }

    private void entChangeListener() {

            db.collection("MainRequests")
                    .addSnapshotListener(new EventListener<QuerySnapshot>() {
                        @Override
                        public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                            if (error != null) {
                                Log.e("Error", error.getMessage());
                                return;
                            }
                            for (DocumentChange dc : value.getDocumentChanges()) {
                                if (dc.getType() == DocumentChange.Type.ADDED) {
                                    popularModelList.add(dc.getDocument().toObject(PopularModel.class));
                                }
                                popularAdapters.notifyDataSetChanged();
                            }
                        }
                    });
    }


    /*private void mmChaneListener() {
            if(category!=null && category.equalsIgnoreCase("Education")){
                firestore.collection("MainRequests").whereEqualTo("category","Education").get()
                        .addSnapshotListener(new EventListener<QuerySnapshot>() {
                            @Override
                            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                                if(error!=null){
                                    Log.e("Error",error.getMessage());
                                    return;
                                }
                                for (DocumentChange dc: value.getDocumentChanges()){
                                    if(dc.getType()== DocumentChange.Type.ADDED){
                                        viewAllModelList.add(dc.getDocument().toObject(ViewAllModel.class));


                                        // progressBar.setVisibility(View.GONE);
                                        // scrollView.setVisibility(View.VISIBLE);

                                    }
                                    viewAllAdapter.notifyDataSetChanged();
                                }
                            }
                        });*/

            }
