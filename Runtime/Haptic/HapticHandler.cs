using UnityEngine;

namespace DeviceTool.Haptic
{
    public static class HapticHandler
    {
        private static IHaptic instance;

        private static void CheckInstance()
        {
            if (instance == null)
            {
#if UNITY_EDITOR

#elif UNITY_ANDROID
                instance = new AndHaptic();
#elif UNITY_IOS
                instance = new IosHaptic();
#else

#endif
            }
        }

        public static void Haptic(HAPTIC_TYPE hapticType)
        {
            CheckInstance();
            if (instance == null)
            {
                Debug.LogError("Current platform dosn't support DeviceTool - Haptic");
                return;
            }
            instance.Haptic(hapticType);
        }
    }
}