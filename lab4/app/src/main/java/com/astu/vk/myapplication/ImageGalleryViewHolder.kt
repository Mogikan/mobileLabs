package com.astu.vk.myapplication

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.sync.Mutex
import org.jetbrains.anko.coroutines.experimental.bg
import java.io.BufferedInputStream
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.net.URL

/**
 * Created by Korney on 9/29/2017.
 */
class ImageGalleryViewHolder(itemView: View?,val width: Int,val height:Int) : RecyclerView.ViewHolder(itemView),IBitmapComplitionListener {
    override fun downloadComplete(bitmap: Bitmap?) {
        itemView.findViewById<ImageView>(R.id.imageView)
                .setImageBitmap(bitmap)
    }

    var bitmap: Bitmap? = null

    fun clearBitmap() {
        if (bitmap != null && !(bitmap!!.isRecycled)) {
            bitmap?.recycle()
        }
        itemView.findViewById<ImageView>(R.id.imageView).setImageBitmap(null)
    }

    fun calculateInSampleSize(
            width: Int, height: Int, requiredWidth: Int, requiredHeight: Int): Int {
        // Raw height and width of image
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

    fun setUrl(stringUrl: String) {
        clearBitmap()
        val locker = Mutex()
        val that = this

        async(UI) {
            locker.lock(that)
            val urlCopy = stringUrl
            val result = bg {

                var bitmap: Bitmap? = null;
                var bufferedStream: BufferedInputStream? = null
                try {
                    val url = URL(stringUrl)
                    bufferedStream = BufferedInputStream(url.openStream())
                    bufferedStream.mark(bufferedStream.available())
                    bitmap = BitmapFactory.decodeStream(bufferedStream)
                    var imageOutputStream = ByteArrayOutputStream()
                    bitmap.compress(Bitmap.CompressFormat.PNG, 0 /*ignored for PNG*/, imageOutputStream);
                    val bitmapdata = imageOutputStream.toByteArray()
                    val options = BitmapFactory.Options()
                    options.inSampleSize = calculateInSampleSize(bitmap.width, bitmap.height, width, height)
                    bufferedStream.reset()
                    bitmap = BitmapFactory.decodeByteArray(bitmapdata, 0, bitmapdata.size, options)

                } catch (e: Exception) {
                    e.printStackTrace();
                } finally {
                    bufferedStream?.close()
                }
                return@bg bitmap
            }
            downloadComplete(result.await())
            locker.unlock(that)
        }
    }

    //DownloadImageTask(this).execute(ImageParameters(stringUrl,width,height))
}
