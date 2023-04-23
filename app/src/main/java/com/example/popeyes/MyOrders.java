package com.example.popeyes;

import androidx.appcompat.app.AppCompatActivity;

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
import com.example.popeyes.databinding.ActivityMyOrdersBinding;
import com.example.popeyes.databinding.FragmentCartBinding;

import java.util.ArrayList;

public class MyOrders extends AppCompatActivity {
    ActivityMyOrdersBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyOrdersBinding.inflate(getLayoutInflater());
        setContentView( binding.getRoot());
        dbHelper helper=new dbHelper(this);
        ArrayList<CartModel> list= helper.getOrders();


        CartAdapter adapter=new CartAdapter(list,this);




        binding.ordersRecyclerview.setAdapter(adapter);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        binding.ordersRecyclerview.setLayoutManager(layoutManager);
    }
}