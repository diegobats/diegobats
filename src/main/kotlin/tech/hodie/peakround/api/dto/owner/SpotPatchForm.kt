package tech.hodie.peakround.api.dto.owner

import javax.validation.constraints.NotEmpty

data class SpotPatchForm(
    @field:NotEmpty val id: String,
    val name: String? = null,
    val icon: String? = null,
    val source: String? = null,
    val tags: List<String>? = null
)


