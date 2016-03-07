package com.zmarkan.xkcdlib

import android.content.Context
import com.zmarkan.xkcdlib.view.ComicActivity

object ComicViewer {

    var callback: Callback? = null

    /**
     * Main entry point for the library
     * @param activityContext calling activity
     * @param callback gets called when either upvote/downvote happens or a network failure
     * */
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



