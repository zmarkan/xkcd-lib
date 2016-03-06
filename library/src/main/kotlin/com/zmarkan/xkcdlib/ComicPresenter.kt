package com.zmarkan.xkcdlib

interface ComicPresenter {
    fun comicVoted(vote: ComicViewer.VotingResult)
    fun viewDestroyed()
}