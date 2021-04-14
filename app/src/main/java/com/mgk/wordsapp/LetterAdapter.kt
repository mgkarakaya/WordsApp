package com.mgk.wordsapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView
import com.mgk.wordsapp.DetailActivity.Companion.LETTER

class LetterAdapter: RecyclerView.Adapter<LetterAdapter.LetterViewHolder>() {

    //generates an char array from A to Z than converts into a list
    private val list= ('A').rangeTo('Z').toList()

    //
    class LetterViewHolder (val view: View) : RecyclerView.ViewHolder(view){
        val button= view.findViewById<Button>(R.id.button_item)
    }

    /**
     * Creates new views with R.layout.item_view as its template
     * returns a ViewHolder
     * parent is always RecyclerView
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LetterViewHolder {
        val layout=LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false)
        return LetterViewHolder(layout)
    }

    //onBindViewHolder is called by RecyclerView to display a single list item
    //Replaces the content of an existing view with new data
    override fun onBindViewHolder(holder: LetterViewHolder, position: Int) {
        val item = list.get(position)
        holder.button.text=item.toString()
        holder.button.setOnClickListener {
            val context=holder.view.context
            val intent=Intent(context,DetailActivity::class.java)
            intent.putExtra(LETTER, holder.button.text.toString())
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

}