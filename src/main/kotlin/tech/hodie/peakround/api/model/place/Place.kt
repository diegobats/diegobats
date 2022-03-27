package tech.hodie.peakround.api.model.products

import tech.hodie.peakround.api.model.users.Costumer
import tech.hodie.peakround.api.model.users.User

data class Place(
    val id: Long?,
    val name: String,
    val owner: User,
    val type: PlaceType,
    val icon: String?,
    val spots: HashMap<String, HashMap<Int, Spot>>? = null,
    val tags: List<String>? = null
)
