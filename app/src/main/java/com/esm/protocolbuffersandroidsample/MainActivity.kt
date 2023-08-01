package com.esm.protocolbuffersandroidsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mainViewModel.firstName.observe(this, {
            findViewById<TextView>(R.id.textView).text = it.firstName
            Log.d("FirstName", it.firstName)
            Log.d("LastName", it.lastName)
            Log.d("AgeName", it.age.toString())
        })

        findViewById<Button>(R.id.save_btn).setOnClickListener {
            val firstName = findViewById<EditText>(R.id.text).text.toString()
            Toast.makeText(this,firstName+"SAVED",Toast.LENGTH_SHORT).show()
            mainViewModel.updateValue(firstName, "Jovanovic", 25)
        }

    }
}