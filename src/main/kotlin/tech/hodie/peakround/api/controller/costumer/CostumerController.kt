package tech.hodie.peakround.api.controller.costumer

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import tech.hodie.peakround.api.dto.costumer.CostumerPatchForm
import tech.hodie.peakround.api.dto.costumer.CostumerPostForm
import tech.hodie.peakround.api.dto.costumer.CostumerView
import tech.hodie.peakround.api.service.CostumerService
import javax.validation.Valid


@RestController
@RequestMapping("/costumer")
class CostumerController(private val service: CostumerService) {

    @GetMapping("/{userId}")
    fun get(@PathVariable userId:String): CostumerView {
        return service.get(userId)
    }

    @PatchMapping
    fun patch(@RequestBody @Valid form: CostumerPatchForm): ResponseEntity<CostumerView> {
        val data = service.update(form)
        return ResponseEntity.ok(data)
    }

    @PostMapping
    fun post(
        @RequestBody @Valid costumerForm: CostumerPostForm,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<CostumerView> {
        val costumerView: CostumerView = service.create(costumerForm)
        val uri = uriBuilder.path("/costumer/${costumerView.id}").build().toUri()
        return ResponseEntity.created(uri).body(costumerView)
    }
}