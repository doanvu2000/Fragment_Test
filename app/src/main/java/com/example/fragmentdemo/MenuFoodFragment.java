package com.example.fragmentdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragmentdemo.databinding.MenuFoodLayoutBinding;

import java.util.ArrayList;
import java.util.List;

class MenuFoodFragment extends Fragment {
    TextView tvUserName, tvCartCounter, tvPriceCounter;
    ImageView imgCart;

    Button btnOrder;
    RecyclerView lvFoodOrder;
    List<Food> listMenu, listCart;
    int mPossition;
    MenuFoodLayoutBinding binding;

    public static MenuFoodFragment newInstance() {

        Bundle args = new Bundle();

        MenuFoodFragment fragment = new MenuFoodFragment();
        fragment.setArguments( args );
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate( inflater, R.layout.menu_food_layout, container, false );
        Intent intent = new Intent();
        binding.tvUserName.setText( intent.getStringExtra( "username" ) );
        listMenu = new ArrayList<>();
        listCart = new ArrayList<>();
        {
            listMenu.add( new Food( R.drawable.tra_sua, "Trà Sữa", 20 ) );
            listMenu.add( new Food( R.drawable.matcha, "Matcha", 25 ) );
            listMenu.add( new Food( R.drawable.coffe, "Coffe", 20 ) );
            listMenu.add( new Food( R.drawable.sinh_to_dua_hau, "Sinh tố", 15 ) );
            listMenu.add( new Food( R.drawable.tra_chanh, "Trà chanh", 12 ) );
            listMenu.add( new Food( R.drawable.che_buoi, "Chè bưởi", 10 ) );
            listMenu.add( new Food( R.drawable.tao_pho, "Tào Phớ", 7 ) );
            listMenu.add( new Food( R.drawable.sua_chua_mit, "Sữa chua", 10 ) );
            listMenu.add( new Food( R.drawable.dua_dam, "Dừa dầm", 25 ) );
            listMenu.add( new Food( R.drawable.tra_sua, "Trà Sữa", 25 ) );
            listMenu.add( new Food( R.drawable.matcha, "Matcha", 25 ) );
            listMenu.add( new Food( R.drawable.coffe, "Coffe", 25 ) );
            listMenu.add( new Food( R.drawable.sinh_to_dua_hau, "Sinh tố", 20 ) );
            listMenu.add( new Food( R.drawable.com_ga, "Cơm gà", 40 ) );
            listMenu.add( new Food( R.drawable.com_rang, "Cơm rang", 30 ) );
            listMenu.add( new Food( R.drawable.com_suon, "Cơm sườn", 40 ) );
        }
        FoodAdapter adapter = new FoodAdapter( listMenu );
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager( getActivity().getBaseContext(), 3, RecyclerView.VERTICAL, false );
        binding.lvMenuFoodOrder.setAdapter( adapter );
        binding.lvMenuFoodOrder.setLayoutManager( layoutManager );
        adapter.setIonClickFood( new IonClickFood() {
            @Override
            public void onClickName(Food food) {
                int count = Integer.parseInt( binding.tvcartCounter.getText().toString() );
                count++;
                binding.tvcartCounter.setText( String.valueOf( count ) );
                int priceCounter = Integer.parseInt( binding.tvPriceCounter.getText().toString() );
                priceCounter += food.getPriceFood();
                binding.tvPriceCounter.setText( String.valueOf( priceCounter ) );
                mPossition = listMenu.indexOf( food );
                listCart.add( food );
            }

            @Override
            public void onClickImg(Food food) {
                int count = Integer.parseInt( binding.tvcartCounter.getText().toString() );
                count++;
                binding.tvcartCounter.setText( String.valueOf( count ) );
                int priceCounter = Integer.parseInt( binding.tvPriceCounter.getText().toString() );
                priceCounter += food.getPriceFood();
                binding.tvPriceCounter.setText( String.valueOf( priceCounter ) );
                mPossition = listMenu.indexOf( food );
                listCart.add( food );
            }

            @Override
            public void onClickLayout(Food food) {
                int count = Integer.parseInt( binding.tvcartCounter.getText().toString() );
                count++;
                binding.tvcartCounter.setText( String.valueOf( count ) );
                int priceCounter = Integer.parseInt( binding.tvPriceCounter.getText().toString() );
                priceCounter += food.getPriceFood();
                binding.tvPriceCounter.setText( String.valueOf( priceCounter ) );
                mPossition = listMenu.indexOf( food );
                listCart.add( food );
            }
        } );
        //Button Order
        btnOrder.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText( getActivity().getBaseContext(), "Đặt hàng thành công, chúc bạn ngon miệng.", Toast.LENGTH_SHORT ).show();
                binding.tvcartCounter.setText( "0" );
                binding.tvPriceCounter.setText( "0" );
                listCart.clear();
            }
        } );
        //OnclickCart
        imgCart.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent( getActivity().getBaseContext(), Cart.class );
                intent1.putExtra( "totalPrice", binding.tvPriceCounter.getText().toString() );
                intent1.putParcelableArrayListExtra( "list", (ArrayList<Food>) listCart );
                startActivity( intent1 );
            }
        } );
        return binding.getRoot();
    }


}
