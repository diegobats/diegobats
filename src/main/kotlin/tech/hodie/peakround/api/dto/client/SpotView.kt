package tech.hodie.peakround.api.dto.client


data class SpotView (
    val name: String,
    val icon: String,
    val source: String,
    val tags: List<String>? = null,
)
