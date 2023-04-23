package com.example.popeyes;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.popeyes.databinding.FragmentGalleryBinding;
import com.example.popeyes.databinding.FragmentUserBinding;
import com.example.popeyes.ui.contactus.GalleryViewModel;
import com.example.popeyes.databinding.FragmentUserBinding;

public class UserFragment extends Fragment {
   final int base_price=15;
    @Override public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    private FragmentUserBinding binding;
    private int updated_quantity=1;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentUserBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        Bundle bundle=getArguments();

        binding.detailDetails.setText(bundle.getString("description"));

        if (bundle==null){

            Toast.makeText(getActivity(), "null", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getActivity(), "not null", Toast.LENGTH_SHORT).show();
        }



        return root;
    }

    public void onViewCreated(@NonNull View view ,@Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        dbHelper helper=new dbHelper(getActivity());

        binding.insertNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isInserted=helper.insertOrder( binding.customerName.getText().toString(),
                        binding.customerPhone.getText() .toString());



                if(isInserted)
                {
                    Toast.makeText(getActivity(), "Data Success", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(getActivity(), "Failure", Toast.LENGTH_SHORT).show();

            }
        });
        binding.update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isUpdated=helper.updateOrder( binding.customerName.getText().toString(),
                        binding.customerPhone.getText() .toString());



                if(isUpdated)
                {
                    Toast.makeText(getActivity(), "Order updated", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(getActivity(), "Failure", Toast.LENGTH_SHORT).show();

            }
        });
        binding.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res= helper.getData();
                if(res.getCount()==0) {

                    Toast.makeText(getActivity(), "No Data Entry", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    StringBuffer stringBuffer = new StringBuffer();
                    while (res.moveToNext()) {
                        stringBuffer.append("Order No:" + res.getString(0) + "\n");
                        stringBuffer.append("Customer Name:" + res.getString(1) + "\n");
                        stringBuffer.append("Customer Phone:" + res.getString(2) + "\n");
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setCancelable(true);
                    builder.setTitle("User Order");
                    builder.setMessage(stringBuffer.toString());
                    builder.show();
                }
            }
        });
        binding.del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isDeleted=helper.deleteOrder( binding.customerName.getText().toString());
                if(isDeleted)
                {
                    Toast.makeText(getActivity(), "Order Deleted", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(getActivity(), "Failure", Toast.LENGTH_SHORT).show();

            }

        });
        binding.btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                        updated_quantity=updated_quantity+1;
                binding.quantity.setText(updated_quantity + "");
                binding.detailprice.setText((base_price *updated_quantity) +"");
            }
        });
        binding.btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(updated_quantity>=1) updated_quantity=updated_quantity-1;
                binding.quantity.setText(updated_quantity + "");
                binding.detailprice.setText((base_price *updated_quantity) +"");
            }
        });
    }



        @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}