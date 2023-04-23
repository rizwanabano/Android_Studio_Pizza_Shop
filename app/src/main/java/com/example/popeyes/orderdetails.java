package com.example.popeyes;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;


public class orderdetails extends Fragment {


    RadioButton mild,spicy,carte,combo,platter;
    Button continue_order;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_orderdetails, container, false);
    }

    @Override
    public void onStart(){
        super.onStart();


        mild=getView().findViewById(R.id.mild);
        spicy=getView().findViewById(R.id.spicyy);
        carte=getView().findViewById(R.id.carte);
        combo=getView().findViewById(R.id.combo);
        platter=getView().findViewById(R.id.platter);
        continue_order=getView().findViewById(R.id.order);

        continue_order.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                StringBuilder stringBuilder=new StringBuilder();
                Bundle bundle=new Bundle();
                if(mild.isChecked()){
                    stringBuilder.append("Mild, ");
                }
                if(spicy.isChecked()) {
                    stringBuilder.append("Spicy, ");
                }
                if(carte.isChecked()){
                    stringBuilder.append(" A la Carte,");
                }
                if(combo.isChecked()){
                    stringBuilder.append(" combo,");
                }
                if(platter.isChecked()){
                    stringBuilder.append(" platter,");
                }
                if(stringBuilder.toString().length()!=0){
                    stringBuilder.append(" with given sauce has added to the cart ");
                    Toast.makeText(getActivity(), stringBuilder.toString(), Toast.LENGTH_SHORT).show();


                    bundle.putString("description", stringBuilder.toString());



                    UserFragment userFragment=new UserFragment();
                    userFragment.setArguments(bundle);
                    FragmentManager manager=getParentFragmentManager();
                    manager.beginTransaction().replace(R.id.nav_host_fragment_content_main,userFragment).commit();


                }
                else
                    Toast.makeText(getActivity(), "Please choose your preferences", Toast.LENGTH_SHORT).show();


            }
        });







    }
}
