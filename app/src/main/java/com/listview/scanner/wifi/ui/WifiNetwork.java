package com.listview.scanner.wifi.ui;

import android.net.wifi.WifiManager;

public class WifiNetwork {

    private int dbSignal;
    private String SSID;
    private String BSSID;
    private String band;
    private int frequency;
    private String channel;
    private String channelWidth;
    private int level;
    private String capabilities;
    private final int numberOfLevels =5;
    private  int dbSignalBackgroundResource;

    public WifiNetwork(int dbSignal, String SSID, String BSSID, int frequency, int channelWidth, String capabilities, int level)
    {
        this.dbSignal= dbSignal;
        this.SSID= SSID;
        this.BSSID = BSSID;
        this.frequency = frequency;
        this.channel = FrequencyHelper.getChannel(frequency);
        this.channelWidth = ChannelWidthHelper.getChannelWidthString(channelWidth);
        this.level = WifiManager.calculateSignalLevel(level, numberOfLevels);
        this.capabilities = CapabilitiesHelper.getWifiSecurity(capabilities);
        this.band = FrequencyHelper.getBandFromFrequency(frequency);
        this.dbSignalBackgroundResource = SignalLevelHelper.getWifiLevelBackgroundResource(this.level);
    }

    public String getDbSignal() {
        return dbSignal + "";
    }

    public String getSSID() {
        if(SSID.equals(""))
            return "?";
        else
            return SSID;
    }

    public String getFrequency() {
        return frequency + "";
    }

    public String getChannel() {
        return channel;
    }

    public String getChannelWidth() {
        return channelWidth ;
    }

    public String getCapabilities() {
        return capabilities;
    }

    public String getBSSID() {
        return BSSID;
    }

    public String getBand() {
        return band;
    }

    public int getDbSignalBackgroundResource() {
        return dbSignalBackgroundResource;
    }
}
