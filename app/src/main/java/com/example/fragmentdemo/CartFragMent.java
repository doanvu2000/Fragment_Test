package com.example.fragmentdemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.fragmentdemo.databinding.CartLayoutBinding;

class CartFragMent extends Fragment {
    CartLayoutBinding binding;
    public static CartFragMent newInstance() {
        
        Bundle args = new Bundle();
        
        CartFragMent fragment = new CartFragMent();
        fragment.setArguments( args );
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate( inflater,R.layout.cart_layout,container,false );

        return binding.getRoot();
    }
}
