package tech.hodie.peakround.api.controller.owner

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import tech.hodie.peakround.api.dto.owner.OwnerPatchForm
import tech.hodie.peakround.api.dto.owner.OwnerPostForm
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
    fun patch(@RequestBody @Valid form: OwnerPatchForm): ResponseEntity<OwnerView> {
        val data = service.update(form)
        return ResponseEntity.ok(data)
    }

    @PostMapping
    fun post(
        @RequestBody @Valid ownerPostForm: OwnerPostForm,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<OwnerView> {
        val ownerView: OwnerView = service.create(ownerPostForm)
        val uri = uriBuilder.path("/owner/${ownerView.userId}").build().toUri()
        return ResponseEntity.created(uri).body(ownerView)
    }
}