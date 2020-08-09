package cn.jinyulei.mybaby.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val phone = MutableLiveData<String>()

    init {
        phone.value = "12345"
    }
}