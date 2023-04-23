package com.example.popeyes.Adapters;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.popeyes.HomeFragment;
import com.example.popeyes.Models.MainModel;
import com.example.popeyes.R;
import com.example.popeyes.RecyclerViewInterface;
import com.example.popeyes.UserFragment;

import java.time.Instant;
import java.util.ArrayList;


public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    private final RecyclerViewInterface recyclerViewInterface;
    ArrayList list;
    Context context;

    public MainAdapter(ArrayList list, Context context,RecyclerViewInterface recyclerViewInterface) {
        this.list = list;
        this.context = context;
        this.recyclerViewInterface=recyclerViewInterface;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_mainfood,parent,false);
        return new ViewHolder(view,recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
   final MainModel model= (MainModel) list.get(position);
   holder.foodImage.setImageResource(model.getImage() );
   holder.mainName.setText(model.getName());
  // holder.price.setText(model.getPrice());
   holder.description.setText(model.getDescription());





    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView foodImage;
        TextView mainName,price,description;
        public ViewHolder(@NonNull View itemView ,RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
            foodImage=itemView.findViewById(R.id.soldFoodImage);
            mainName=itemView.findViewById(R.id.soldItemName);
          //  price=itemView.findViewById(R.id.orderPrice);
            description=itemView.findViewById(R.id.order_number);
       itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if(recyclerViewInterface!=null) {
                   int pos = getAdapterPosition();
                   if (pos != RecyclerView.NO_POSITION) {

                       AppCompatActivity activity = (AppCompatActivity) view.getContext();
                       UserFragment userFragment = new UserFragment();
                       activity.getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_main, userFragment).commit();
                   }
               }
           }
       });
        }
    }
}

