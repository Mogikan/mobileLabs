package com.astu.vk.myapplication

import android.graphics.Bitmap
import android.os.AsyncTask
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView

/**
 * Created by Korney on 9/29/2017.
 */
class ImageGalleryViewHolder(itemView: View?,val width: Int,val height:Int) : RecyclerView.ViewHolder(itemView),IBitmapComplitionListener {
    override fun downloadComplete(bitmap: Bitmap?) {
        itemView.findViewById<ImageView>(R.id.imageView)
                .setImageBitmap(bitmap)
    }


    fun setUrl(url:String){
        DownloadImageTask(this).execute(ImageParameters(url,width,height))
    }
}