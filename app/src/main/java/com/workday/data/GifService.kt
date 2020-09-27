package com.workday.data

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface GifService {

    @GET("trending")
    fun getGifs(@Query("api_key") apiKey: String = "dc6zaTOxFJmzC"): Observable<GifResponse>

    @GET("search")
    fun search(
        @Query("api_key") apiKey: String = "dc6zaTOxFJmzC",
        @Query("q") searchWord: String
    ): Observable<GifResponse>
}