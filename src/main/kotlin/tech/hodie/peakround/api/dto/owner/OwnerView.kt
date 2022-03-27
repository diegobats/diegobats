package tech.hodie.peakround.api.dto.owner

data class OwnerView (
    val userId: String,
    val name: String,
    val documentId: String,
    val contact: String?,
    val address: String,
    val phone: String,
    val email: String,
    val social: HashMap<String, String>? = null
)
