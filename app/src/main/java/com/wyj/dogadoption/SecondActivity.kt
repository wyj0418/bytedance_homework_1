package com.wyj.dogadoption

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val dogImage = intent.getIntExtra("imageId",0)
        val dogName = intent.getStringExtra("name")
        val dogAge = intent.getStringExtra("age")
        val dogGender = intent.getStringExtra("gender")
        val dogPlace = intent.getStringExtra("place")
        val dogIntroduction = intent.getStringExtra("introduction")

        val Image = findViewById<ImageView>(R.id.Image)
        val name = findViewById<TextView>(R.id.name)
        val age = findViewById<TextView>(R.id.age)
        val gender = findViewById<TextView>(R.id.gender)
        val place = findViewById<TextView>(R.id.place)
        val introduction = findViewById<TextView>(R.id.introduction)

        Image.setImageResource(dogImage)
        name.text = "宠物名:\t" + dogName
        age.text = "年龄:\t" + dogAge
        gender.text = "性别:\t" + dogGender
        place.text = "区域:\t" + dogPlace
        introduction.text = "介绍:\t" + dogIntroduction


    }
}