package tech.hodie.peakround.api.mapper.costumer

import org.springframework.stereotype.Component
import tech.hodie.peakround.api.dto.costumer.CostumerPatchForm
import tech.hodie.peakround.api.mapper.Mapper
import tech.hodie.peakround.api.model.user.Costumer
import java.time.Instant

@Component
class CostumerPatchFormMapper : Mapper<CostumerPatchForm, Costumer> {
    override fun map(t: CostumerPatchForm): Costumer {
        return Costumer(
            id = null,
            t.id,
            Instant.now().toEpochMilli(),
            Instant.now().toEpochMilli(),
            t.name,
            t.nickName,
            t.age,
            t.groupType,
            t.preferences
        )
    }
}
