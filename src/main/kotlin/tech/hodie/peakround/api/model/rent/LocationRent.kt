package tech.hodie.peakround.api.model.rent

import tech.hodie.peakround.api.model.products.Spot
import tech.hodie.peakround.api.model.users.Owner
import java.time.LocalDateTime

data class LocationRent(
    override val id: Long?,
    override val owner: Owner,
    override val status: RentStatus,
    override val start: LocalDateTime,
    override val end: LocalDateTime,
    val spot: Spot,
    val latitude: Double,
    val longitude: Double
) :Rent
