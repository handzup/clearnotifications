package com.lti.clearnotification;

import android.app.NotificationManager;
import android.content.Context;
import android.util.Log;

import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

public class ClearnotificationPlugin implements FlutterPlugin, MethodCallHandler {
    private static final String TAG = ClearnotificationPlugin.class.getSimpleName();
    private static final String METHOD_CHANNEL = "clearnotification";

    private MethodChannel channel;
    private Context applicationContext;
    private NotificationManager notificationManager;

    @Override
    public void onAttachedToEngine(FlutterPluginBinding flutterPluginBinding) {
        onAttachedToEngine(flutterPluginBinding.getApplicationContext(), flutterPluginBinding.getBinaryMessenger());
    }

    public static void registerWith(Registrar registrar) {
        ClearnotificationPlugin plugin = new ClearnotificationPlugin();
        plugin.onAttachedToEngine(registrar.context(), registrar.messenger());
    }

    @Override
    public void onMethodCall(MethodCall call, Result result) {
        try {
            if (call.method.equals("all")) {
                getNotificationManager().cancelAll();
                Log.d(TAG,"All notifications cleared");
                result.success(null);
            } else {
                result.notImplemented();
            }
        } catch (Exception ex) {
            Log.d(TAG, "onMethodCall|" + ex.getMessage());
        }
    }

    @Override
    public void onDetachedFromEngine(FlutterPluginBinding binding) {
    }

    private void onAttachedToEngine(Context context, BinaryMessenger binaryMessenger) {
        this.applicationContext = context;
        this.channel = new MethodChannel(binaryMessenger, METHOD_CHANNEL);
        this.channel.setMethodCallHandler(this);
    }

    private NotificationManager getNotificationManager() {
        try {
            if (notificationManager == null) {
                notificationManager = (NotificationManager) applicationContext.getSystemService(Context.NOTIFICATION_SERVICE);
            }
        } catch (Exception ex) {
            Log.d(TAG, "getNotificationManager|" + ex.getMessage());
        }
        return notificationManager;
    }
}
