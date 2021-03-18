package com.example.latestnews.ui.newsfragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.latestnews.R;
import com.example.latestnews.adapters.AdapterNews;
import com.example.latestnews.databinding.FragmentGeneralBinding;
import com.example.latestnews.model.Article;
import com.example.latestnews.ui.main.MainViewModel;

import java.util.List;


public class GeneralFragment extends Fragment {

    public GeneralFragment() {
        // Required empty public constructor
    }

    FragmentGeneralBinding binding;
    MainViewModel viewModel;
    String country,category;

    public GeneralFragment(String country, String category) {
        this.country = country;
        this.category = category;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_general, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        viewModel.getNews(country,category);
        viewModel.listMutableLiveData.observe(this, new Observer<List<Article>>() {
            @Override
            public void onChanged(List<Article> articles) {
                AdapterNews adapterNews =new AdapterNews(articles,getContext());
                binding.newsRecyclerView.setAdapter(adapterNews);
            }
        });
        viewModel.errorMessageMutableLiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String errorMessage) {
                Toast.makeText(getContext(), errorMessage, Toast.LENGTH_SHORT).show();

            }
        });

    }
}