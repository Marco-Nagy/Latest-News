package com.example.latestnews.network;

import com.example.latestnews.model.NewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApis {
    @GET("v2/top-headlines?country=eg&category=general&apiKey=fa72aea7f1af46a6a45be8aa23e21b64")
    Call<NewsResponse> getResponse();
    @GET("v2/top-headlines?apiKey=fa72aea7f1af46a6a45be8aa23e21b64")
    Call<NewsResponse> getResponseWithParameters(@Query("country")String country,
                                                 @Query("category")String category);
}
