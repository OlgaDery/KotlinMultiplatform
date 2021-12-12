package com.example.prohappymultiplatform

import platform.Foundation.NSDate
import platform.Foundation.NSUUID
import platform.Foundation.timeIntervalSince1970
import platform.UIKit.UIDevice

actual class Platform actual constructor() {
    actual val platform: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion

    actual fun randomUUID(): String {
        return NSUUID().UUIDString()
    }

    actual fun date(): Long {
        //gives UTC time
       return NSDate().timeIntervalSince1970.toLong()
    }
}