package io.github.jasvilladarez.multiplatform_test_shared

expect fun platformName(): String

fun createAppMessage(): String {
    return "Hi this is a test ${platformName()}"
}