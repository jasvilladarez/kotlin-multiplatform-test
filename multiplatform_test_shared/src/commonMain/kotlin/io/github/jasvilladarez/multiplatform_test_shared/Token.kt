package io.github.jasvilladarez.multiplatform_test_shared

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Token(
    @SerialName("token_type")
    val tokenType: String,
    @SerialName("access_token")
    val accessToken: String
)

@Serializable
internal data class TokenResponse(
    val token: Token
)