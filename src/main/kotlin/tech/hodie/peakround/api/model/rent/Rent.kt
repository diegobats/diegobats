package tech.hodie.peakround.api.model.rent

import tech.hodie.peakround.api.model.user.Owner
import java.sql.Timestamp
import java.time.LocalDateTime

sealed interface Rent{
    var id: Long?
    val rentId: String
    val createdAt: Long
    val updatedAt: Long
    val status: RentStatus
    val owner: Owner
    val start: LocalDateTime
    val end: LocalDateTime

}