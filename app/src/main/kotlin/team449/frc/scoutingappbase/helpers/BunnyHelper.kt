package team449.frc.scoutingappbase.helpers

import android.view.View
import team449.frc.scoutingappbase.R
import team449.frc.scoutingappbase.model.MatchViewModel


/**
 * The ids of all the four bunnies for each zone
 */
val bunnyIds = listOf(
    R.id.zone1Bunny,
    R.id.zone2Bunny,
    R.id.zone3Bunny,
    R.id.zone4Bunny
)

/**
 * Find the id of the bunny button in the corresponding zone given the zone's quadrant
 */
fun zoneToBunnyId(quadrant: Int) = when (quadrant) {
    1 -> R.id.zone1Bunny
    2 -> R.id.zone2Bunny
    3 -> R.id.zone3Bunny
    4 -> R.id.zone4Bunny
    else -> throw RuntimeException("Quadrant $quadrant was not in range [1, 4]")
}

/**
 * Find the quadrant of the zone a bunny button is in, given that button's id
 */
fun bunnyIdToZone(bunnyId: Int) = when (bunnyId) {
    R.id.zone1Bunny -> 1
    R.id.zone2Bunny -> 2
    R.id.zone3Bunny -> 3
    R.id.zone4Bunny -> 4
    else -> throw RuntimeException("Cannot convert id $bunnyId to quadrant, not a bunny")
}

/**
 * Select a bunny ImageButton and make sure to unselect the previously selected bunny if it exists
 */
fun selectBunny(bunny: View, vm: MatchViewModel) {
    if (!bunny.isSelected) {
        bunny.isSelected = true
        bunny.setBackgroundResource(R.drawable.ic_pink_bunny)
        bunny.invalidate()

        for (bunnyId in bunnyIds) {
            //Ensure that this sibling bunny is deselected
            if (bunnyId != bunny.id)
                unselectBunny((bunny.parent as View).findViewById(bunnyId), vm)
        }
    }
}

/**
 * Unselect a bunny ImageButton
 */
fun unselectBunny(bunny: View, vm: MatchViewModel) {
    if (bunny.isSelected) {
        vm.bunnyZone.value = -1
        bunny.isSelected = false
        bunny.setBackgroundResource(R.drawable.ic_grey_bunny)
        bunny.invalidate()
    }
}

/**
 * Sets the zone in which the bunny is given the ImageButton for the bunny in that zone. If
 * the bunny was already selected, it unselects the bunny and sets `bunnyZone` to -1, otherwise
 * it sets `bunnyZone` to the new zone's value and deselects the previous zone.
 */
fun toggleBunny(bunny: View, vm: MatchViewModel) {
    println("Old bunny value: ${vm.bunnyZone.value}")
    if (!bunny.isSelected) {
        val oldZone = vm.bunnyZone.value
        if (oldZone != null && oldZone != -1) {
            val oldBunny: View =
                (bunny.parent as View).findViewById(zoneToBunnyId(oldZone))
            unselectBunny(oldBunny, vm)
        }
        vm.bunnyZone.value = bunnyIdToZone(bunny.id)
        selectBunny(bunny, vm)
    } else {
        //This bunny was previously selected, so unselect it
        vm.bunnyZone.value = -1
        unselectBunny(bunny, vm)
    }
}
