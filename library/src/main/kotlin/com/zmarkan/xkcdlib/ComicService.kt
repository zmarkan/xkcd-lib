package com.zmarkan.xkcdlib

import retrofit2.Call
import retrofit2.http.GET

interface ComicService {
    @GET ("info.0.json")
    fun getTodaysComic(): Call<Comic>
}