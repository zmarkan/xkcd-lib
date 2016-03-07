package com.zmarkan.xkcdlib.view

import com.zmarkan.xkcdlib.ComicViewer

interface ComicPresenter {
    fun comicVoted(vote: ComicViewer.VotingResult)
    fun viewDestroyed()
}