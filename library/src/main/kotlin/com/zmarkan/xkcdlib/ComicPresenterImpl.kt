package com.zmarkan.xkcdlib

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ComicPresenterImpl : ComicPresenter {

    var injector = Injector
    var view: ComicView?

    constructor(view: ComicView?){
        this.view = view
        injector.comicService.getTodaysComic().enqueue(object: Callback<Comic>{
            override fun onResponse(call: Call<Comic>, response: Response<Comic>) {
                view?.showComic(response.body())
            }

            override fun onFailure(call: Call<Comic>, error: Throwable) {
                ComicViewer.callback?.failure(error)
            }
        })
    }

    override fun comicVoted(vote: ComicViewer.VotingResult) {
        ComicViewer.callback?.success(vote)
        view?.destroyView()
    }

    override fun viewDestroyed(){
        view = null
    }
}

