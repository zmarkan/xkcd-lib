package com.zmarkan.xkcdlib

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class ComicActivity : AppCompatActivity(), ComicView {

    var title: TextView? = null
    var imageView: ImageView? = null
    var upvoteButton: ImageView? = null
    var downvoteButton: ImageView? = null
    var container: ViewGroup? = null

    object intents {
        fun buildIntent(activityContext: Context): Intent {
            return Intent(activityContext, ComicActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cotd)
        presenter = ComicPresenterImpl(this)
        setupViews()
    }

    override fun showComic(comic: Comic) {
        title?.text = comic.title
        Glide.with(this).load(comic.img).into(imageView)

        imageView?.setOnClickListener({
            Snackbar.make(container!!, comic.alt, Snackbar.LENGTH_LONG).show()
        })

        downvoteButton?.setOnClickListener({presenter?.comicVoted(ComicViewer.VotingResult.DOWNVOTE)})
        upvoteButton?.setOnClickListener({presenter?.comicVoted(ComicViewer.VotingResult.UPVOTE)})
    }

    var presenter: ComicPresenter? = null

    override fun onDestroy() {
        super.onDestroy()
        presenter?.viewDestroyed()
    }

    override fun destroyView() {
        finish()
    }

    private fun setupViews() {
        //Kotlin extensions currently broken so we must do this the old fashoned way :(
        title = findViewById(R.id.title_textview) as TextView
        imageView = findViewById(R.id.xkcd_imageview) as ImageView
        upvoteButton = findViewById(R.id.upvote_button) as ImageView
        downvoteButton = findViewById(R.id.downvote_button) as ImageView
        container = findViewById(R.id.container) as ViewGroup
    }
}
