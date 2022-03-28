package tech.hodie.peakround.api.mapper.owner

import org.springframework.stereotype.Component
import tech.hodie.peakround.api.dto.owner.LocationRentForm
import tech.hodie.peakround.api.mapper.Mapper
import tech.hodie.peakround.api.model.rent.LocationRent
import tech.hodie.peakround.api.model.user.Owner
import tech.hodie.peakround.api.service.SpotService
import java.time.Instant

@Component
class LocationRentFormMapper(private val spotService: SpotService) : Mapper<LocationRentForm, LocationRent> {
    override fun map(t: LocationRentForm): LocationRent {
        val owner = currentOwner()
        val spot = spotService.spot(t.spotId)
        val createdAt = Instant.now().toEpochMilli()
        return LocationRent(null, t.rentId, createdAt,createdAt, owner, t.status, t.start, t.end, spot, t.latitude, t.longitude)
    }

    fun currentOwner(): Owner {
        val mockOwner = Owner(
            0,
            "user0",
            Instant.now().toEpochMilli(),
            Instant.now().toEpochMilli(),
            "mockUser",
            "MockDocumentId",
            "MockContact",
            "MockAddress",
            "MockPhone",
            "MockEmail",
            hashMapOf("facebook" to "userXYZ")
        )
        return mockOwner
    }
}