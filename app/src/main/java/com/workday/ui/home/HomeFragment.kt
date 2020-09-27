package com.workday.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.mvrx.activityViewModel
import com.airbnb.mvrx.withState
import com.workday.R
import com.workday.data.Gif
import com.workday.databinding.HomeFragmentBinding
import com.workday.ui.base.BaseFragment
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment : BaseFragment() {

    private val viewModel: HomeViewModel by activityViewModel()
    private lateinit var binding: HomeFragmentBinding

    private val homeGifController = GifsEpoxyController().apply {
        callbacks = object : GifsEpoxyController.Callbacks {
            override fun onItemClicked(gif: Gif) {
                viewModel.selectGif(gif)
                showDetailsView()
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = HomeFragmentBinding.inflate(inflater).apply {
            lifecycleOwner = this@HomeFragment
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        gif_lv.apply {
            setController(homeGifController)
            layoutManager = GridLayoutManager(
                requireContext(),
                2,
                RecyclerView.VERTICAL,
                false
            )
        }
    }

    private fun showDetailsView() {
        findNavController().navigate(R.id.action_homeFragment_to_detailsFragment)
    }

    override fun invalidate() = withState(viewModel) {
        homeGifController.setData(it)
    }

}