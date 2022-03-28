package tech.hodie.peakround.api.service

import org.springframework.stereotype.Service
import tech.hodie.peakround.api.dto.owner.OwnerPatchForm
import tech.hodie.peakround.api.dto.owner.OwnerPostForm
import tech.hodie.peakround.api.dto.owner.OwnerView
import tech.hodie.peakround.api.mapper.owner.OwnerFormPostMapper
import tech.hodie.peakround.api.mapper.owner.OwnerViewMapper
import tech.hodie.peakround.api.model.user.Owner
import java.time.Instant

@Service
class OwnerService(private val ownerFormPostMapper: OwnerFormPostMapper, private val ownerViewMapper: OwnerViewMapper) {

    val owners = arrayListOf<Owner>()

    fun get(id: String): OwnerView {
        val user = owners.stream().filter { t -> t.userId == id }.findFirst().get()
        return (ownerViewMapper.map(user))
    }

    fun owner(id: String): Owner {
        val user = owners.stream().filter { t -> t.userId == id }.findFirst().get()
        return (user)
    }

    fun update(form: OwnerPatchForm): OwnerView? {
        val oldUser = owners.stream().filter { t -> t.userId == form.id }.findFirst().get()
        val newUser = Owner(
            oldUser.id,
            oldUser.userId,
            oldUser.createdAt,
            Instant.now().toEpochMilli(),
            form.name ?: oldUser.name,
            form.documentId ?: oldUser.documentId,
            form.contact ?: oldUser.contact,
            form.address ?: oldUser.address,
            form.phone ?: oldUser.phone,
            form.email ?: oldUser.email,
            form.social ?: oldUser.social
        )
        owners.remove(oldUser)
        owners.add(newUser)
        return ownerViewMapper.map(newUser)
    }

    fun create(form: OwnerPostForm): OwnerView {
        val user = ownerFormPostMapper.map(form)
        owners.add(user)
        return (get(user.userId))
    }

}
