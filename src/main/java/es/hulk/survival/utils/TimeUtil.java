package es.hulk.survival.utils;

public final class TimeUtil {

    private TimeUtil() {
        throw new RuntimeException("Cannot instantiate a utility class.");
    }

    public static String convert(int seconds) {
        int h = seconds / 3600;
        int i = seconds - h * 3600;
        int m = i / 60;
        int s = i - m * 60;
        String timeF = "";
        if (h > 0) {
            if (h < 10) {
                timeF = timeF + "0";
            }
            timeF = timeF + h + ":";
        }
        if (m < 10) {
            timeF = timeF + "0";
        }
        timeF = timeF + m + ":";
        if (s < 10) {
            timeF = timeF + "0";
        }
        timeF = timeF + s;

        return timeF;
    }
}
