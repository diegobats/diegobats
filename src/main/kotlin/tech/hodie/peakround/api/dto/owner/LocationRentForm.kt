package tech.hodie.peakround.api.dto.owner

import tech.hodie.peakround.api.model.rent.RentStatus
import java.time.LocalDateTime
import javax.validation.constraints.NotEmpty

data class LocationRentForm(
    @field:NotEmpty val rentId: String,
    @field:NotEmpty val spotId: Long,
    @field:NotEmpty val status: RentStatus,
    @field:NotEmpty val start: LocalDateTime,
    @field:NotEmpty val end: LocalDateTime,
    @field:NotEmpty val latitude: Double,
    @field:NotEmpty val longitude: Double
)
