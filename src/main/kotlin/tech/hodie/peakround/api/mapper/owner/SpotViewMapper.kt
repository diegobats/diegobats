package tech.hodie.peakround.api.mapper.owner

import org.springframework.stereotype.Component
import tech.hodie.peakround.api.dto.owner.SpotView
import tech.hodie.peakround.api.mapper.Mapper
import tech.hodie.peakround.api.model.place.Spot

@Component
class SpotViewMapper(private val ownerViewMapper: OwnerViewMapper): Mapper<Spot, SpotView> {
    override fun map(t: Spot): SpotView {
        val ownerView = ownerViewMapper.map(t.owner)
        return SpotView(t.id, t.name, ownerView, t.icon, t.source, t.tags)
    }
}