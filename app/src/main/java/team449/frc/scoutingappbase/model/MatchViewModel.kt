package team449.frc.scoutingappbase.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

fun <T: Any?> mutableLiveData(initialValue: T) = MutableLiveData<T>().apply { postValue(initialValue) }

class MatchViewModel : ViewModel(){
    val scoutName by lazy { mutableLiveData("") }
    val teamId by lazy { mutableLiveData(0) }
    val matchId by lazy { mutableLiveData(0) }
    val alliance by lazy { mutableLiveData(0) }
    val noShow by lazy { mutableLiveData(false) }
    val preload by lazy { mutableLiveData(-1) }
    val autoMove by lazy { mutableLiveData(false) }
    val placedAThing by lazy { mutableLiveData(false) }
}
