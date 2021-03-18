package com.example.latestnews.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.latestnews.ui.newsfragments.GeneralFragment;

public class PagerAdapter extends FragmentStateAdapter {
    public PagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new GeneralFragment("eg","general");
            case 1:
                return new GeneralFragment("eg","health");
            case 2:
                return new GeneralFragment("eg","science");
            case 3:
                return new GeneralFragment("eg","sports");
            default:
                return new GeneralFragment("eg","technology");
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }

}