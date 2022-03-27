package tech.hodie.peakround.api.controller.owner

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import tech.hodie.peakround.api.dto.owner.SpotForm
import tech.hodie.peakround.api.dto.owner.SpotView
import tech.hodie.peakround.api.service.SpotService
import javax.validation.Valid

@RestController
@RequestMapping("/spot")
class SpotController(private val service: SpotService) {
    
    @GetMapping()
    fun list(): List<SpotView> {
        return service.all()
    }

    @GetMapping("/{spotId}")
    fun get(@PathVariable spotId: Long): SpotView {
        return service.get(spotId)
    }

    @PatchMapping
    fun patch(@RequestBody @Valid form: SpotForm): ResponseEntity<SpotView> {
        val data = service.update(form)
        return ResponseEntity.ok(data)
    }

    @PostMapping
    fun post(
        @RequestBody @Valid form: SpotForm,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<SpotView> {
        val view: SpotView = service.create(form)
        val uri = uriBuilder.path("/spot/${view.id}").build().toUri()
        return ResponseEntity.created(uri).body(view)
    }
}