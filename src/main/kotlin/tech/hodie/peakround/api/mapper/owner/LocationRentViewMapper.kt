package tech.hodie.peakround.api.mapper.owner

import org.springframework.stereotype.Component
import tech.hodie.peakround.api.dto.owner.LocationRentForm
import tech.hodie.peakround.api.dto.owner.LocationRentView
import tech.hodie.peakround.api.dto.owner.SpotView
import tech.hodie.peakround.api.mapper.Mapper
import tech.hodie.peakround.api.model.rent.LocationRent

@Component
class LocationRentViewMapper(private val spotViewMapper: SpotViewMapper): Mapper<LocationRent, LocationRentView> {
    override fun map(t: LocationRent): LocationRentView {
        val spotView: SpotView = spotViewMapper.map(t.spot)
        return LocationRentView(t.rentId, spotView,t.status, t.start, t.end, t.latitude, t.longitude)
    }
}