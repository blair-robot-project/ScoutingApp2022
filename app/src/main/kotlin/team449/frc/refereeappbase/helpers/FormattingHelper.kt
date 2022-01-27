package team449.frc.refereeappbase.helpers

import androidx.lifecycle.MutableLiveData

object FormattingHelper {
    /**
     * Pad a hub score left with zeroes to length 2
     */
    @JvmStatic
    fun padZeroes(i: MutableLiveData<Int>): String = (i.value ?: 0).toString().padStart(2, '0')
}