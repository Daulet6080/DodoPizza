package com.example.dodopizza.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dodopizza.databinding.ItemPizzaBinding
import com.example.dodopizza.model.Pizza
import com.example.dodopizza.R


class PizzaAdapter(
    private val onPizzaClick: (Pizza) -> Unit,

    ) : RecyclerView.Adapter<PizzaAdapter.ViewHolder>() {


    private val pizzaList: ArrayList<Pizza> = ArrayList()


    fun setData(pizzas: ArrayList<Pizza>) {
        pizzaList.clear()
        pizzaList.addAll(pizzas)

        /**
         * метод для обновления списка элементов
         */

        notifyDataSetChanged()

    }


    /**
     * метод который будет создавать view для каждого объекта
     * */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemPizzaBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }


    /**
     * метод для определения количество элементов списка
     * */
    override fun getItemCount() = pizzaList.size

    /**
     * для вызова метода из ViewHolder`s
     * */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(pizzaList[position])
    }


    inner class ViewHolder(
        private val binding: ItemPizzaBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(pizza: Pizza) {
            with(binding) {
                mainImage.setImageResource(pizza.images)
                title.text = pizza.title
                description.text = pizza.description
                textPrice.text = root.context.getString(R.string.text_format, pizza.price)

                root.setOnClickListener() {
                    onPizzaClick(pizza)
                }

            }
        }
    }
}
