package com.practicum.newsreader.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.practicum.newsreader.R

class ThemesAdapter(
    private val themesList : List<String>
) : RecyclerView.Adapter<ThemesViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ThemesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_theme, parent,false)

        return ThemesViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ThemesViewHolder,
        position: Int
    ) {
        holder.bind(themesList[position])
    }

    override fun getItemCount(): Int {
        return themesList.size
    }
}