package com.listview.scanner.wifi.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.listview.scanner.wifi.R;
import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<WifiNetwork> {


    private static class ViewHolder {
        TextView txtSSID;
        TextView txtBand;
        TextView txtBSSID;
        TextView txtChannel;
        TextView txtFrequency;
        TextView txtDbSignal;
        TextView txtChannelWidth;
        TextView txtCapabilities;
        ImageView imageSignal;
    }

    public CustomAdapter(Context context, ArrayList<WifiNetwork> data) {
        super(context, R.layout.list_item, data);
    }
/*
    @Override
    public void onClick(View v) {

        int position=(Integer) v.getTag();
        Object object= getItem(position);
        WifiNetwork dataModel=(WifiNetwork)object;

        switch (v.getId())
        {
            case R.id.layout:
                Toast.makeText(mContext, "SSID= " + dataModel.getSSID(), Toast.LENGTH_LONG)
                        .show();
                break;
        }
    }
*/
    //private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        WifiNetwork dataModel = getItem(position);
        ViewHolder viewHolder;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.list_item, parent, false);
            viewHolder.txtSSID = (TextView) convertView.findViewById(R.id.SSID);
            viewHolder.txtBSSID = (TextView) convertView.findViewById(R.id.BSSID);
            viewHolder.txtBand = (TextView) convertView.findViewById(R.id.band);
            viewHolder.txtChannel = (TextView) convertView.findViewById(R.id.channel);
            viewHolder.txtFrequency = (TextView) convertView.findViewById(R.id.frequency);
            viewHolder.txtChannelWidth = (TextView) convertView.findViewById(R.id.channel_width);
            viewHolder.txtDbSignal = (TextView) convertView.findViewById(R.id.dbsignal);
            viewHolder.txtCapabilities = (TextView) convertView.findViewById(R.id.capabilities);
            viewHolder.imageSignal = (ImageView) convertView.findViewById(R.id.signalimage);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.txtSSID.setText(dataModel.getSSID());
        viewHolder.txtBSSID.setText(dataModel.getBSSID());
        viewHolder.txtChannel.setText(dataModel.getChannel());
        viewHolder.txtChannelWidth.setText( dataModel.getChannelWidth());
        viewHolder.txtFrequency.setText( dataModel.getFrequency());
        viewHolder.txtDbSignal.setText(dataModel.getDbSignal() + getContext().getResources().getString(R.string.db));
        viewHolder.txtBand.setText(dataModel.getBand());
        viewHolder.txtCapabilities.setText( dataModel.getCapabilities());
        viewHolder.imageSignal.setBackgroundResource(dataModel.getDbSignalBackgroundResource());
        return convertView;
    }

}
