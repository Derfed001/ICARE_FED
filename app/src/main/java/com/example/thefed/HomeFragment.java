package com.example.thefed;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thefed.adapters.ImpactAdapter;
import com.example.thefed.adapters.NavCategoryAdapter;
import com.example.thefed.adapters.PopularAdapters;
import com.example.thefed.adapters.ViewAllAdapter;
import com.example.thefed.models.ImpactModel;
import com.example.thefed.models.NavCategoryModel;
import com.example.thefed.models.PopularModel;
import com.example.thefed.models.ViewAllModel;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    FirebaseFirestore db;
    List<PopularModel> popularModelList;
    PopularAdapters popularAdapters;
    RecyclerView popularRec,categoryRec,impactRec;
    ScrollView scrollView;
  //  ProgressBar progressBar;
  //  EditText search_box;
    private List<ViewAllModel>viewAllModelList;
    //private RecyclerView recyclerViewSearch;
    private ViewAllAdapter viewAllAdapter;
    NavCategoryAdapter navCategoryAdapter;
    List<NavCategoryModel>navCategoryModelList;
    ImpactAdapter impactAdapter;
    List<ImpactModel>impactModelList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        db=FirebaseFirestore.getInstance();

        //homeHorizontalRec = root.findViewById(R.id.recyclerHome);
        //homeCategoryRec=root.findViewById(R.id.recycler_category);
        popularRec = root.findViewById(R.id.recyclerHome);
        scrollView=root.findViewById(R.id.viewscroll);
        impactRec=root.findViewById(R.id.recyclerVideo);
        //progressBar=root.findViewById(R.id.progressbar);
        categoryRec=root.findViewById(R.id.recycler_category);
        //search_box=root.findViewById(R.id.search_home);
        //recyclerViewSearch=root.findViewById(R.id.search_Rec);
        viewAllModelList=new ArrayList<>();
        viewAllAdapter=new ViewAllAdapter(getContext(),viewAllModelList);
        //recyclerViewSearch.setLayoutManager(new LinearLayoutManager(getContext()));
       // recyclerViewSearch.setAdapter(viewAllAdapter);
      //  recyclerViewSearch.setHasFixedSize(true);
        searchProduct();

        /*search_box.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().isEmpty()) {
                    viewAllModelList.clear();
                    viewAllAdapter.notifyDataSetChanged();
                } else {
                    searchProduct(s.toString());}*/


           /*{
                                @Override
                                public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                                    if(error!=null){
                                        Log.e("Error",error.getMessage());
                                        return;
                                    }
                                    for (DocumentChange dc: value.getDocumentChanges()){
                                        if(dc.getType()== DocumentChange.Type.ADDED){
                                            impactModelList.add(dc.getDocument().toObject(ImpactModel.class));


                                            // progressBar.setVisibility(View.GONE);
                                            // scrollView.setVisibility(View.VISIBLE);

                                        }
                                        impactAdapter.notifyDataSetChanged();
                                    }
                                }
                            });*/


                    //progressBar.setVisibility(View.VISIBLE);
                    //scrollView.setVisibility(View.GONE);


                    categoryRec.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));

                    navCategoryModelList = new ArrayList<>();
                    navCategoryAdapter = new NavCategoryAdapter(getActivity(), navCategoryModelList);
                    categoryRec.setAdapter(navCategoryAdapter);
                    eventChangeListener();
                    popularRec.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));

                    popularModelList = new ArrayList<>();
                    popularAdapters = new PopularAdapters(getActivity(), popularModelList);
                    popularRec.setAdapter(popularAdapters);
                    entChangeListener();

                    impactRec.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));

                    impactModelList = new ArrayList<>();
                    impactAdapter = new ImpactAdapter(getActivity(), impactModelList);
                    impactRec.setAdapter(impactAdapter);
                    ventChangeListener();





       /*popularRec.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));

        popularModelList=new ArrayList<>();
        popularAdapters = new PopularAdapters(getActivity(),popularModelList);
        popularRec.setAdapter(popularAdapters);

        db.collection("MainRequests")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    PopularModel popularModel=document.toObject(PopularModel.class);
                                    popularModelList.add(popularModel);
                                    popularAdapters.notifyDataSetChanged();

                                   progressBar.setVisibility(View.GONE);
                                    scrollView.setVisibility(View.VISIBLE);
                            }
                        } else {
                            Toast.makeText(getActivity(),"Error"+task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });*/

       /* categoryRec.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));

        navCategoryModelList=new ArrayList<>();
        navCategoryAdapter = new NavCategoryAdapter(getActivity(),navCategoryModelList);
        categoryRec.setAdapter(navCategoryAdapter);
        eventChangeListener();*/

      /*  db.collection("Categories")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                NavCategoryModel navCategoryModel=document.toObject(NavCategoryModel.class);
                                navCategoryModelList.add(navCategoryModel);
                                navCategoryAdapter.notifyDataSetChanged();

                                progressBar.setVisibility(View.GONE);
                                scrollView.setVisibility(View.VISIBLE);
                            }
                        } else {
                            Toast.makeText(getActivity(),"Error"+task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });*/


                return root;
                }

    private void searchProduct() {

    }



         /*   private void searchProduct(String category) {
                if (!category.isEmpty()) {
                    //db.collection("All")
                    db.collection("ImpactOfDonation").whereEqualTo("category", category).get()
                            .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<QuerySnapshot> task) {

                                    if (task.isSuccessful() && task.getResult() != null) {
                                        viewAllModelList.clear();
                                        viewAllAdapter.notifyDataSetChanged();
                                        for (DocumentSnapshot doc : task.getResult().getDocuments()) {
                                            ViewAllModel viewAllModel = doc.toObject(ViewAllModel.class);
                                            viewAllModelList.add(viewAllModel);
                                            viewAllAdapter.notifyDataSetChanged();
                                        }
                                    }

                                }
                            });
                }*/

                private void ventChangeListener () {
                    db.collection("ImpactOfDonation")
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
                            });

                }

                private void eventChangeListener () {
                    db.collection("Categories2 ")
                            .addSnapshotListener(new EventListener<QuerySnapshot>() {
                                @Override
                                public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                                    if (error != null) {
                                        Log.e("Error", error.getMessage());
                                        return;
                                    }
                                    for (DocumentChange dc : value.getDocumentChanges()) {
                                        if (dc.getType() == DocumentChange.Type.ADDED) {
                                            navCategoryModelList.add(dc.getDocument().toObject(NavCategoryModel.class));


                                            //progressBar.setVisibility(View.GONE);
                                            //scrollView.setVisibility(View.VISIBLE);

                                        }
                                        navCategoryAdapter.notifyDataSetChanged();
                                    }
                                }
                            });
                }

                private void entChangeListener () {

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
               /* search_box.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        if (s.toString().isEmpty()) {
                            viewAllModelList.clear();
                            viewAllAdapter.notifyDataSetChanged();
                        } else {
                            searchProduct(s.toString());}*/


                    }