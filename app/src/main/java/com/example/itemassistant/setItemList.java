package com.example.itemassistant;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

import androidx.fragment.app.Fragment;

import androidx.fragment.app.Fragment;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


public class setItemList extends Fragment {
    private View view;
    private ListView itemList;
    private String[] data = { "Apple", "Banana", "Orange", "Watermelon",
            "Pear", "Grape", "Pineapple", "Strawberry", "Cherry", "Mango" };
    private List<item> items = new ArrayList<item>();



    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState){
        view=inflater.inflate(R.layout.fragment_show_list,container,false);

        if (view!=null) init();
        itemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListView listView = (ListView) parent;
                item item = (item) listView.getItemAtPosition(position);
                int itemId = item.getItemId();

                Intent intent = new Intent(getActivity(),showTaskList.class);
                Bundle bundle = new Bundle();
                bundle.putInt("itemId",itemId);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });
        return view;
    }
    private void init(){

        DatabaseHelper databaseHelper = new DatabaseHelper(getContext(),"itemAssistant",null,1);
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        items = databaseHelper.queryItems(db);


        ItemAdapter adapter = new ItemAdapter(getActivity(),R.layout.listview,items);
        itemList = (ListView)view.findViewById(R.id.itemList);
        itemList.setAdapter(adapter);

    }



}
