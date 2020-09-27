package com.workday.data

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class GifsRepo(private val workdayClient: WorkdayClient) {

    fun searchGifs(searchKey: String): Observable<GifResponse> =
        workdayClient.gifService()
            .search(searchWord = searchKey)
            .subscribeOn(Schedulers.io())

    fun getTrendingGifs(): Observable<GifResponse> =
        workdayClient.gifService()
            .getGifs()
            .subscribeOn(Schedulers.io())
}