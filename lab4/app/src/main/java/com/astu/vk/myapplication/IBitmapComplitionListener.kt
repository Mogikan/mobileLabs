package com.astu.vk.myapplication

import android.graphics.Bitmap

/**
 * Created by Korney on 9/29/2017.
 */
interface IBitmapComplitionListener {
    fun downloadComplete(bitmap: Bitmap?)
}