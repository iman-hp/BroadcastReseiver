package com.example.iman.broadcastreseiver;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Iman on 4/8/2018.
 */

public class ListDrawer_Adapter extends BaseAdapter {

    Context mContext;
    String data[];

    public ListDrawer_Adapter(Context mContext, String[] data) {
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int position) {
        return data[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row= LayoutInflater.from(mContext).inflate(R.layout.list_drawer_item,parent,false);
        TextView txt_data=row.findViewById(R.id.txt_data);
        txt_data.setText(data[position]);
        return row;
    }
}
