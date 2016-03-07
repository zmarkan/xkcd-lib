package com.zmarkan.xkcdlib.data

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object Injector {

    fun buildComicService(): ComicService {
                val retrofit = Retrofit.Builder()
                        .baseUrl("http://xkcd.com")
                        .addConverterFactory(MoshiConverterFactory.create())
                        .build()
                return retrofit.create(ComicService::class.java)
    }

    var comicService: ComicService = buildComicService()
}

