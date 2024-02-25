package com.example.dodopizza

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dodopizza.databinding.ActivityMainBinding
import com.example.dodopizza.databinding.ActivitySecondBinding
import com.example.dodopizza.model.Pizza

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pizza = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            intent.getSerializableExtra("Pizza",Pizza::class.java) as Pizza
        } else {
            intent.getSerializableExtra("Pizza") as Pizza
        }

        with(binding){
            mainImage.setImageResource(pizza.images)
            title.text = pizza.title
            description.text = pizza.description
            indridient.text = pizza.ingredients
            btnBuy.text = getString(R.string.btn_format, pizza.price)

            back.setOnClickListener(){
                finish()
            }

        }

    }
}