package tech.hodie.peakround.api.model.place

import tech.hodie.peakround.api.model.user.User
import java.sql.Timestamp

data class Place(
    val id: Long?,
    val placeId: String,
    val createdAt: Long,
    val updatedAt: Long,
    val name: String,
    val owner: User,
    val type: PlaceType,
    val icon: String?,
    val spots: HashMap<String, HashMap<Int, Spot>>? = null,
    val tags: List<String>? = null
)
