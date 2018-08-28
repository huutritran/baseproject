package com.example.trith.baseproject.common

import android.support.annotation.LayoutRes
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import org.jetbrains.anko.layoutInflater

/**
 * Created by tri.th on 24/08/2018.
 */

/**
 * Click listener setter that prevents double click on the view it's set
 */
fun View.singleClick(l: (android.view.View?) -> Unit) {
    setOnClickListener(SingleClickListener(l))
}

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return context.layoutInflater.inflate(layoutRes, this, attachToRoot)
}

fun ImageView.loadImage(url: String) {
    Glide.with(context).load(url).into(this)
}

fun ImageView.loadCircleImage(url: String) {
    Glide.with(context)
            .load(url)
            .apply(RequestOptions().circleCrop())
            .into(this)
}
