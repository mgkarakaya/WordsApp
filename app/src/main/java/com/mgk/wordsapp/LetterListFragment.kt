package com.mgk.wordsapp

import android.os.Bundle
import android.view.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mgk.wordsapp.databinding.FragmentLetterListBinding


class LetterListFragment : Fragment() {

    /*
    ** FragmentLetterListBinding? and it should have an initial value of null. Why make it nullable?
    * Because you can't inflate the layout until onCreateView() is called.
    * There's a period of time in-between when the instance of LetterListFragment is created
    * (when its lifecycle begins with onCreate()) and when this property is actually usable.
    * Also keep in mind that fragments' views can be created and
    * destroyed several times throughout the fragment's lifecycle.
    * For this reason you also need to reset the value in another lifecycle method, onDestroyView().
     */
    private var _binding: FragmentLetterListBinding? = null
    private lateinit var recyclerView: RecyclerView
    private val binding get() = _binding!!
    private var isLinearLayoutManager: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentLetterListBinding.inflate(inflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView=binding.letterRecyclerView
        chooseLayout()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
    private fun chooseLayout(){
        if(isLinearLayoutManager){
            recyclerView.layoutManager= LinearLayoutManager(context)
        }
        else{
            recyclerView.layoutManager= GridLayoutManager(context,4)
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
                ContextCompat.getDrawable(this.requireContext(), R.drawable.ic_grid_layout)
            else ContextCompat.getDrawable(this.requireContext(), R.drawable.ic_linear_layout)
    }

    override fun onCreateOptionsMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.layout_menu,menu)
        val layout_button = menu.findItem(R.id.action_switch_layout)
        setIcon(layout_button)
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