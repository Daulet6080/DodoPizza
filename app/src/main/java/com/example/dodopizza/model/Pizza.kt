package com.example.dodopizza.model

import java.io.Serializable
import java.util.UUID

data class Pizza(
    val id:String = UUID.randomUUID().toString(),
    val title:String,
    val description:String,
    val price:String,
    val images:Int,
    val ingredients:String,
) : Serializable


