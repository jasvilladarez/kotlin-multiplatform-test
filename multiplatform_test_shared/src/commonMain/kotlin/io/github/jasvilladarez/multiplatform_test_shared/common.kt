package io.github.jasvilladarez.multiplatform_test_shared

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.get
import io.ktor.client.request.url
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.serialization.json.JSON

internal expect val ApplicationDispatcher: CoroutineDispatcher

class ElloApi {

    private val client by lazy {
        HttpClient {
            install(JsonFeature) {
                serializer = KotlinxSerializer(JSON.nonstrict).apply {
                    setMapper(TokenResponse::class, TokenResponse.serializer())
                    setMapper(Token::class, Token.serializer())
                }
            }
        }
    }

    fun getPublicToken(callback: (Token) -> Unit) {
        GlobalScope.apply {
            launch(ApplicationDispatcher) {
                val result = client.get<TokenResponse> {
                    url("https://ello.co/api/webapp-token")
                }
                callback(result.token)
            }
        }
    }
}