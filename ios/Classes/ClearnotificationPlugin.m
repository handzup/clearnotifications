#import "ClearnotificationPlugin.h"
#if __has_include(<clearnotification/clearnotification-Swift.h>)
#import <clearnotification/clearnotification-Swift.h>
#else
// Support project import fallback if the generated compatibility header
// is not copied when this plugin is created as a library.
// https://forums.swift.org/t/swift-static-libraries-dont-copy-generated-objective-c-header/19816
#import "clearnotification-Swift.h"
#endif

@implementation ClearnotificationPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
    [SwiftClearNotificationPlugin registerWithRegistrar:registrar];
}
@end
