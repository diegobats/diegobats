package tech.hodie.peakround.api.dto.client

import javax.validation.constraints.NotEmpty

data class LocationForm(
    @field:NotEmpty
    val id: String,
    val latitude: Double,
    val longitude: Double,
    val radius: Int = 5,
    val max: Int = 100
)