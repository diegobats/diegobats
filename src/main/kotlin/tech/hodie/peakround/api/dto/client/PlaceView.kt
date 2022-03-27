package tech.hodie.peakround.api.dto.client

import tech.hodie.peakround.api.model.users.Owner

data class PlaceView(
    val name: String,
    val icon: String?,
    val spots: HashMap<String, HashMap<Int, SpotView>>? = null,
    val tags: List<String>? = null
)
