package tech.hodie.peakround.api.mapper.owner

import org.springframework.stereotype.Component
import tech.hodie.peakround.api.dto.owner.LocationRentForm
import tech.hodie.peakround.api.dto.owner.OwnerView
import tech.hodie.peakround.api.mapper.Mapper
import tech.hodie.peakround.api.model.rent.LocationRent
import tech.hodie.peakround.api.model.user.Owner

@Component
class OwnerViewMapper(): Mapper<Owner, OwnerView> {
    override fun map(t: Owner): OwnerView {
        return OwnerView(t.userId,t.name,t.documentId, t.contact, t.address, t.phone, t.email, t.social)
    }
}