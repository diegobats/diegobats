package tech.hodie.peakround.api.service

import org.springframework.stereotype.Service
import tech.hodie.peakround.api.dto.owner.LocationRentForm
import tech.hodie.peakround.api.dto.owner.LocationRentView

@Service
class LocationRentService {
    fun all(): List<LocationRentView> {
        TODO("Not yet implemented")
    }

    fun get(rentId: String): LocationRentView {
        println(rentId)
        TODO("Not yet implemented")
    }

    fun update(form: LocationRentForm): LocationRentView? {
        println(form)
        TODO("Not yet implemented")
    }

    fun create(form: LocationRentForm): LocationRentView {
        println(form)
        TODO("Not yet implemented")
    }

}
