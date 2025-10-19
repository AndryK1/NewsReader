package com.practicum.newsreader.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.isVisible
import com.practicum.newsreader.R
import androidx.fragment.app.Fragment
import com.practicum.newsreader.databinding.FragmentHomeBinding
import com.practicum.newsreader.ui.home.adapters.NewsAdapter
import com.practicum.newsreader.ui.home.adapters.ThemesAdapter
import com.practicum.newsreader.ui.home.viewModels.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val viewModel : HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbar = binding.homeToolbar
        viewModel.observeState().observe(viewLifecycleOwner){
            renderState(it)
        }

        binding.themesList.adapter = ThemesAdapter(listOfThemes)
        val category = "technology"
        val country = "us"

        viewModel.updateNews(category,country)

    }

    private fun renderState(state: HomeState){
        when(state){
            is HomeState.Empty -> {
                binding.foundedNews.isVisible = false
            }
            is HomeState.ShowError -> {
                binding.foundedNews.isVisible = false
            }
            is HomeState.ShowContent -> {
                binding.foundedNews.isVisible = true
                binding.foundedNews.adapter = NewsAdapter(state.data)
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object{
        private val listOfThemes = listOf<String>("Бизнесс", "Развлечения", "Общее", "Здоровье", "Наука", "Спорт", "Технологии")
    }
}