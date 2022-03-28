package tech.hodie.peakround.api.dto.owner


data class SpotView (
    val id: String,
    val name: String,
    val icon: String,
    val source: String,
    val tags: List<String>? = null,
)
