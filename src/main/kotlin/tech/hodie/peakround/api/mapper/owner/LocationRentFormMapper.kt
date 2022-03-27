package tech.hodie.peakround.api.mapper.owner

import org.springframework.stereotype.Component
import tech.hodie.peakround.api.dto.owner.LocationRentForm
import tech.hodie.peakround.api.mapper.Mapper
import tech.hodie.peakround.api.model.rent.LocationRent

@Component
class LocationRentFormMapper(): Mapper<LocationRentForm, LocationRent> {
    override fun map(t: LocationRentForm): LocationRent {
        TODO("Not yet implemented")
    }
}