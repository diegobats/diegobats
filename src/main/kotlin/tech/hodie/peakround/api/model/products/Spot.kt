package tech.hodie.peakround.api.model.products

import tech.hodie.peakround.api.model.users.Owner

data class Spot(
    val id: Long?,
    val name: String,
    val owner: Owner,
    val icon: String,
    val source: String,
    val tags: List<String>? = null,
)