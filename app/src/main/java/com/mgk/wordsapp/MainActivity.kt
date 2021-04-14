package com.mgk.wordsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mgk.wordsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private var isLinearLayoutManager=true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView=binding.letterRecyclerView
        chooseLayout()

    }
    private fun chooseLayout(){
        if(isLinearLayoutManager){
            recyclerView.layoutManager= LinearLayoutManager(this)
        }
        else{
            recyclerView.layoutManager=GridLayoutManager(this,4)
        }
        recyclerView.adapter=LetterAdapter()
    }
    private fun setIcon(menuItem: MenuItem?) {
        if (menuItem == null)
            return

        // Set the drawable for the menu icon based on which LayoutManager is currently in use

        // An if-clause is used on the right side of an assignment if all paths return a value.

        menuItem.icon =
                if (isLinearLayoutManager)
                    ContextCompat.getDrawable(this, R.drawable.ic_grid_layout)
                else ContextCompat.getDrawable(this, R.drawable.ic_linear_layout)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
            menuInflater.inflate(R.menu.layout_menu,menu)
            val layout_button = menu?.findItem(R.id.action_switch_layout)
            setIcon(layout_button)
            return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_switch_layout->{
                // Sets isLinearLayoutManager (a Boolean) to the opposite value
                isLinearLayoutManager = !isLinearLayoutManager
                // Sets layout and icon
                chooseLayout()
                setIcon(item)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
