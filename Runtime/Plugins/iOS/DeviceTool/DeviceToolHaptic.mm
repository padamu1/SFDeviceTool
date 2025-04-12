#import <UIKit/UIKit.h>

extern "C" {

    typedef NS_ENUM(NSInteger, HapticFeedbackType) {
        HapticSuccess = 0,
        HapticWarning = 1,
        HapticError = 2,
        HapticLight = 3,
        HapticMedium = 4,
        HapticHeavy = 5,
        HapticRigid = 6,
        HapticSoft = 7,
        HapticSelection = 8
    };

    void PlayHaptic(int type) {
        if (@available(iOS 13.0, *)) {
            switch (type) {
                case HapticSuccess: {
                    UINotificationFeedbackGenerator* generator = [[UINotificationFeedbackGenerator alloc] init];
                    [generator notificationOccurred:UINotificationFeedbackTypeSuccess];
                    break;
                }
                case HapticWarning: {
                    UINotificationFeedbackGenerator* generator = [[UINotificationFeedbackGenerator alloc] init];
                    [generator notificationOccurred:UINotificationFeedbackTypeWarning];
                    break;
                }
                case HapticError: {
                    UINotificationFeedbackGenerator* generator = [[UINotificationFeedbackGenerator alloc] init];
                    [generator notificationOccurred:UINotificationFeedbackTypeError];
                    break;
                }
                case HapticLight: {
                    UIImpactFeedbackGenerator* generator = [[UIImpactFeedbackGenerator alloc] initWithStyle:UIImpactFeedbackStyleLight];
                    [generator impactOccurred];
                    break;
                }
                case HapticMedium: {
                    UIImpactFeedbackGenerator* generator = [[UIImpactFeedbackGenerator alloc] initWithStyle:UIImpactFeedbackStyleMedium];
                    [generator impactOccurred];
                    break;
                }
                case HapticHeavy: {
                    UIImpactFeedbackGenerator* generator = [[UIImpactFeedbackGenerator alloc] initWithStyle:UIImpactFeedbackStyleHeavy];
                    [generator impactOccurred];
                    break;
                }
                case HapticRigid: {
                    if (@available(iOS 13.0, *)) {
                        UIImpactFeedbackGenerator* generator = [[UIImpactFeedbackGenerator alloc] initWithStyle:UIImpactFeedbackStyleRigid];
                        [generator impactOccurred];
                    }
                    break;
                }
                case HapticSoft: {
                    if (@available(iOS 13.0, *)) {
                        UIImpactFeedbackGenerator* generator = [[UIImpactFeedbackGenerator alloc] initWithStyle:UIImpactFeedbackStyleSoft];
                        [generator impactOccurred];
                    }
                    break;
                }
                case HapticSelection: {
                    UISelectionFeedbackGenerator* generator = [[UISelectionFeedbackGenerator alloc] init];
                    [generator selectionChanged];
                    break;
                }
                default:
                    break;
            }
        }
    }

}
