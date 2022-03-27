package tech.hodie.peakround.api.model.rent

import tech.hodie.peakround.api.model.place.Spot
import tech.hodie.peakround.api.model.user.Owner
import java.time.LocalDateTime

data class LocationRent(
    override var id: Long?,
    override val rentId: String,
    override val owner: Owner,
    override val status: RentStatus,
    override val start: LocalDateTime,
    override val end: LocalDateTime,
    val spot: Spot,
    val latitude: Double,
    val longitude: Double
) :Rent
