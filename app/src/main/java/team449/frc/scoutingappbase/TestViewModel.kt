package team449.frc.scoutingappbase

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TestViewModel : ViewModel(){
    val name: MutableLiveData<String> by lazy {
        MutableLiveData<String>().apply { value = "name" }
    }
    val checkbox: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>().apply { value = false }
    }
}
