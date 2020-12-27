import Flutter
import UIKit

public class SwiftClearNotificationPlugin: NSObject, FlutterPlugin {
  public static func register(with registrar: FlutterPluginRegistrar) {
    let channel = FlutterMethodChannel(name: "clearnotification", binaryMessenger: registrar.messenger())
    let instance = SwiftClearNotificationPlugin()
    registrar.addMethodCallDelegate(instance, channel: channel)
  }

  public func handle(_ call: FlutterMethodCall, result: @escaping FlutterResult) {
    if (call.method == "all") {
              UNUserNotificationCenter.current().removeAllDeliveredNotifications()
         }
    result(nil)
  }

}
