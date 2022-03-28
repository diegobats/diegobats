package tech.hodie.peakround.api.mapper.owner

import org.springframework.stereotype.Component
import tech.hodie.peakround.api.dto.owner.SpotView
import tech.hodie.peakround.api.mapper.Mapper
import tech.hodie.peakround.api.model.place.Spot

@Component
class SpotViewMapper(private val ownerViewMapper: OwnerViewMapper): Mapper<Spot, SpotView> {
    override fun map(t: Spot): SpotView {
        return SpotView(t.spotId, t.name, t.icon, t.source, t.tags)
    }
}