package com.workday.data

data class GifResponse(val data: List<Gif> = emptyList())

data class Gif(
    val url: String,
    val title: String,
    val rating: String,
    val images: Images
)

data class Images(val original: Original)

data class Original(val url: String)