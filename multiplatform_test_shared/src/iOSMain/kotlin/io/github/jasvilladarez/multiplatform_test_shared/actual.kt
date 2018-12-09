package io.github.jasvilladarez.multiplatform_test_shared

import platform.UIKit.UIDevice

actual fun platformName(): String {
    return "${UIDevice.currentDevice.systemName()} ${UIDevice.currentDevice.systemVersion}"
}