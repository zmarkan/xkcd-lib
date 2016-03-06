package com.zmarkan.xkcdlib

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ComicActivity : AppCompatActivity(), ComicView {

    override fun showComic(comic: Comic) {
        throw UnsupportedOperationException()
    }

    var presenter: ComicPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cotd)
        presenter = ComicPresenterImpl(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.viewDestroyed()
    }
}
