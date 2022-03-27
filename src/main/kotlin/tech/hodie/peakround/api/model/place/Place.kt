package tech.hodie.peakround.api.model.place

import tech.hodie.peakround.api.model.user.User

data class Place(
    val id: Long?,
    val name: String,
    val owner: User,
    val type: PlaceType,
    val icon: String?,
    val spots: HashMap<String, HashMap<Int, Spot>>? = null,
    val tags: List<String>? = null
)
