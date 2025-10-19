package com.practicum.newsreader.ui.home.adapters

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.practicum.newsreader.R

class ThemesViewHolder(
    itemView: View
) : RecyclerView.ViewHolder(itemView) {

    val text : TextView = itemView.findViewById(R.id.text_theme)

    fun bind(theme : String){
        text.text = theme
    }
}