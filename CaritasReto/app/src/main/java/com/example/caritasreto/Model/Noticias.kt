package com.example.caritasreto.Model

class Noticias {
    lateinit var description: String
    lateinit var category: String
    lateinit var pubDate: String
    lateinit var link: String
    lateinit var title: String


    private var image: Int = 0

    fun getDescipcion(): String{
        return description
    }

    fun getTitulo(): String{
        return title
    }

    fun getCategoria(): String{
        return category
    }

}