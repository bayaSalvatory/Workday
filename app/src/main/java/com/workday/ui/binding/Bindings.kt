package com.workday.ui.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("url")
fun imageUrl(
    view: ImageView,
    url: String? = ""
) {
    if (url == null) return
    Glide.with(view.context)
        .asGif()
        .load(url)
        .into(view)
}
