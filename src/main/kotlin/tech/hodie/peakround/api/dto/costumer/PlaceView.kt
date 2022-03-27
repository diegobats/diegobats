package tech.hodie.peakround.api.dto.costumer

data class PlaceView(
    val name: String,
    val icon: String?,
    val spots: HashMap<String, HashMap<Int, SpotView>>? = null,
    val tags: List<String>? = null
)
