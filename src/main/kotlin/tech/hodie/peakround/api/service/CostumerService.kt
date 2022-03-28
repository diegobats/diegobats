package tech.hodie.peakround.api.service

import org.springframework.stereotype.Service
import tech.hodie.peakround.api.dto.costumer.CostumerPatchForm
import tech.hodie.peakround.api.dto.costumer.CostumerPostForm
import tech.hodie.peakround.api.dto.costumer.CostumerView
import tech.hodie.peakround.api.mapper.costumer.CostumerPostFormMapper
import tech.hodie.peakround.api.mapper.costumer.CostumerViewMapper
import tech.hodie.peakround.api.model.user.Costumer
import java.time.Instant

@Service
class CostumerService(
    private val costumerPostFormMapper: CostumerPostFormMapper,
    private val costumerViewMapper: CostumerViewMapper
) {

    val costumers = arrayListOf<Costumer>()

    fun get(userId: String): CostumerView {
        val user = costumers.stream().filter { t -> t.userId == userId }.findFirst().get()
        return (costumerViewMapper.map(user))
    }

    fun costumer(id: String): Costumer {
        return (costumers.stream().filter { t -> t.userId == id }.findFirst().get())
    }

    fun update(form: CostumerPatchForm): CostumerView {
        val oldUser = costumers.stream().filter { t -> t.userId == form.id }.findFirst().get()
        val newUser = Costumer(
            oldUser.id,
            oldUser.userId,
            oldUser.createdAt,
            Instant.now().toEpochMilli(),
            form.name ?: oldUser.name,
            form.nickName ?: oldUser.nickName,
            form.age ?: oldUser.age,
            form.groupType ?: oldUser.groupType,
            form.preferences ?: oldUser.preferences,

            )
        costumers.remove(oldUser)
        costumers.add(newUser)
        return costumerViewMapper.map(newUser)
    }

    fun create(costumerForm: CostumerPostForm): CostumerView {
        val user = costumerPostFormMapper.map(costumerForm)
        user.id = costumers.size.toLong()
        costumers.add(user)
        return (get(user.userId))
    }

}
