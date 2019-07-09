package team449.frc.scoutingappbase

import androidx.databinding.BaseObservable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TestViewModel : ViewModel(){
    val name: MutableLiveData<String> by lazy {
        MutableLiveData<String>().apply { value = "name" }
    }
}
