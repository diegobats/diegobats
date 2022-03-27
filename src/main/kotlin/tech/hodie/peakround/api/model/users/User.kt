package tech.hodie.peakround.api.model.users

sealed interface User{
    val id: Long?
    val userId: String
    val name: String?
}