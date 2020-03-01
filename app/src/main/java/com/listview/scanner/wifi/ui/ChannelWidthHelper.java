package com.listview.scanner.wifi.ui;

import static android.net.wifi.ScanResult.CHANNEL_WIDTH_160MHZ;
import static android.net.wifi.ScanResult.CHANNEL_WIDTH_20MHZ;
import static android.net.wifi.ScanResult.CHANNEL_WIDTH_40MHZ;
import static android.net.wifi.ScanResult.CHANNEL_WIDTH_80MHZ;
import static android.net.wifi.ScanResult.CHANNEL_WIDTH_80MHZ_PLUS_MHZ;

public class ChannelWidthHelper {

    public static String getChannelWidthString(int channelWidth) {
        switch (channelWidth) {
            case CHANNEL_WIDTH_160MHZ:
                return "160 MHz";
            case CHANNEL_WIDTH_20MHZ:
                return "20 MHz";
            case CHANNEL_WIDTH_40MHZ:
                return "40 MHz";
            case CHANNEL_WIDTH_80MHZ:
                return "80 MHz";
            case CHANNEL_WIDTH_80MHZ_PLUS_MHZ:
                return "80+ MHz";
            default:
                return "? MHz";
        }
    }
}
