package tech.hodie.peakround.api.dto.costumer

data class CostumerView(
    val id: String,
    val name: String?,
    val nickName: String?,
    val age: Short?,
    val groupType: List<String>?,
    val preferences: List<String>?
)
