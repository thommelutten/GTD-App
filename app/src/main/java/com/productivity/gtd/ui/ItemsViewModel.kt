package com.productivity.gtd.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.productivity.gtd.models.Items

class ItemsViewModel : ViewModel() {
    var initialText: String = "Hello from the other fragment!"
    var items = MutableLiveData<MutableList<Items>>()
}
