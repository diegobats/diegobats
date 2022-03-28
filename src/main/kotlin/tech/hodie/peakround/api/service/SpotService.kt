package tech.hodie.peakround.api.service

import org.springframework.stereotype.Service
import tech.hodie.peakround.api.dto.owner.SpotPatchForm
import tech.hodie.peakround.api.dto.owner.SpotPostForm
import tech.hodie.peakround.api.dto.owner.SpotView
import tech.hodie.peakround.api.mapper.owner.SpotFormPostMapper
import tech.hodie.peakround.api.mapper.owner.SpotViewMapper
import tech.hodie.peakround.api.model.place.Spot
import tech.hodie.peakround.api.model.user.Owner
import java.time.Instant
import java.util.*
import kotlin.streams.toList

@Service
class SpotService(private val spotFormPostMapper: SpotFormPostMapper, private val spotViewMapper: SpotViewMapper) {

    val userId = UUID.randomUUID().toString()

    val spots = arrayListOf<Spot>()

    fun all(): List<SpotView> {
        return spots.stream().map { spot -> spotViewMapper.map(spot) }.toList()
    }

    fun get(spotId: String): SpotView {
        val spot = spots.stream().filter { t -> t.spotId == spotId }.findFirst().get()
        return spotViewMapper.map(spot)
    }

    fun spot(spotId: String): Spot {
        return spots.stream().filter { t -> t.spotId == spotId }.findFirst().get()
    }

    fun update(form: SpotPatchForm): SpotView? {
        val oldSpot = spots.stream().filter { t -> t.spotId == form.id }.findFirst().get()
        val newSpot = Spot(
            oldSpot.id,
            oldSpot.spotId,
            oldSpot.createdAt,
            Instant.now().toEpochMilli(),
            form.name ?: oldSpot.name,
            oldSpot.owner,
            form.icon ?: oldSpot.icon,
            form.source ?: oldSpot.source,
            form.tags ?: oldSpot.tags
        )
        spots.remove(oldSpot)
        spots.add(newSpot)
        return spotViewMapper.map(newSpot)
    }

    fun create(form: SpotPostForm): SpotView {
        val spot = spotFormPostMapper.map(form)
        spots.add(spot)
        return (get(spot.spotId))
    }


}
