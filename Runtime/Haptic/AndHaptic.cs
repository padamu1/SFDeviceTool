using System;
using UnityEngine;

namespace DeviceTool.Haptic
{
    internal class AndHaptic : IHaptic
    {
        public void Haptic(HAPTIC_TYPE hapticType)
        {
            try
            {
#if UNITY_ANDROID
                using (AndroidJavaClass unityPlayer = new AndroidJavaClass("com.unity3d.player.UnityPlayer"))
                using (AndroidJavaObject activity = unityPlayer.GetStatic<AndroidJavaObject>("currentActivity"))
                using (AndroidJavaClass haptics = new AndroidJavaClass("com.mywatt.hapticfeedback.HapticFeedback"))
                {
                    haptics.CallStatic("playHaptic", activity, (int)hapticType);
                }
#endif
            }
            catch (Exception e)
            {
                Debug.LogException(e);
            }
        }
    }
}
