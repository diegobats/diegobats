package tech.hodie.peakround.api.mapper.owner

import org.springframework.stereotype.Component
import tech.hodie.peakround.api.dto.owner.OwnerPostForm
import tech.hodie.peakround.api.mapper.Mapper
import tech.hodie.peakround.api.model.user.Owner
import java.time.Instant
import java.util.*

@Component
class OwnerFormPostMapper() : Mapper<OwnerPostForm, Owner> {

    override fun map(t: OwnerPostForm): Owner {
        val userId = UUID.randomUUID().toString()
        val createdAt = Instant.now().toEpochMilli()
        return Owner(
            null,
            userId,
            createdAt,
            createdAt,
            t.name,
            t.documentId,
            t.contact,
            t.address,
            t.phone,
            t.email,
            t.social
        )
    }
}