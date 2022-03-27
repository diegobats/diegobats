package tech.hodie.peakround.api.mapper.costumer

import org.springframework.stereotype.Component
import tech.hodie.peakround.api.dto.costumer.CostumerForm
import tech.hodie.peakround.api.mapper.Mapper
import tech.hodie.peakround.api.model.user.Costumer

@Component
class CostumerFormMapper: Mapper<CostumerForm, Costumer> {
    override fun map(t: CostumerForm): Costumer {
        return Costumer(
            id = null,
            t.id,
            t.name,
            t.nickName,
            t.age,
            t.groupType,
            t.preferences
        )

    }
}