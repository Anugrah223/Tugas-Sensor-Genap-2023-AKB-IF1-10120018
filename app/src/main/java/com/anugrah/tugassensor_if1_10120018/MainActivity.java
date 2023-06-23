package com.anugrah.tugassensor_if1_10120018;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.anugrah.tugassensor_if1_10120018.databinding.ActivityMainBinding;

//Nama  : M.Anugrah Ikhsan K
//NIM   : 10120018
//Kelas : IF 1


public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFagment(new MapsFragment());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()){
                case R.id.maps:
                    replaceFagment(new MapsFragment());
                    break;
                case R.id.m_terdekat:
                    replaceFagment(new FoodFragment());
                    break;
                case R.id.profile:
                    replaceFagment(new ProfileFragment());
                    break;
                case R.id.info:
                    replaceFagment(new AppInfoFragment());
                    break;

            }

            return true;
        });
    }

    private void replaceFagment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentBase,fragment);
        fragmentTransaction.commit();
    }
}