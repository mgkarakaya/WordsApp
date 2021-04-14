package com.mgk.wordsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mgk.wordsapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    /*
    **
    *  In Kotlin, null means the absence of a value. The object may exist or it may be null.
    * If your app tries to access a property or call a function on a null object, the app will crash.
    * To safely access this value, you put a ? after the name.
    * If intent is null, your app won't even attempt to access the extras property,
    * and if extras is null, your code won't even attempt to call getString().
     */
    private lateinit var recyclerView: RecyclerView
    companion object{
        const val LETTER = "letter"
        val SEARCH_PREFIX = "https://www.google.com/search?q="
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val letterId=intent?.extras?.getString(LETTER).toString()


        recyclerView=binding.wordItemView
        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.adapter=WordAdapter(letterId,this)
        // Adds a [DividerItemDecoration] between items
        recyclerView.addItemDecoration(
                DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        )
    }
}