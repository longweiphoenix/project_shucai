package com.example.along.ui1project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Long on 2016/10/25.
 */
public class MyHomeAdapter extends BaseAdapter {
    Context context;
    List<HashMap<String, Object>> list;
    LayoutInflater layoutInflater;

    public MyHomeAdapter(Context context, List<HashMap<String, Object>> list) {
        this.list = list;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null){
            viewHolder=new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.home_list_item, null);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.list_img);
            viewHolder.textView= (TextView) convertView.findViewById(R.id.list_text);
            convertView.setTag(viewHolder);
        }
       viewHolder= (ViewHolder) convertView.getTag();
        HashMap<String,Object> map=list.get(position);
        viewHolder.imageView.setImageResource((Integer) map.get("list_img"));
        viewHolder.textView.setText(map.get("list_text").toString());
        return convertView;
    }
    class ViewHolder{
        ImageView imageView;
        TextView textView;
    }
}
