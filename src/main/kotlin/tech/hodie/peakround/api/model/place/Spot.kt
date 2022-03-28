package tech.hodie.peakround.api.model.place

import tech.hodie.peakround.api.model.user.Owner
import java.sql.Timestamp

data class Spot(
    var id: Long?,
    val spotId: String,
    val createdAt: Long,
    val updatedAt: Long,
    val name: String,
    val owner: Owner,
    val icon: String,
    val source: String,
    val tags: List<String>? = null,
)