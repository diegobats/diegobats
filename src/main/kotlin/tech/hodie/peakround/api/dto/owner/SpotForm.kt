package tech.hodie.peakround.api.dto.owner

import tech.hodie.peakround.api.model.user.Owner
import javax.validation.constraints.NotEmpty

data class SpotForm(
    val id: Long?,
    @field:NotEmpty val name: String,
    @field:NotEmpty val icon: String,
    @field:NotEmpty val source: String,
    val tags: List<String>? = null
)


