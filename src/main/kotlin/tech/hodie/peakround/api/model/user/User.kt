package tech.hodie.peakround.api.model.user

import java.sql.Timestamp

sealed interface User{
    val id: Long?
    val userId: String
    val name: String?
    val createdAt: Long
    val updatedAt: Long
}