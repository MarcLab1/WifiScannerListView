package com.listview.scanner.wifi.ui;

public class CapabilitiesHelper {

    public static final String WPA2 = "WPA2";
    public static final String WPA = "WPA";
    public static final String WEP = "WEP";
    public static final String OPEN = "Open";
    public static final String WPA_EAP = "WPA-EAP";
    public static final String IEEE8021X = "IEEE8021X";

    public static String getWifiSecurity(String capabilities) {

        final String[] security = { WEP, WPA, WPA2, WPA_EAP, IEEE8021X };
        for (int i = security.length - 1; i >= 0; i--) {
            if (capabilities.contains(security[i])) {
                return security[i];
            }
        }
        return OPEN;
    }
}
