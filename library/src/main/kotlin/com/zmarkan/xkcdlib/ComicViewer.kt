package com.zmarkan.xkcdlib

import android.content.Context
import android.content.Intent

object ComicViewer {

    var callback: Callback? = null

    fun viewComicOfTheDAy(activityContext: Context, callback: Callback) {
        this.callback = callback
        activityContext.startActivity(Intent(activityContext, ComicActivity::class.java))
    }

    interface Callback {
        fun success(result: VotingResult)
        fun failure(error: Throwable)

    }

    enum class VotingResult{
        UPVOTE, DOWNVOTE
    }
}



