package com.example.thefed;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class CategoryFragment extends Fragment {
   /* RecyclerView recyclerView;
    List<Category> categoryList;
    CategoryAdapter categoryAdapter;
    FirebaseFirestore db;*/
  //  ImageView view6;
    TextView whatsap,emai;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_category, container, false);
        View root = inflater.inflate(R.layout.fragment_category, container, false);
   /*     db=FirebaseFirestore.getInstance();
        recyclerView=root.findViewById(R.id.cat_rec);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));

        categoryList=new ArrayList<>();
        //popularAdapters=new PopularAdapters(getActivity(),popularModelList);
        categoryAdapter = new CategoryAdapter(getActivity(),categoryList);
        recyclerView.setAdapter(categoryAdapter);
        changeListener();

        return root;
    }

    private void changeListener() {
        db.collection("Categories2")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        if(error!=null){
                            Log.e("Error",error.getMessage());
                            return;
                        }
                        for (DocumentChange dc: value.getDocumentChanges()){
                            if(dc.getType()== DocumentChange.Type.ADDED){
                                categoryList.add(dc.getDocument().toObject(Category.class));
                            }
                            categoryAdapter.notifyDataSetChanged();
                        }
                    }
                });*/

      //  view6=root.findViewById(R.id.imageView6);
        whatsap=root.findViewById(R.id.callWhatsapp);
        emai=root.findViewById(R.id.callEmai);

        emai.setText(Html.fromHtml("<a href =\"mailto:derfedfederrick@gmail.com\">Email: derfedfederrick@gmail.com</a>"));
        emai.setMovementMethod(LinkMovementMethod.getInstance());

      /*  view6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), HomeActivity.class));
                finish();
            }
        });*/

        whatsap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String wpurl="https://wa.me/+254791088006?text=Hello Admin";
                Intent intent =new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(wpurl));
                startActivity(intent);
            }
        });
        return root;
    }
}