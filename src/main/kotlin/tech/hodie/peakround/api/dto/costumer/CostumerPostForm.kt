package tech.hodie.peakround.api.dto.costumer

data class CostumerPostForm(
    val name: String? = null,
    val nickName: String? = null,
    val age: Short? = null,
    val groupType: List<String>? = null,
    val preferences: List<String>? = null
)
