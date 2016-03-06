package com.zmarkan.xkcdlib

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ComicActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cotd)

        val retrofit = Retrofit.Builder()
            .baseUrl("http://xkcd.com")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        val comicService: ComicService = retrofit.create(ComicService::class.java)

        comicService.getTodaysComic().enqueue(object : Callback<Comic> {
            override fun onFailure(p0: Call<Comic>, p1: Throwable) {
                ComicViewer.callback?.failure(p1)
                finish()
            }

            override fun onResponse(p0: Call<Comic>, p1: Response<Comic>) {
                ComicViewer.callback?.success(ComicViewer.VotingResult.UPVOTE)
                finish()
            }

        })

    }
}
