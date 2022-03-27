package tech.hodie.peakround.api.model.user

data class Owner(
    override var id: Long?,
    override val userId: String,
    override val name: String,
    val documentId: String,
    val contact: String?,
    val address: String,
    val phone: String,
    val email: String,
    val social: HashMap<String, String>? = null
): User
