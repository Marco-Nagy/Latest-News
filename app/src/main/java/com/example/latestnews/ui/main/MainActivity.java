package com.example.latestnews.ui.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.latestnews.R;
import com.example.latestnews.adapters.PagerAdapter;
import com.example.latestnews.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    MainViewModel viewModel;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        binding.viewPager.setAdapter(new PagerAdapter(this));
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(binding.tabLayout, binding.viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:
                        tab.setText("الاخبار");
                        break;
                    case 1:
                        tab.setText("الصحة");
                        break;
                    case 2:
                        tab.setText("علمية");
                        break;
                    case 3:
                        tab.setText("الرياضة");
                        break;
                    default:
                        tab.setText("تكنولوجيا");
                        break;
                }
            }
        });
        tabLayoutMediator.attach();

    }
}