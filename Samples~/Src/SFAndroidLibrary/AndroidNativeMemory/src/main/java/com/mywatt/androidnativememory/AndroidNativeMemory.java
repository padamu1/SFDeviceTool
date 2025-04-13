package com.mywatt.androidnativememory;

import android.app.ActivityManager;
import android.content.Context;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AndroidNativeMemory {

    // 현재 사용 가능한 메모리 (가용 메모리)
    public static long getAvailableMemory(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.availMem; // bytes 단위
    }

    // 전체 메모리 (운영체제가 사용할 수 있는 최대 메모리)
    public static long getTotalMemory() {
        return readMemoryInfo("/proc/meminfo", "MemTotal:");
    }

    // 물리 메모리 (총 RAM 크기)
    public static long getPhysicalMemory() {
        return getTotalMemory(); // Android에서는 MemTotal이 물리 메모리와 동일
    }

    // /proc/meminfo 파일에서 특정 키워드 값을 읽어오는 메서드
    private static long readMemoryInfo(String filePath, String key) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith(key)) {
                    String[] parts = line.split("\\s+");
                    return Long.parseLong(parts[1]) * 1024; // kB → bytes 변환
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
