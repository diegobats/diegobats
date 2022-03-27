package tech.hodie.peakround.api.service

import org.springframework.stereotype.Service
import tech.hodie.peakround.api.dto.costumer.CostumerForm
import tech.hodie.peakround.api.dto.costumer.CostumerView
import tech.hodie.peakround.api.mapper.costumer.CostumerFormMapper
import tech.hodie.peakround.api.mapper.costumer.CostumerViewMapper
import tech.hodie.peakround.api.model.user.Costumer

@Service
class CostumerService(private val costumerFormMapper: CostumerFormMapper, private val costumerViewMapper: CostumerViewMapper) {


    val mockCostumer = Costumer(
        0,
        "user12345",
        "mockUser",
        "Doidao",
        25,
        listOf("geek", "news"),
        listOf("tech", "sports")
    )

    val costumers = arrayListOf(mockCostumer)

    fun get(id: String): CostumerView {
        val user = costumers.stream().filter { t -> t.userId == id }.findFirst().get()
        return (costumerViewMapper.map(user))
    }

    fun costumer(id: String): Costumer {
        return (costumers.stream().filter { t -> t.userId == id }.findFirst().get())
    }

    fun update(costumerForm: CostumerForm): CostumerView {
        val oldUser = costumers.stream().filter { t -> t.userId == costumerForm.id }.findFirst().get()
        var newUser = costumerFormMapper.map(costumerForm)
        newUser.id = oldUser.id
        costumers.remove(oldUser)
        costumers.add(newUser)
        return costumerViewMapper.map(newUser)
    }

    fun create(costumerForm: CostumerForm): CostumerView {
        val user = costumerFormMapper.map(costumerForm)
        user.id = costumers.size.toLong()
        costumers.add(user)
        return (get(user.userId))
    }

}
