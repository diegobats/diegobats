package tech.hodie.peakround.api.controller.owner

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/spot")
class SpotController {
    @GetMapping
    fun get(): String {
        return "Return the Spot"
    }
}