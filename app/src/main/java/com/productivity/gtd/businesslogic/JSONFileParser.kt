package com.productivity.gtd.businesslogic

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.productivity.gtd.models.Items
import com.productivity.gtd.models.Project
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class JSONFileParser(private val context: Context) {

    fun parseFile(): List<Items> {

        try {
            val inputStream = context.openFileInput("demo.txt")

            if (inputStream != null) {
                val inputStreamReader = InputStreamReader(inputStream)
                val bufferedReader = BufferedReader(inputStreamReader)

                var stringBuilder = StringBuilder()
                bufferedReader.let { stringBuilder.append(it.readLine()) }
                inputStream.close()

                //return gson.fromJson(stringBuilder.toString(), itemsType)
            }

        } catch (e: Exception) {
            Log.e("data", "Error happened ${e.printStackTrace()}")
            e.printStackTrace()
        }
        return mutableListOf()
    }

    fun updateFile(items: List<Project>) {
        Log.i("data", "Update file called")

        val jsonString = ""

        Log.i("data", "Json String: $jsonString")

        val outputStreamWriter = OutputStreamWriter(context.openFileOutput("demo.txt", Context.MODE_PRIVATE))
        outputStreamWriter.write(jsonString)
        outputStreamWriter.close()

    }
}