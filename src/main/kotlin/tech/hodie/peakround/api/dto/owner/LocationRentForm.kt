package tech.hodie.peakround.api.dto.owner

import java.time.LocalDateTime
import javax.validation.constraints.NotEmpty

data class LocationRentForm(
    @field:NotEmpty val rentId: String,
    @field:NotEmpty val ownerId: String,
    @field:NotEmpty val spotId: String,
    @field:NotEmpty val start: LocalDateTime,
    @field:NotEmpty val end: LocalDateTime,
    @field:NotEmpty val latitude: Double,
    @field:NotEmpty val longitude: Double
)
