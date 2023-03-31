package com.example.thefed;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thefed.adapters.MyDonationsAdapter;
import com.example.thefed.models.Mydonations;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class MyDonationsAct extends AppCompatActivity {

    //ImpactAdapter impactAdapter;
   // List<ImpactModel> impactModelList;
    //RecyclerView myActivity;
    RecyclerView myDonations;
    MyDonationsAdapter myDonationsAdapter;
    List<Mydonations> mydonationsList;
    FirebaseFirestore dbMy;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_donations);

        dbMy = FirebaseFirestore.getInstance();


        myDonations = findViewById(R.id.recMyDnt);
        myDonations.setLayoutManager(new LinearLayoutManager(this));
        mydonationsList = new ArrayList<>();
        myDonationsAdapter = new MyDonationsAdapter(this, mydonationsList);
        myDonations.setAdapter(myDonationsAdapter);
        eListener();

    }

    private void eListener() {

        dbMy.collection("myDonations")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        if (error != null) {
                            Log.e("Error", error.getMessage());
                            return;
                        }
                        for (DocumentChange dc : value.getDocumentChanges()) {
                            if (dc.getType() == DocumentChange.Type.ADDED) {
                                mydonationsList.add(dc.getDocument().toObject(Mydonations.class));


                                // progressBar.setVisibility(View.GONE);
                                // scrollView.setVisibility(View.VISIBLE);

                            }
                            myDonationsAdapter.notifyDataSetChanged();
                        }
                    }
                });

    }
}