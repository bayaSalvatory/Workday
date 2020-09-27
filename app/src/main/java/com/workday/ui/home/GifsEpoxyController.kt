package com.workday.ui.home

import com.airbnb.epoxy.TypedEpoxyController
import com.workday.data.Gif
import com.workday.itemGif

class GifsEpoxyController : TypedEpoxyController<HomeState>() {

    interface Callbacks {
        fun onItemClicked(gif: Gif)
    }

    var callbacks: Callbacks? = null

    override fun buildModels(data: HomeState?) {
        if (data == null) return

        var id = 0
        data.gifs.forEach {
            itemGif {
                id(id++)
                imageUrl(it.images.original.url)
                clickListener { _ -> callbacks?.onItemClicked(it)}
            }
        }
    }
}