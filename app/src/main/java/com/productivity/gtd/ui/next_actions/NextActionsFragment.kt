package com.productivity.gtd.ui.next_actions

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.productivity.gtd.R
import com.productivity.gtd.ui.ItemsViewModel

class NextActionsFragment : Fragment() {

    private val viewModel: ItemsViewModel by activityViewModels()
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_next_actions, container, false)
        val textView: TextView = root.findViewById(R.id.text_next_actions)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.i("data", "${viewModel.initialText}")
        viewModel.initialText = "Oh no! It's Dio!!"
        viewModel.items.observe(viewLifecycleOwner, Observer { items ->
//            items.inNew.forEach{
//                if(!it.content.isNullOrEmpty()) {
//                    Log.i("data", "Next action ${it.content!!}")
//                }
//            }
        })
    }
}