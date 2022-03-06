package com.example.hw1kotlin1

import android.app.Activity
import android.app.Instrumentation
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import com.bumptech.glide.Glide
import com.example.hw1kotlin1.databinding.ActivityMainBinding
import java.security.SecureRandom

class MainActivity : AppCompatActivity() {
    var array = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        randomImage()
        nextActivity()
    }
    private fun nextActivity() {
       
        val button = findViewById<Button>(R.id.btn_clicker)
        val editText = findViewById<EditText>(R.id.et_url)
        button.setOnClickListener{
            array += editText.text.toString()
            editText.text.clear()
        }
    }
    private fun randomImage (){
        val random = SecureRandom()
        val image  = findViewById<ImageView>(R.id.iv_photo)
        val buttonRandom = findViewById<Button>(R.id.btn_random)
        buttonRandom.setOnClickListener(){
            val randomImage = array.get(random.nextInt(array.size))
            Glide.with(this )
                .load(randomImage)
                .into(image)
        }
    }
}