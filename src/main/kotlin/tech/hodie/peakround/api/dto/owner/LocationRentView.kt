package tech.hodie.peakround.api.dto.owner

import java.time.LocalDateTime

data class LocationRentView(
    val rentId: String,
    val ownerId: String,
    val spotId: String,
    val start: LocalDateTime,
    val end: LocalDateTime,
    val latitude: Double,
    val longitude: Double
)
