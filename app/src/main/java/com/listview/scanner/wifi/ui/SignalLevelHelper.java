package com.listview.scanner.wifi.ui;

import com.listview.scanner.wifi.R;

public class SignalLevelHelper {

    public static int getWifiLevelBackgroundResource(int level)
    {
        switch (level)
        {
            case 0:
                return R.drawable.wifi_signal_0;
            case 1:
                return R.drawable.wifi_signal_1;
            case 2:
                return R.drawable.wifi_signal_2;
            case 3:
                return R.drawable.wifi_signal_3;
            case 4:
                return R.drawable.wifi_signal_4;
            case 5:
                return R.drawable.wifi_signal_5;
            default:
                return R.drawable.wifi_signal_0;

        }
    }
}
