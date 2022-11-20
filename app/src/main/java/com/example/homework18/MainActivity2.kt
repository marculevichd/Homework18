package com.example.homework18

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)




        val btn_save_result = findViewById<Button>(R.id.btn_save_result)
        val rb_nenorm = findViewById<RadioButton>(R.id.rb_nenorm)
        val rb_norm = findViewById<RadioButton>(R.id.rb_norm)
        val rv_please_rate = findViewById<TextView>(R.id.rv_please_rate)

        rb_norm.setOnClickListener {
            if (rb_norm.isChecked) {
                rb_nenorm.isChecked = false
            }
        }
        rb_nenorm.setOnClickListener {
            if (rb_nenorm.isChecked) {
                rb_norm.isChecked = false
            }
        }
        btn_save_result.setOnClickListener{
            if(rb_norm.isChecked){
                Toast.makeText(this, getString(R.string.thx), Toast.LENGTH_SHORT).show()
            } else if (rb_nenorm.isChecked) {
                Toast.makeText(this, getString(R.string.thx), Toast.LENGTH_SHORT).show()
            } else rv_please_rate.text = getString(R.string.please_choose)
        }



    }



}