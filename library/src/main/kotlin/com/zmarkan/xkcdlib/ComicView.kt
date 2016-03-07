package com.zmarkan.xkcdlib

interface ComicView {
    fun showComic(comic: Comic)
    fun destroyView()
}