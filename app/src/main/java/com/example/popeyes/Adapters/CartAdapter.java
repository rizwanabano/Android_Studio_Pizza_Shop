package com.example.popeyes.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.popeyes.Models.CartModel;
import com.example.popeyes.Models.MainModel;
import com.example.popeyes.R;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {
    ArrayList list;
    Context context;

    public CartAdapter(ArrayList list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_cart,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final CartModel model= (CartModel) list.get(position);
        holder.foodImage.setImageResource(model.getImage() );
        holder.soldItemName.setText(model.getSoldItemName());
        holder.price.setText(model.getPrice());
        holder.orderNumber.setText(model.getOrder_number());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

            ImageView foodImage;
            TextView soldItemName, price, orderNumber;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                foodImage = itemView.findViewById(R.id.soldFoodImage);
                soldItemName = itemView.findViewById(R.id.soldItemName);
                price = itemView.findViewById(R.id.orderPrice);
                orderNumber = itemView.findViewById(R.id.order_in_number);
            }
        }
    }
