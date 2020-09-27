package com.workday.buildsrc

object Dependencies {

    const val moshi = "com.squareup.moshi:moshi:1.9.3"
    const val gson = "com.google.code.gson:gson:2.8.6"

    object MvRx {
        private const val version = "1.4.0"
        const val mvRx = "com.airbnb.android:mvrx:$version"
        const val mvRxTesting = "com.airbnb.android:mvrx-testing:$version"
    }

    object Epoxy {
        private const val version = "3.9.0"
        const val epoxy = "com.airbnb.android:epoxy:$version"
        const val epoxyProcessor = "com.airbnb.android:epoxy-processor:$version"
        const val dataBinding = "com.airbnb.android:epoxy-databinding:$version"
    }

    object RxJava {
        const val rxJava = "io.reactivex.rxjava2:rxjava:2.2.11"
        const val rxAndroid = "io.reactivex.rxjava2:rxandroid:2.1.1"
    }

    object Glide {
        private const val version = "4.11.0"
        const val glide = "com.github.bumptech.glide:glide:$version"
        const val compiler = "com.github.bumptech.glide:compiler:$version"
    }

    object Retrofit {
        private const val version = "2.9.0"
        const val retrofit = "com.squareup.retrofit2:retrofit:$version"
        const val retrofit_rxjava_adapter = "com.squareup.retrofit2:adapter-rxjava2:$version"
        const val moshiConverter = "com.squareup.retrofit2:converter-moshi:$version"
        const val gsonConverter = "com.squareup.retrofit2:converter-gson:$version"
    }

    object OkHttp {
        private const val version = "4.1.0"
        const val okhttp = "com.squareup.okhttp3:okhttp:$version"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:$version"
    }

    object Koin {
        private const val version = "2.0.1"
        const val koin = "org.koin:koin-android:$version"
        const val koinScope = "org.koin:koin-androidx-scope:$version"
        const val koinViewModel = "org.koin:koin-androidx-viewmodel:$version"
    }
}