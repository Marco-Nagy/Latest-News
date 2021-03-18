package com.example.latestnews.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.latestnews.R;
import com.example.latestnews.databinding.ListItemBinding;
import com.example.latestnews.model.Article;

import java.util.List;

public class AdapterNews extends RecyclerView.Adapter<AdapterNews.NewsViewHolder> {

    List<Article> articles;
    Context context;

    public AdapterNews(List<Article> articles, Context context) {
        this.articles = articles;
        this.context = context;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new NewsViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.list_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        holder.binding.setArticle(articles.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri link =Uri.parse(articles.get(position).getUrl());
               context.startActivity(new Intent(Intent.ACTION_VIEW,link));
            }
        });
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {

        ListItemBinding binding;

        public NewsViewHolder(@NonNull ListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}
