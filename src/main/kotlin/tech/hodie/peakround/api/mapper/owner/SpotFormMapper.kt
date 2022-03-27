package tech.hodie.peakround.api.mapper.owner

import org.springframework.stereotype.Component
import tech.hodie.peakround.api.dto.owner.SpotForm
import tech.hodie.peakround.api.mapper.Mapper
import tech.hodie.peakround.api.model.place.Spot
import tech.hodie.peakround.api.model.user.Owner

@Component
class SpotFormMapper: Mapper<SpotForm, Spot> {
    override fun map(t: SpotForm): Spot {
        val owner = currentOwner()
        return Spot(t.id, t.name, owner, t.icon, t.source, t.tags)
    }

    fun currentOwner(): Owner{
        val mockOwner = Owner(
            0,
            "user0",
            "mockUser",
            "MockDocumentId",
            "MockContact",
            "MockAddress",
            "MockPhone",
            "MockEmail",
            hashMapOf( "facebook" to "userXYZ")
        )
        return mockOwner
    }
}