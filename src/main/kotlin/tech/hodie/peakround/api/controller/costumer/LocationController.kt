package tech.hodie.peakround.api.controller.costumer

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import tech.hodie.peakround.api.dto.costumer.LocationForm
import tech.hodie.peakround.api.dto.costumer.PlaceView
import tech.hodie.peakround.api.service.LocationService


@RestController
@RequestMapping("/location")
class LocationController(private val service: LocationService) {
    @GetMapping
    fun get(@RequestBody form: LocationForm): PlaceView {
        return service.location(form)
    }
}
