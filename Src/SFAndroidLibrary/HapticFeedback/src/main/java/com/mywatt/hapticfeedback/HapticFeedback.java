package com.mywatt.hapticfeedback;

import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;

public class HapticFeedback {

    public static void playHaptic(Context context, int type) {
        Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);

        if (vibrator == null || !vibrator.hasVibrator()) {
            return;
        }

        int duration = 50;
        int amplitude = VibrationEffect.DEFAULT_AMPLITUDE;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            switch (type) {
                case 0: // Success
                    vibrator.vibrate(VibrationEffect.createOneShot(50, 200));
                    break;
                case 1: // Warning
                    vibrator.vibrate(VibrationEffect.createOneShot(100, 180));
                    break;
                case 2: // Error
                    vibrator.vibrate(VibrationEffect.createWaveform(new long[]{0, 50, 50, 50}, -1));
                    break;
                case 3: // Light
                    vibrator.vibrate(VibrationEffect.createOneShot(20, 50));
                    break;
                case 4: // Medium
                    vibrator.vibrate(VibrationEffect.createOneShot(40, 150));
                    break;
                case 5: // Heavy
                    vibrator.vibrate(VibrationEffect.createOneShot(60, 255));
                    break;
                case 6: // Rigid
                    vibrator.vibrate(VibrationEffect.createOneShot(30, 220));
                    break;
                case 7: // Soft
                    vibrator.vibrate(VibrationEffect.createOneShot(30, 80));
                    break;
                case 8: // Selection
                    vibrator.vibrate(VibrationEffect.createOneShot(10, 70));
                    break;
            }
        } else {
            vibrator.vibrate(50); // Fallback for old Android
        }
    }
}