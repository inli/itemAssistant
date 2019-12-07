package com.example.itemassistant;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends ArrayAdapter<item> {
    private int resourceId;

    public ItemAdapter(Context context,int textViewResourceId,List<item> items){
        super(context,textViewResourceId,items);
        this.resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position,View converView,ViewGroup parent){
        String data="";
        DatabaseHelper databaseHelper = new DatabaseHelper(getContext(),"itemAssistant",null,1);
        SQLiteDatabase db = databaseHelper.getReadableDatabase();

        Cursor result=db.rawQuery(
                "SELECT * FROM item", null);
        result.moveToFirst();
        while (!result.isAfterLast()) {
            String id = result.getString(0);
            String name = result.getString(1);
            String time = result.getString(2);

            data = id + name + time;
            Log.i("data",data);
            result.moveToNext();
        }
        result.close();

        item item = getItem(position);

        //View view=View.inflate(this.getContext(),R.layout.listview,null);
        View view = LayoutInflater.from(this.getContext()).inflate(R.layout.listview,null);

        TextView itemName =(TextView)view.findViewById(R.id.itemName);
        itemName.setText(item.getItemName());

        TextView itemStartTime = (TextView)view.findViewById(R.id.itemStartTime);
        itemStartTime.setText(item.getItemStartTime());

        TextView itemEndTime = (TextView)view.findViewById(R.id.itemEndTime);
        itemEndTime.setText(item.getItemEndTime());

        TextView perCnt = (TextView)view.findViewById(R.id.perCnt);
        perCnt.setText(item.getPerCnt()+"");
        return view;
    }
}
