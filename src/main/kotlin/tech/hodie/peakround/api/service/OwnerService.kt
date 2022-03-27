package tech.hodie.peakround.api.service

import org.springframework.stereotype.Service
import tech.hodie.peakround.api.dto.owner.OwnerForm
import tech.hodie.peakround.api.dto.owner.OwnerView
import tech.hodie.peakround.api.mapper.owner.OwnerFormMapper
import tech.hodie.peakround.api.mapper.owner.OwnerViewMapper
import tech.hodie.peakround.api.model.user.Costumer
import tech.hodie.peakround.api.model.user.Owner

@Service
class OwnerService(private val ownerFormMapper: OwnerFormMapper,private val ownerViewMapper: OwnerViewMapper) {

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

    val owners = arrayListOf(mockOwner)

    fun get(id: String): OwnerView {
        val user = owners.stream().filter { t -> t.userId == id }.findFirst().get()
        return (ownerViewMapper.map(user))
    }

    fun update(ownerForm: OwnerForm): OwnerView? {
        val oldUser = owners.stream().filter { t -> t.userId == ownerForm.userId}.findFirst().get()
        var newUser = ownerFormMapper.map(ownerForm)
        newUser.id = oldUser.id
        owners.remove(oldUser)
        owners.add(newUser)
        return ownerViewMapper.map(newUser)
    }

    fun create(ownerForm: OwnerForm): OwnerView {
        var user = ownerFormMapper.map(ownerForm)
        user.id = owners.size.toLong()
        owners.add(user)
        return (get(user.userId))
    }

}
