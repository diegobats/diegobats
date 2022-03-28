package tech.hodie.peakround.api.dto.owner

import javax.validation.constraints.NotEmpty

data class SpotPostForm(
    @field:NotEmpty val ownerId: String,
    @field:NotEmpty val name: String,
    @field:NotEmpty val icon: String,
    @field:NotEmpty val source: String,
    val tags: List<String>? = null
)


