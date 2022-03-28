package tech.hodie.peakround.api.dto.owner

import javax.validation.constraints.NotEmpty

data class OwnerPatchForm(
    @field:NotEmpty val id: String,
    val name: String? = null,
    val documentId: String? = null,
    val contact: String? = null,
    val address: String? = null,
    val phone: String? = null,
    val email: String? = null,
    val social: HashMap<String, String>? = null

)
