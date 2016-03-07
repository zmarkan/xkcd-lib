package com.zmarkan.xkcdlib.view

import com.zmarkan.xkcdlib.data.Comic

interface ComicView {
    fun showComic(comic: Comic)
    fun destroyView()
}