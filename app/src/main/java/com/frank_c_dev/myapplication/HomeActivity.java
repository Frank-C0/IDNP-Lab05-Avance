package com.frank_c_dev.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.frank_c_dev.myapplication.databinding.ActivityHomeBinding;
import com.frank_c_dev.myapplication.fragments.CuadroFragment;
import com.frank_c_dev.myapplication.fragments.HomeFragment;
import com.frank_c_dev.myapplication.fragments.MapaFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;

public class HomeActivity extends AppCompatActivity {
    private ActivityHomeBinding binding;

    // variable declaration of fragments and manager
    private FragmentManager fragmentManager = null;
    private FragmentTransaction fragmentTransaction  = null;

    private HomeFragment homeFragment = null;
    private CuadroFragment cuadroFragment = null;
    private MapaFragment mapaFragment = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Gson gson = new Gson();
        AccountEntity accountEntity = gson.fromJson(getIntent().getStringExtra("userData"), AccountEntity.class);

        if(accountEntity != null) {
            binding.titleTextView.setText(String.format("Bienvenido %s", accountEntity.getUsername()));
            binding.userTextView.setText(accountEntity.getUsername());
            binding.nameTextView.setText(String.format("%s %s", accountEntity.getFirstName(), accountEntity.getLastName()));
            binding.emailTextView.setText(accountEntity.getEmail());
            binding.phoneTextView.setText(accountEntity.getPhone());
        }




        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
    }
}