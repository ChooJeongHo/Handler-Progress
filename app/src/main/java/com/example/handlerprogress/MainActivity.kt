package com.example.handlerprogress

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import android.widget.Button
import android.widget.ProgressBar
import android.widget.RadioButton

class MainActivity : AppCompatActivity() {
    lateinit var progressBar: ProgressBar
    lateinit var btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar = findViewById(R.id.progressBar)
        btn = findViewById(R.id.btn)

        btn.setOnClickListener {
//            var progress = progressBar.progress
//            progressBar.progress = progress + 1


//            handler.sendEmptyMessage(0)
            handler.sendEmptyMessageDelayed(0, 1000)
        }

    }

    var num :Int = 0;
    var handler = object : Handler(){
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            num++
            Log.d("aabb","sec: "+num)
            sendEmptyMessageDelayed(0, 1000)
            progressBar.progress = num
        }
    };

    override fun onDestroy() {
        super.onDestroy()
        handler.removeMessages(0)
    }
}