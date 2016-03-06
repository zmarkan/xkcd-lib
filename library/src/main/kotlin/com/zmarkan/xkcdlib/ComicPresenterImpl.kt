package com.zmarkan.xkcdlib

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ComicPresenterImpl : ComicPresenter {

    var view: ComicView?
    constructor(view: ComicView?){
        this.view = view

        val retrofit = Retrofit.Builder()
                .baseUrl("http://xkcd.com")
                .addConverterFactory(MoshiConverterFactory.create())
                .build()

        val comicService: ComicService = retrofit.create(ComicService::class.java)
        comicService.getTodaysComic().enqueue(object: Callback<Comic>{
            override fun onResponse(call: Call<Comic>, response: Response<Comic>) {
                view?.showComic(response.body())
            }

            override fun onFailure(call: Call<Comic>, error: Throwable) {
                //TODO how to destroy view
                ComicViewer.callback?.failure(error)
//                view.destroy

            }


        })
    }



    override fun comicVoted(vote: ComicViewer.VotingResult) {
        throw UnsupportedOperationException()
    }

    override fun viewDestroyed(){
        view = null
    }
}

