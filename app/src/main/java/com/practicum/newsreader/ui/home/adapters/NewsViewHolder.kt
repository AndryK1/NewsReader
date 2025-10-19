package com.practicum.newsreader.ui.home.adapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.practicum.newsreader.R
import com.practicum.newsreader.domain.data.NewsData

class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(newsList: NewsData){
        val posterPhoto = itemView.findViewById<ImageView>(R.id.news_poster)
        val title = itemView.findViewById<TextView>(R.id.news_description)
        val publisher = itemView.findViewById<TextView>(R.id.publisher)
        val postedTime = itemView.findViewById<TextView>(R.id.published_time)

        Glide.with(itemView.context)
            .load(newsList.urlToImage)
            .transform(CenterCrop())
            .into(posterPhoto)

        title.text = newsList.title
        publisher.text = newsList.author
        postedTime.text = newsList.publishedAt
    }
}