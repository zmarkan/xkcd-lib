package com.zmarkan.xkcdlib

interface ComicPresenter {
    fun initialise(callback: ComicViewer.Callback)
    fun viewDestroyed()
}