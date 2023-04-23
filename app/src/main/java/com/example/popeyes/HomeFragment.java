package com.example.popeyes;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.popeyes.Adapters.MainAdapter;
import com.example.popeyes.Models.MainModel;
import com.example.popeyes.R;
import com.example.popeyes.databinding.FragmentHomeBinding;
import com.example.popeyes.ui.home.HomeViewModel;

import java.util.ArrayList;

public class HomeFragment extends Fragment  implements  RecyclerViewInterface{

    private FragmentHomeBinding binding;

    @Override public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,   @Nullable Bundle savedInstanceState) {


        binding = FragmentHomeBinding.inflate(getLayoutInflater());
        View root = binding.getRoot();


       return root;
    }

    @Override

    public void onViewCreated(@NonNull View view ,@Nullable Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        ArrayList<MainModel> list=new ArrayList<>();
        list.add(new MainModel(R.drawable.pizza,"Pizza","50","Mouth-watering crunch and juicy fried chicken bursting with Louisiana flavor. Explore our menu, offers, and earn rewards on delivery or digital orders. …"));
        list.add(new MainModel(R.drawable.chicken_nuggets,"Nuggets","10","Mouth-watering crunch and juicy fried chicken bursting with Louisiana flavor. Explore our menu, offers, and earn rewards on delivery or digital orders. …"));
        list.add(new MainModel(R.drawable.sandwitch,"Burger","8"," Explore our menu, offers, and earn rewards on delivery or digital orders. …"));
        list.add(new MainModel(R.drawable.seafood_shrilp,"Sea Food","18","Mouth-watering crunch and juicy fried chicken bursting with Louisiana flavor. Explore our menu, offers, and earn rewards on delivery or digital orders. …"));
        list.add(new MainModel(R.drawable.beverages,"Drinks","5"," Explore our menu, offers, and earn rewards on delivery or digital orders. …"));

        MainAdapter adapter=new MainAdapter(list,getActivity(),this);
        binding.recyclerview.setAdapter(adapter);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        binding.recyclerview.setLayoutManager(layoutManager);
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onClickItem(int position) {

        //UserFragment userFragment=new UserFragment();

       // Intent intent=new Intent(getActivity(),orderdetails.class);
       // startActivity(intent);
        //FragmentManager manager= getActivity().getSupportFragmentManager();
       // manager.beginTransaction().replace(R.id.nav_host_fragment_content_main,userFragment).commit();
    }
}