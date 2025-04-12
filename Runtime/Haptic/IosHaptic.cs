#if UNITY_IOS
using System.Runtime.InteropServices;
#endif

using System;
using UnityEngine;

namespace DeviceTool.Haptic
{
    internal class IosHaptic : IHaptic
    {
#if UNITY_IOS
        [DllImport("__Internal")]
        private static extern void PlayHaptic(int type);
#else
        private static void PlayHaptic(int type)
        {
            Debug.Log("this device not supported haptic");
        }
#endif
        public void Haptic(HAPTIC_TYPE hapticType)
        {
            try
            {
                PlayHaptic((int)hapticType);
            }
            catch (Exception e)
            {
                Debug.LogException(e);
            }
        }
    }
}
