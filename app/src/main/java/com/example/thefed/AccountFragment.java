package com.example.thefed;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.firestore.FirebaseFirestore;

public class AccountFragment extends Fragment {
    FirebaseFirestore db;
    //List<AccountModel> accountModelList;
   // AccountAdapter accountAdapter;
   // RecyclerView accountRec;
    //DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://the-fed-default-rtdb.firebaseio.com/");
    ImageView picyangu;
    TextView eric,mwegmail,namba7,aboutmm,locatemm,webmm,interestsmm;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_account, container, false);

        View view = inflater.inflate(R.layout.fragment_account, container, false);
        db=FirebaseFirestore.getInstance();

        //homeHorizontalRec = root.findViewById(R.id.recyclerHome);
        //homeCategoryRec=root.findViewById(R.id.recycler_category);
       // accountRec = root.findViewById(R.id.recyclerProfile);

     //   accountRec.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));

     //   accountModelList=new ArrayList<>();
      //  accountAdapter = new AccountAdapter(getActivity(),accountModelList);
      //  accountRec.setAdapter(accountAdapter);
     //   angeListener();

        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }
    /*   private void angeListener() {

        db.collection("Username")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        if(error!=null){
                            Log.e("Error",error.getMessage());
                            return;
                        }
                        for (DocumentChange dc: value.getDocumentChanges()){
                            if(dc.getType()== DocumentChange.Type.ADDED){
                                accountModelList.add(dc.getDocument().toObject(AccountModel.class));


                                // progressBar.setVisibility(View.GONE);
                                // scrollView.setVisibility(View.VISIBLE);

                            }
                            accountAdapter.notifyDataSetChanged();
                        }
                    }
                });



    }*/
}