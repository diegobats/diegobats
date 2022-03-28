package tech.hodie.peakround.api.model.user

import java.sql.Timestamp

data class Costumer(
    override var id: Long?,
    override val userId: String,
    override val createdAt: Long,
    override val updatedAt: Long,
    override val name: String?,
    val nickName: String?,
    val age: Short?,
    val groupType: List<String>?,
    val preferences: List<String>?
) : User
