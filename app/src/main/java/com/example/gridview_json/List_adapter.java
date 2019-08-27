package com.example.gridview_json;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class List_adapter extends BaseAdapter {
    Context context;
    List<Obj> mylist_obj;
    TextView t1,t2;
    public List_adapter(Context context,List<Obj> mylist_obj){
        this.context=context;
        this.mylist_obj=mylist_obj;
    }
    @Override
    public int getCount() {
        return mylist_obj.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        convertView=layoutInflater.inflate(R.layout.activity_listview,null);
        t1=convertView.findViewById(R.id.label1);
        t2=convertView.findViewById(R.id.label2);
        t1.setText(mylist_obj.get(position).getId());
        t2.setText(mylist_obj.get(position).getTitle());
        return convertView;
    }
}


