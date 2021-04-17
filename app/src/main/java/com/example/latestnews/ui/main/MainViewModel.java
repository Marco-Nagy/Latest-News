package com.example.latestnews.ui.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.latestnews.model.Article;
import com.example.latestnews.model.NewsResponse;
import com.example.latestnews.network.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {
    //LiveData , MutableLiveData
    private static final String TAG = "MainViewModel";
    public MutableLiveData<List<Article>> listMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<String> errorMessageMutableLiveData = new MutableLiveData<>();

    public void getNews(String country,String category) {
        RetrofitClient.getClient().getResponseWithParameters(country, category).enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                if (response.isSuccessful()) {
                    listMutableLiveData.postValue(response.body().getArticles());
                }
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                String errorMessage = t.getLocalizedMessage();
                errorMessageMutableLiveData.postValue(errorMessage);

            }
        });
    }
}
