package tech.hodie.peakround.api.model.user

sealed interface User{
    val id: Long?
    val userId: String
    val name: String?
}