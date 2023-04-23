package com.example.popeyes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.popeyes.Adapters.CartAdapter;
import com.example.popeyes.Adapters.MainAdapter;
import com.example.popeyes.Models.CartModel;
import com.example.popeyes.R;
import com.example.popeyes.databinding.FragmentCartBinding;

import java.util.ArrayList;

public class CartFragment extends Fragment {

      FragmentCartBinding binding;


    @Override public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,   @Nullable Bundle savedInstanceState) {


        binding = FragmentCartBinding.inflate(getLayoutInflater());
        View root = binding.getRoot();


        return root;
    }
    @Override

    public void onViewCreated(@NonNull View view ,@Nullable Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        ArrayList<CartModel> list=new ArrayList<>();
        list.add(new CartModel(R.drawable.sandwitch,"Burger","15","154702"));
        list.add(new CartModel(R.drawable.sandwitch,"Burger","15","154708"));

        dbHelper helper=new dbHelper(getActivity());
     //list= helper.getOrders();


        CartAdapter adapter=new CartAdapter(list,getActivity());
        binding.cartRecyclerview.setAdapter(adapter);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        binding.cartRecyclerview.setLayoutManager(layoutManager);



    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}