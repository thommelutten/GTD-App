package com.productivity.gtd.ui.`in`

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.productivity.gtd.R
import com.productivity.gtd.ui.ItemsViewModel

class InFragment : Fragment() {

    private lateinit var fileName: String

    private lateinit var items: MutableCollection<String>

    private val viewModel: ItemsViewModel by activityViewModels()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_in, container, false)
        val userInput: TextView = root.findViewById(R.id.userInput)
        val textInput: TextView = root.findViewById(R.id.text_in)
        items = mutableSetOf()


//        inViewModel.items.observe(viewLifecycleOwner, Observer {
//            textInput.text = it.joinToString(",")
//        })

//        inViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })

//        fileName = "demoFile.txt"
//
//        val jsonFileParser: JSONFileParser = JSONFileParser(fileName)
//
//        jsonFileParser.ParseFile()

//        val buttonRead = root.findViewById<Button>(R.id.read_button)
//        val buttonWrite = root.findViewById<Button>(R.id.write_button)
//        //val userInput = root.findViewById<EditText>(R.id.userInput)
//
//        val fileContent = root.findViewById<TextView>(R.id.content)
//        buttonWrite.setOnClickListener(View.OnClickListener {
//            val fileOutputStream : FileOutputStream?
//            try {
//                fileOutputStream = activity?.openFileOutput(fileName, Context.MODE_PRIVATE)
//                fileOutputStream?.write(userInput.text.toString().toByteArray())
//            } catch (e: Exception) {
//                e.printStackTrace()
//            }
//
//            Toast.makeText(activity?.applicationContext, "Data saved", Toast.LENGTH_LONG).show()
            //userInput.text.clear()
//        })
//
//        buttonRead.setOnClickListener {
//            var fileInputStream: FileInputStream? = activity?.openFileInput(fileName)
//            var inputStreamReader = InputStreamReader(fileInputStream)
//            var bufferedReader = BufferedReader(inputStreamReader)
//
//            val stringBuilder: StringBuilder = java.lang.StringBuilder()
//            var text: String? = null
//            while ({ text = bufferedReader.readLine(); text}() != null)  {
//                stringBuilder.append(text)
//            }
//
//            fileContent.text = stringBuilder.toString()
//        }
//
        val add = root.findViewById<FloatingActionButton>(R.id.fab)
//
        add.setOnClickListener() {
            addItem(textInput)
        }

        return root
    }

//    private fun updateList(textInput: TextView) {
//        textInput.text = (inViewModel.items).value?.joinToString(",")
//    }

    private fun addItem(textInput: TextView) {
        val builder = context?.let { AlertDialog.Builder(it) }
        val inflater = layoutInflater
        builder?.setTitle("With EditText")
        val dialogLayout = inflater.inflate(R.layout.alert_dialog_with_edittext, null)
        val editText  = dialogLayout.findViewById<EditText>(R.id.editText)
        builder?.setView(dialogLayout)
        builder?.setPositiveButton("OK") { _, _ ->
//            var item: Item = Item() {
//                Type = com.productivity.gtd.businesslogic
//            }
//            item.Type = ItemType.New
//            item.content = editText.text.toString()
//
//            viewModel.items.value?.add(item)
            }
        builder?.show()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.i("data", viewModel.initialText)
        viewModel.initialText = "It is I, Dio!"

        //Log.i("data", "Size: ${viewModel.items?.value?.inNew?.count()}")

        viewModel.items.observe(viewLifecycleOwner, Observer { items ->
            Log.i("data", "Size now: ${items.size}")
        })
    }

    override fun onDestroyView() {
        Log.i("data", "Destroyed")
        super.onDestroyView()

//        val fileOutputStream : FileOutputStream?
//        try {
//            fileOutputStream = activity?.openFileOutput(fileName, Context.MODE_PRIVATE)
//            fileOutputStream?.write("We destroyed it!".toByteArray())
//        } catch (e: Exception) {
//            e.printStackTrace()
//        }
    }
}