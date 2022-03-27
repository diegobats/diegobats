package tech.hodie.peakround.api.model.rent

import tech.hodie.peakround.api.model.users.Owner
import java.time.LocalDateTime

sealed interface Rent{
    val id: Long?
    val status: RentStatus
    val owner: Owner
    val start: LocalDateTime
    val end: LocalDateTime

}