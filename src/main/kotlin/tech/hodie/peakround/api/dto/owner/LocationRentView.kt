package tech.hodie.peakround.api.dto.owner

import tech.hodie.peakround.api.model.rent.RentStatus
import java.time.LocalDateTime

data class LocationRentView(
    val rentId: String,
    val spot: SpotView,
    val status: RentStatus,
    val start: LocalDateTime,
    val end: LocalDateTime,
    val latitude: Double,
    val longitude: Double
)
