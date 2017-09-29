package com.astu.vk.myapplication

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.util.Size
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL
import android.R.attr.bitmap
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream


/**
 * Created by Korney on 9/29/2017.
 */


class DownloadImageTask(val complitionListener:IBitmapComplitionListener): AsyncTask<ImageParameters,Void,Bitmap?>() {
    fun calculateInSampleSize(
            options: BitmapFactory.Options, requiredWidth: Int, requiredHeight: Int): Int {
        // Raw height and width of image
        val height = options.outHeight
        val width = options.outWidth
        var inSampleSize = 1

        if (height > requiredHeight || width > requiredWidth) {

            val halfHeight = height / 2
            val halfWidth = width / 2

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while (halfHeight / inSampleSize >= requiredHeight && halfWidth / inSampleSize >= requiredWidth) {
                inSampleSize *= 2
            }
        }
        return inSampleSize
    }

    private fun downloadData(stringUrl:String,width:Int,height:Int):Bitmap? {
        var bitmap: Bitmap? = null;
        var inputStream: InputStream? = null
        try {
            val url = URL(stringUrl)
            inputStream = url.openStream()
            bitmap = BitmapFactory.decodeStream(inputStream)
//            var imageOutputStream = ByteArrayOutputStream()
//            bitmap.compress(Bitmap.CompressFormat.PNG, 0 /*ignored for PNG*/, imageOutputStream);
//            val bitmapdata = imageOutputStream.toByteArray()
//            val bitmapInputStream = ByteArrayInputStream(bitmapdata);
//
//            val options = BitmapFactory.Options()
//            options.inJustDecodeBounds = true
//            options.inSampleSize = calculateInSampleSize(options,width,height)
//            bitmap = BitmapFactory.decodeStream(bitmapInputStream, null, options)
            return bitmap
        }
        catch (e:Exception){
            e.printStackTrace();
        }
        finally {
            inputStream?.close()
        }
        return null
    }
    override fun doInBackground(vararg p0: ImageParameters?): Bitmap? {
        try{
            val parameter = p0[0]!!;
            return downloadData(parameter.stringUrl,parameter.width,parameter.height)
        }catch (e:IOException){
            e.printStackTrace()
            return null
        }
    }

    override fun onPostExecute(result: Bitmap?) {
        complitionListener.downloadComplete(result)
    }
}
data class ImageParameters(val stringUrl: String,val width:Int,val height:Int)