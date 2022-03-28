package tech.hodie.peakround.api.dto.owner

import javax.validation.constraints.NotEmpty

data class OwnerPostForm(
    @field:NotEmpty val name: String,
    @field:NotEmpty val documentId: String,
    val contact: String?,
    @field:NotEmpty val address: String,
    @field:NotEmpty val phone: String,
    @field:NotEmpty val email: String,
    val social: HashMap<String, String>? = null
)
