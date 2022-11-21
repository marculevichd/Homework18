package com.example.homework18

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.appcompat.app.AlertDialog
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val button = findViewById<Button>(R.id.button)
        val tiet_login = findViewById<EditText>(R.id.tiet_login)
        val tiet_password = findViewById<EditText>(R.id.tiet_password)
        val textInputLayout_password = findViewById<TextInputLayout>(R.id.textInputLayout_password)
        val textInputLayout_login = findViewById<TextInputLayout>(R.id.textInputLayout_login)


        val dialog = AlertDialog.Builder(this)
            .setTitle("Confirm your data")
            .setCancelable(false)
            .setPositiveButton("Accept") { dialog, _ ->
                val intent_dialog = Intent(this, MainActivity2::class.java)
                startActivity(intent_dialog)
            }
            .setNegativeButton("Nope") { dialog, _ ->
                Toast.makeText(
                    this,
                    getString(R.string.you_must_enter_out_data),
                    LENGTH_SHORT
                ).show()
            }

        button.setOnClickListener {
            if (tiet_login.text.toString().isNullOrBlank()) {
                textInputLayout_login.setErrorIconDrawable(R.drawable.ic_baseline_warning_amber_24)
                tiet_login.error = getString(R.string.you_must_enter_out_data)
            } else if (tiet_password.text.toString().isNullOrBlank()) {
                textInputLayout_password.setErrorIconDrawable(R.drawable.ic_baseline_warning_amber_24)
                tiet_password.error = getString(R.string.you_must_enter_out_data)
            } else dialog.setMessage("Login: " + tiet_login.text.toString()
                    + "\n" + "Password: " + tiet_password.text.toString()).show()
        }
    }
}