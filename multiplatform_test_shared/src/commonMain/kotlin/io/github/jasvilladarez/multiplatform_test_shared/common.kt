package io.github.jasvilladarez.multiplatform_test_shared

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.url
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

internal expect val ApplicationDispatcher: CoroutineDispatcher

class ElloApi {

    private val client by lazy { HttpClient() }

    fun getPublicToken(callback: (String) -> Unit) {
        GlobalScope.apply {
            launch(ApplicationDispatcher) {
                val result = client.get<String> {
                    url("https://ello.co/api/webapp-token")
                }
                callback(result)
            }
        }
    }
}