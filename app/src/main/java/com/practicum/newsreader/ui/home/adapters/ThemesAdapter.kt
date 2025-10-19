package com.practicum.newsreader.ui.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.practicum.newsreader.R
import com.practicum.newsreader.ui.home.adapters.ThemesViewHolder

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