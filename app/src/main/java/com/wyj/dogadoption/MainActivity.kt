package com.wyj.dogadoption

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class DogInformation(val imageId: Int, val name:String, val age: String, val gender: String, val place: String, val introduction : String)

class DogAdoptionAdapter(val dogList: ArrayList<DogInformation>):
    RecyclerView.Adapter<DogAdoptionAdapter. ViewHolder>(){
    //private val doglist = ArrayList<Dog>()

    inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val dogImage : ImageView = view.findViewById(R.id.dogImage)
        val dogName : TextView = view.findViewById(R.id.dogName)
        val dogAge : TextView = view.findViewById(R.id.dogAge)
        val dogPlace : TextView = view.findViewById(R.id.dogPlace)
       // val dogGender : TextView = view.findViewById((R.id.dogGender))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        val viewHolder = ViewHolder(view)
        viewHolder.itemView.setOnClickListener {
            val position = viewHolder.adapterPosition
            val dog = dogList[position]
            val intent = Intent(parent.context, SecondActivity::class.java).apply{
                putExtra("imageId",dog.imageId )
                putExtra("name",dog.name )
                putExtra("age",dog.age )
                putExtra("gender",dog.gender )
                putExtra("place",dog.place )
                putExtra("introduction",dog.introduction )
            }
            parent.context.startActivity(intent)
        }
        return viewHolder

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dog = dogList[position]
        holder.dogImage.setImageResource(dog.imageId)
        holder.dogName.text = "宠物名:\t" + dog.name
        holder.dogAge.text = "年龄:\t" + dog.age
        holder.dogPlace.text = "地区:\t" + dog.place
    }

    override fun getItemCount() = dogList.size

}


class MainActivity : AppCompatActivity() {
    private val dogList = ArrayList<DogInformation>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initDogInformations() //初始化小狗信息数据
        val recyclerView = findViewById<RecyclerView>(R.id.Dog)
//        val layoutManager = LinearLayoutManager(this)
        val layoutManager = StaggeredGridLayoutManager(2,
            StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = layoutManager
        val adapter = DogAdoptionAdapter(dogList)
        recyclerView.adapter = adapter


    }

    private fun initDogInformations(){

        repeat(2) {
            dogList.add(DogInformation( R.drawable.dog0, "andy","2岁", "母", "北京", "活泼爱动，喜欢和人亲近，可爱，快pick我"))
            dogList.add(DogInformation( R.drawable.dog1, "bily","1岁", "母", "上海", "喜欢吃肉，跑得很快，快pick我"))
            dogList.add(DogInformation( R.drawable.dog2, "cindy","3岁", "公", "广州", "受过训练，不会拆家，快pick我"))
            dogList.add(DogInformation( R.drawable.dog3, "doa","半岁", "母", "深圳", "很聪明，能看家，快pick我"))
            dogList.add(DogInformation( R.drawable.dog4, "email","2岁", "母", "北京", "好看，活泼，可爱，快pick我"))
            dogList.add(DogInformation( R.drawable.dog5, "funny","1岁", "公", "上海", "喜欢吃肉，跑得很快，快pick我"))
            dogList.add(DogInformation( R.drawable.dog6, "glus","3岁", "公", "广州", "受过训练，好看活泼，快pick我"))
            dogList.add(DogInformation( R.drawable.dog7, "honey","半岁", "母", "深圳", "活泼爱动，快pick我"))
            dogList.add(DogInformation( R.drawable.dog8, "ipad","2岁", "母", "北京", "活泼爱动，喜欢和人亲近，可爱，快pick我"))
            dogList.add(DogInformation( R.drawable.dog9, "jetpack","1岁", "母", "上海", "喜欢吃肉，跑得很快，快pick我"))
            dogList.add(DogInformation( R.drawable.dog10, "kotlin","3岁", "公", "广州", "受过训练，不会拆家，快pick我"))
            dogList.add(DogInformation( R.drawable.dog11, "length","半岁", "母", "深圳", "很聪明，能看家，快pick我"))
            dogList.add(DogInformation( R.drawable.dog12, "matlab","2岁", "母", "北京", "好看，活泼，可爱，快pick我"))
            dogList.add(DogInformation( R.drawable.dog13, "null","1岁", "公", "上海", "喜欢吃肉，跑得很快，快pick我"))
            dogList.add(DogInformation( R.drawable.dog14, "optical","3岁", "公", "广州", "受过训练，好看活泼，快pick我"))
            //dogList.add(DogInformation( R.drawable.dog15, "pink","半岁", "母", "深圳", "活泼爱动，快pick我"))
        }

    }
}
