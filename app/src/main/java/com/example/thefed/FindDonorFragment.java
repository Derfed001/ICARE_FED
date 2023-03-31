package com.example.thefed;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thefed.adapters.FindDonorAdapter;
import com.example.thefed.models.FindDonorModel;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class FindDonorFragment extends Fragment {
   // Spinner interests;
    RecyclerView findDonorRec;
    FirebaseFirestore dbs;
    List<FindDonorModel> findDonorModelList;
    FindDonorAdapter findDonorAdapter;



    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root= inflater.inflate(R.layout.fragment_find_donor, container, false);
        dbs=FirebaseFirestore.getInstance();

        findDonorRec=root.findViewById(R.id.find_donor_recycler);

        findDonorRec.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));

        findDonorModelList = new ArrayList<>();
        findDonorAdapter = new FindDonorAdapter(getActivity(), findDonorModelList);
        findDonorRec.setAdapter(findDonorAdapter);
        ngeListener();

       /* interests=root.findViewById(R.id.spinnerfind);

        ArrayAdapter<String> adapter3=new ArrayAdapter<String>(getContext() , android.R.layout.simple_spinner_item,
                getResources().getStringArray(R.array.Category));
       //ArrayAdapter<CharSequence> adapter3=ArrayAdapter.createFromResource(getContext(),R.array.Category, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        interests.setAdapter(adapter3);
        interests.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String text=parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Toast.makeText(RegisterActivity.this, "Please select at least one interest ", Toast.LENGTH_SHORT).show();



            }
        });*/
        return root;

    }

    private void ngeListener() {

        dbs.collection("findDonor")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        if (error != null) {
                            Log.e("Error", error.getMessage());
                            return;
                        }
                        for (DocumentChange dc : value.getDocumentChanges()) {
                            if (dc.getType() == DocumentChange.Type.ADDED) {
                                findDonorModelList.add(dc.getDocument().toObject(FindDonorModel.class));
                            }
                            findDonorAdapter.notifyDataSetChanged();
                        }
                    }
                });
    }
}