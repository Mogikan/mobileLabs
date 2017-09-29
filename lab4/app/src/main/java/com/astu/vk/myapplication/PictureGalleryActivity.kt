package com.astu.vk.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_picture_gallery.*
class PictureGalleryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picture_gallery)
        imageRecycler.layoutManager = GridLayoutManager(this,4)
        imageRecycler.adapter = ImageGalleryAdapter()
    }
}
