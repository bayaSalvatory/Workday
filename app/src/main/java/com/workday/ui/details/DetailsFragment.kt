package com.workday.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.airbnb.mvrx.BaseMvRxFragment
import com.airbnb.mvrx.activityViewModel
import com.airbnb.mvrx.withState
import com.workday.R
import com.workday.databinding.DetailsFragmentBinding
import com.workday.ui.home.HomeViewModel

class DetailsFragment : BaseMvRxFragment() {

    private val viewModel: HomeViewModel by activityViewModel()
    private lateinit var binding: DetailsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DetailsFragmentBinding.inflate(inflater).apply {
            lifecycleOwner = this@DetailsFragment
        }
        return binding.root
    }

    override fun invalidate() = withState(viewModel) {
        val gif = it.gif
        if (gif != null) {
            binding.imageUrl = gif.images.original.url
            binding.title = getString(R.string.rating, gif.title)
            binding.ratings = getString(R.string.rating, gif.rating)
        }
    }

}