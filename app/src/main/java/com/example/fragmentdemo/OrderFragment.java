package com.example.fragmentdemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.fragmentdemo.databinding.OrderfragmentLayoutBinding;

public class OrderFragment extends Fragment {
    OrderfragmentLayoutBinding binding;
    public static OrderFragment newInstance() {

        Bundle args = new Bundle();

        OrderFragment fragment = new OrderFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.orderfragment_layout,container,false);
//        //Xi li all
//        return view;
        binding =  DataBindingUtil.inflate(inflater,R.layout.orderfragment_layout,container,false);
        binding.tvName.setOnTouchListener( new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        } );

        binding.btnSet.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.tvName.getText().toString().equals( "Click Successfully!" ))
                    binding.tvName.setText( "Hello" );
                else binding.tvName.setText( "Click Successfully!" );
            }
        } );
        return binding.getRoot();
    }
}