package tech.hodie.peakround.api.dto.costumer

import javax.validation.constraints.NotEmpty

data class LocationForm(
    @field:NotEmpty val id: String,
    @field:NotEmpty val latitude: Double,
    @field:NotEmpty val longitude: Double,
    val radius: Int = 5,
    val max: Int = 100
)