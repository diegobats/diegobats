package tech.hodie.peakround.api.service

import org.springframework.stereotype.Service
import tech.hodie.peakround.api.dto.owner.SpotForm
import tech.hodie.peakround.api.dto.owner.SpotView
import tech.hodie.peakround.api.mapper.owner.SpotFormMapper
import tech.hodie.peakround.api.mapper.owner.SpotViewMapper
import tech.hodie.peakround.api.model.place.Spot
import tech.hodie.peakround.api.model.user.Owner
import java.time.Instant
import java.util.*
import kotlin.streams.toList

@Service
class SpotService(private val spotFormMapper: SpotFormMapper, private val spotViewMapper: SpotViewMapper) {

    val userId = UUID.randomUUID().toString()
    val createdTime = Instant.now().toEpochMilli()

    val mockOwner = Owner(
        0,
        userId,
        createdTime,
        createdTime,
        "mockUser",
        "MockDocumentId",
        "MockContact",
        "MockAddress",
        "MockPhone",
        "MockEmail",
        hashMapOf("userXYZ" to "facebook")
    )

    val mockSpot = Spot(
        0,
        userId,
        createdTime,
        createdTime,
        "mockName",
        mockOwner,
        "iconMock",
        "sourceMock"

    )

    val spots = arrayListOf(mockSpot)

    fun all(): List<SpotView> {
        return spots.stream().map { spot -> spotViewMapper.map(spot) } .toList()
    }

    fun get(spotId: Long): SpotView {
        val spot = spots.stream().filter { t -> t.id == spotId }.findFirst().get()
        return spotViewMapper.map(spot)
    }

    fun update(form: SpotForm): SpotView? {
        val oldSpot = spots.stream().filter { (id) -> id == form.id }.findFirst().get()
        var newSpot = spotFormMapper.map(form)
        newSpot.id = oldSpot.id
        spots.remove(oldSpot)
        spots.add(newSpot)
        return spotViewMapper.map(newSpot)
    }

    fun create(form: SpotForm): SpotView {
        var spot = spotFormMapper.map(form)
        spot.id = spots.size.toLong()
        spots.add(spot)
        return (get(spot.id!!))
    }

    fun spot(spotId: Long): Spot {
        return spots.stream().filter { t -> t.id == spotId }.findFirst().get()
    }

}
