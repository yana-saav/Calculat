package com.example.calculat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView


class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val result =findViewById<TextView>(R.id.result)
        val result1= intent.getDoubleExtra("result",0.0)
        val longRes = result1.toLong()
        if (result1 == longRes.toDouble())
            result.text=longRes.toString()
        else  result.text=result1.toString()
    }
}