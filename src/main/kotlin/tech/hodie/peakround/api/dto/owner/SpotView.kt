package tech.hodie.peakround.api.dto.owner


data class SpotView (
    val id: Long?,
    val name: String,
    val owner: OwnerView,
    val icon: String,
    val source: String,
    val tags: List<String>? = null,
)
