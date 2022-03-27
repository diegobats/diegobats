package tech.hodie.peakround.api.model.users

data class Owner(
    override val id: Long?,
    override val userId: String,
    override val name: String,
    val ownerUserId: String,
    val documentId: String,
    val contact: String?,
    val address: String,
    val phone: String,
    val email: String,
    val social: HashMap<String, String>? = null
): User
