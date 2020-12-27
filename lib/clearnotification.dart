import 'package:flutter/services.dart';

class ClearNotification {
  static const MethodChannel _channel =
      const MethodChannel('clearnotification');

  static get all async {
    await _channel.invokeMethod('all');
  }
}
