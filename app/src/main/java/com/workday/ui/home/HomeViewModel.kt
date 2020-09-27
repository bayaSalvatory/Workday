package com.workday.ui.home

import com.airbnb.mvrx.*
import com.workday.data.Gif
import com.workday.data.GifResponse
import com.workday.data.GifsRepo
import com.workday.ui.base.BaseViewModel
import org.koin.android.ext.android.inject

data class HomeState(
    val gifsRequest: Async<GifResponse> = Uninitialized,
    val gifs: List<Gif> = emptyList(),
    val gif: Gif? = null
) : MvRxState

class HomeViewModel(state: HomeState, private val gifsRepo: GifsRepo) :
    BaseViewModel<HomeState>(state) {

    init {
        gifsRepo.getTrendingGifs().execute {
            copy(gifsRequest = it, gifs = it()?.data ?: emptyList())
        }
    }

    fun selectGif(gif: Gif?) {
        setState { copy(gif = gif) }
    }

    fun searchGifs(searchKey: String) {
        gifsRepo.searchGifs(searchKey).execute {
            copy(gifsRequest = it, gifs = it()?.data ?: emptyList())
        }
    }

    companion object : MvRxViewModelFactory<HomeViewModel, HomeState> {
        override fun create(viewModelContext: ViewModelContext, state: HomeState): HomeViewModel? {
            val gifsRepo: GifsRepo by viewModelContext.activity.inject()
            return HomeViewModel(state, gifsRepo)
        }
    }
}