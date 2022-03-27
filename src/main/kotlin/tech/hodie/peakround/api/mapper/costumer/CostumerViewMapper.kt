package tech.hodie.peakround.api.mapper.costumer

import org.springframework.stereotype.Component
import tech.hodie.peakround.api.dto.costumer.CostumerView
import tech.hodie.peakround.api.mapper.Mapper
import tech.hodie.peakround.api.model.user.Costumer

@Component
class CostumerViewMapper: Mapper<Costumer, CostumerView> {
    override fun map(t: Costumer): CostumerView {
        return CostumerView(
            t.userId,
            t.name,
            t.nickName,
            t.age,
            t.groupType,
            t.preferences
        )
    }

}