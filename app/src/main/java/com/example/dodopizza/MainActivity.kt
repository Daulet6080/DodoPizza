package com.example.dodopizza

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dodopizza.adapter.PizzaAdapter
import com.example.dodopizza.databinding.ActivityMainBinding
import com.example.dodopizza.model.Pizza
import com.example.dodopizza.model.PizzaDataSource

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var pizzaAdap: PizzaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pizzaAdap = PizzaAdapter(
            onPizzaClick = {
                handlePizzaClick(it)
            },
        )
        binding.recyclerView.adapter = pizzaAdap

        pizzaAdap.setData(PizzaDataSource.pizzaList)

        setupSearch()
    }
    private fun handlePizzaClick(pizza: Pizza){
        val intent = Intent(this@MainActivity, SecondActivity::class.java)
        intent.putExtra("Pizza", pizza)
        startActivity(intent)
    }

    private fun setupSearch() {
        binding.searchView.setOnQueryTextListener(object : android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }
        })
    }

    private fun filterList(text: String?) {
        val filteredList = PizzaDataSource.pizzaList.filter {
            it.title.contains(text ?: "", ignoreCase = true)
        }
        pizzaAdap.setData(ArrayList(filteredList))
    }
}