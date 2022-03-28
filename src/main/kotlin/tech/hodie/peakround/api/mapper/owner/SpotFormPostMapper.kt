package tech.hodie.peakround.api.mapper.owner

import org.springframework.stereotype.Component
import tech.hodie.peakround.api.dto.owner.SpotPostForm
import tech.hodie.peakround.api.mapper.Mapper
import tech.hodie.peakround.api.model.place.Spot
import tech.hodie.peakround.api.service.OwnerService
import java.time.Instant
import java.util.*

@Component
class SpotFormPostMapper(private val ownerService: OwnerService) : Mapper<SpotPostForm, Spot> {
    override fun map(t: SpotPostForm): Spot {
        val owner = ownerService.owner(t.ownerId)
        val spotId = UUID.randomUUID().toString()
        val createdTime = Instant.now().toEpochMilli()
        return Spot(null, spotId, createdTime, createdTime, t.name, owner, t.icon, t.source, t.tags)
    }

}