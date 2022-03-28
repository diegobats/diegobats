package tech.hodie.peakround.api.mapper.costumer

import org.springframework.stereotype.Component
import tech.hodie.peakround.api.dto.costumer.CostumerPostForm
import tech.hodie.peakround.api.mapper.Mapper
import tech.hodie.peakround.api.model.user.Costumer
import java.time.Instant
import java.util.*

@Component
class CostumerPostFormMapper: Mapper<CostumerPostForm, Costumer> {
    override fun map(t: CostumerPostForm): Costumer {
        val userId = UUID.randomUUID().toString()
        val createdTime = Instant.now().toEpochMilli()
        return Costumer(
            id = null,
            userId,
            createdTime,
            createdTime,
            t.name,
            t.nickName,
            t.age,
            t.groupType,
            t.preferences
        )

    }
}