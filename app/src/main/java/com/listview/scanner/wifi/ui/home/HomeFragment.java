package com.listview.scanner.wifi.ui.home;

import android.Manifest;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import com.listview.scanner.wifi.R;
import com.listview.scanner.wifi.ui.WifiReceiver;
import static androidx.core.content.ContextCompat.checkSelfPermission;

public class HomeFragment extends Fragment {

    private ListView wifiList;
    private WifiManager wifiManager;
    private final int MY_PERMISSIONS_ACCESS_COARSE_LOCATION = 1;
    WifiReceiver receiverWifi;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        wifiManager = (WifiManager) getContext().getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        if (!wifiManager.isWifiEnabled()) {
            Toast.makeText(getContext().getApplicationContext(), getResources().getString(R.string.turning_on_wifi), Toast.LENGTH_LONG).show();
            wifiManager.setWifiEnabled(true);
        }
        wifiList = root.findViewById(R.id.listView);
        return root;
    }


    @Override
    public void onResume() {
        super.onResume();

        receiverWifi = new WifiReceiver(wifiManager, wifiList);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION);
        getContext().registerReceiver(receiverWifi, intentFilter);
        getWifi();
    }


    private void getWifi() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(getContext(), getResources().getString(R.string.permissions), Toast.LENGTH_SHORT).show();
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, MY_PERMISSIONS_ACCESS_COARSE_LOCATION);
            } else {
                Toast.makeText(getContext(), getResources().getString(R.string.scanning), Toast.LENGTH_SHORT).show();
                wifiManager.startScan();

            }
        } else {
            Toast.makeText(getContext(), getResources().getString(R.string.scanning), Toast.LENGTH_SHORT).show();
            wifiManager.startScan();
        }
    }

}