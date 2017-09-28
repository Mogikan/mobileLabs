package com.astu.vk.labs

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class HomeActivity : AppCompatActivity() {
companion object {
    const val requestId = 1001
}

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val textView = findViewById<EditText>(R.id.textToPass)
        findViewById<Button>(R.id.open2ndActivity).setOnClickListener{
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("textParameter",textView.text.toString())
            startActivityForResult(intent,requestId)
        }
    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode== Activity.RESULT_OK)
        {
         if (requestCode == requestId)
         {
             findViewById<TextView>(R.id.resultFromeSecond).setText(data?.extras?.getString("secondExtra"))
         }
        }
    }
}
