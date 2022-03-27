package tech.hodie.peakround.api.controller.user

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import tech.hodie.peakround.api.dto.client.CostumerForm
import tech.hodie.peakround.api.dto.client.CostumerView
import tech.hodie.peakround.api.service.CostumerService
import javax.validation.Valid


@RestController
@RequestMapping("/user")
class UserController(private val service: CostumerService) {

    @GetMapping("/{id}")
    fun get(@PathVariable id: String): CostumerView {
        return service.get(id)
    }

    @PatchMapping
    fun patch(@RequestBody @Valid costumerForm: CostumerForm): ResponseEntity<CostumerView> {
        val data = service.update(costumerForm)
        return ResponseEntity.ok(data)
    }

    @PostMapping
    fun post(
        @RequestBody @Valid costumerForm: CostumerForm,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<CostumerView> {
        val costumerView: CostumerView = service.create(costumerForm)
        val uri = uriBuilder.path("/user/${costumerView.id}").build().toUri()
        return ResponseEntity.created(uri).body(costumerView)
    }
}