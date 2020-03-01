package com.listview.scanner.wifi.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class WifiReceiver extends BroadcastReceiver {
    WifiManager wifiManager;
    ListView wifiDeviceList;

    public WifiReceiver(WifiManager wifiManager, ListView wifiDeviceList) {
        this.wifiManager = wifiManager;
        this.wifiDeviceList = wifiDeviceList;
    }
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (WifiManager.SCAN_RESULTS_AVAILABLE_ACTION.equals(action)) {
            List<ScanResult> wifiList = wifiManager.getScanResults();
            ArrayList<WifiNetwork> deviceList = new ArrayList<>();
            for (ScanResult scanResult : wifiList) {

                deviceList.add(new WifiNetwork(scanResult.level,
                        scanResult.SSID,
                        scanResult.BSSID,
                        scanResult.frequency,
                        scanResult.channelWidth,
                        scanResult.capabilities,
                        scanResult.level
                ));
            }
            CustomAdapter arrayAdapter = new CustomAdapter(context, deviceList);
            wifiDeviceList.setAdapter(arrayAdapter);
        }
    }
}
