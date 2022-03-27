package tech.hodie.peakround.api.dto.client

import javax.validation.constraints.NotEmpty

data class CostumerForm(
    @field:NotEmpty
    val id: String,
    val name: String? = null,
    val nickName: String? = null,
    val age: Short? = null,
    val groupType: List<String>? = null,
    val preferences: List<String>? = null
)
