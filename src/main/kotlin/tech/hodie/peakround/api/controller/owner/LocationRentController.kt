package tech.hodie.peakround.api.controller.costumer

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import tech.hodie.peakround.api.dto.owner.LocationRentForm
import tech.hodie.peakround.api.dto.owner.LocationRentView
import tech.hodie.peakround.api.service.LocationRentService
import javax.validation.Valid


@RestController
@RequestMapping("/locationRent")
class LocationRentController(private val service: LocationRentService) {

    @GetMapping()
    fun list(): List<LocationRentView> {
        return service.all()
    }

    @GetMapping("/{rentId}")
    fun get(@PathVariable rentId: String): LocationRentView {
        return service.get(rentId)
    }

    @PatchMapping
    fun patch(@RequestBody @Valid form: LocationRentForm): ResponseEntity<LocationRentView> {
        val data = service.update(form)
        return ResponseEntity.ok(data)
    }

    @PostMapping
    fun post(
        @RequestBody @Valid form: LocationRentForm,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<LocationRentView> {
        val view: LocationRentView = service.create(form)
        val uri = uriBuilder.path("/rent/${view.rentId}").build().toUri()
        return ResponseEntity.created(uri).body(view)
    }
}