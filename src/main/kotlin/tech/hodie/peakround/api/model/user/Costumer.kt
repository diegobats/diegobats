package tech.hodie.peakround.api.model.user

data class Costumer(
    override var id: Long?,
    override val userId: String,
    override val name: String?,
    val nickName: String?,
    val age: Short?,
    val groupType: List<String>?,
    val preferences: List<String>?
) : User
