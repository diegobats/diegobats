package tech.hodie.peakround.api.model.place

import tech.hodie.peakround.api.model.user.Owner

data class Spot(
    val id: Long?,
    val name: String,
    val owner: Owner,
    val icon: String,
    val source: String,
    val tags: List<String>? = null,
)