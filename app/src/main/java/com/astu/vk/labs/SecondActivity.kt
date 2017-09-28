package com.astu.vk.labs

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        findViewById<TextView>(R.id.mainText).setText(this.intent.extras.getString("textParameter"))
        val editText = findViewById<EditText>(R.id.resultTextbox)
        findViewById<Button>(R.id.returnBack).setOnClickListener{
            val resultIntent = Intent()
            resultIntent.putExtra("secondExtra",editText.text.toString())
            setResult(Activity.RESULT_OK,resultIntent)
            finish()
        }
    }
}
/**
 * Created by VK on 9/11/2017.
 */
