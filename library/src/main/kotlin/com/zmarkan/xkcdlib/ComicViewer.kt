package com.zmarkan.xkcdlib

import android.content.Context

object ComicViewer {

    var callback: Callback? = null

    fun viewComicOfTheDAy(activityContext: Context, callback: Callback) {
        this.callback = callback
        activityContext.startActivity(ComicActivity.intents.buildIntent(activityContext))
    }

    interface Callback {
        fun success(result: VotingResult)
        fun failure(error: Throwable)
    }

    enum class VotingResult{
        UPVOTE, DOWNVOTE
    }
}



