package tech.hodie.peakround.api.mapper

import org.springframework.stereotype.Component
import tech.hodie.peakround.api.dto.client.CostumerView
import tech.hodie.peakround.api.model.users.Costumer

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