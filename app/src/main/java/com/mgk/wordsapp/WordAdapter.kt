package com.mgk.wordsapp

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class WordAdapter(val letter: String,context: Context) :RecyclerView.Adapter<WordAdapter.WordViewHolder>() {


    private val filteredWords:List<String>

    init {
        val wordList=context.resources.getStringArray(R.array.words).toList()

        filteredWords=wordList.filter { it.startsWith(letter,ignoreCase = true) }.shuffled().take(5).sorted()
    }


    class WordViewHolder(view: View):RecyclerView.ViewHolder(view){
        val button: Button = view.findViewById(R.id.button_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val layout=LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false)
        return WordViewHolder(layout)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val word = filteredWords[position]
        val context=holder.button.context
        holder.button.text=word
        holder.button.setOnClickListener {
            val queryURL:Uri=Uri.parse("${DetailActivity.SEARCH_PREFIX}${word}")
            val intent=Intent(Intent.ACTION_VIEW,queryURL)
            context.startActivity(intent)

        }
    }

    override fun getItemCount(): Int {
        return filteredWords.size
    }
}