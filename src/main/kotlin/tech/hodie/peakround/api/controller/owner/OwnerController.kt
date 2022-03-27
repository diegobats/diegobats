package tech.hodie.peakround.api.controller.owner

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import tech.hodie.peakround.api.dto.owner.OwnerForm
import tech.hodie.peakround.api.dto.owner.OwnerView
import tech.hodie.peakround.api.service.OwnerService
import javax.validation.Valid


@RestController
@RequestMapping("/owner")
class OwnerController(private val service: OwnerService) {

    @GetMapping("/{id}")
    fun get(@PathVariable id: String): OwnerView {
        return service.get(id)
    }

    @PatchMapping
    fun patch(@RequestBody @Valid ownerForm: OwnerForm): ResponseEntity<OwnerView> {
        val data = service.update(ownerForm)
        return ResponseEntity.ok(data)
    }

    @PostMapping
    fun post(
        @RequestBody @Valid ownerForm: OwnerForm,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<OwnerView> {
        val ownerView: OwnerView = service.create(ownerForm)
        val uri = uriBuilder.path("/owner/${ownerView.userId}").build().toUri()
        return ResponseEntity.created(uri).body(ownerView)
    }
}