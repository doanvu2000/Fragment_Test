package com.example.fragmentdemo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class order_food extends AppCompatActivity {
    Button btn1, btn2;
    String userName = "";
    private static final String TAG = "order_food";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_order_food );
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        btn1 = findViewById( R.id.btn1 );
        btn2 = findViewById( R.id.btn2 );
        getFragment( MenuFoodFragment.newInstance() );
        Intent intent = getIntent();
        userName = intent.getStringExtra( "username" );
        intent.putExtra( "username",userName );
        btn1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragment( MenuFoodFragment.newInstance() );
            }
        } );
        btn2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragment( CartFragMent.newInstance() );
            }
        } );
    }
    public void getFragment(Fragment fragment){
        try {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout,fragment).commit();
        }catch (Exception e){
            e.printStackTrace();
            Log.d(TAG,"getFragment"+e.getMessage());
        }
    }
}