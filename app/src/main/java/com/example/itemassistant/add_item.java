package com.example.itemassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class add_item extends AppCompatActivity implements View.OnClickListener{
    private String itemName;
    private String itemStartTime;
    private String itemEndTime;
    private int perCnt;
    Button addItem;
    EditText e_itemName,e_itemStartTime,e_itemEndTime,e_perCnt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        e_itemName = (EditText)findViewById(R.id.itemName);
        e_itemStartTime = (EditText)findViewById(R.id.itemStartTime);
        e_itemEndTime = (EditText)findViewById(R.id.itemEndTime);
        e_perCnt = (EditText)findViewById(R.id.perCnt);

        addItem = (Button)findViewById(R.id.addItem);
        addItem.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        DatabaseHelper databaseHelper = new DatabaseHelper(this,"itemAssistant",null,1);
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        String text = "";
        switch (view.getId()){
            case R.id.addItem:
                itemName = e_itemName.getText().toString();
                itemStartTime = e_itemStartTime.getText().toString();
                itemEndTime = e_itemEndTime.getText().toString();
                perCnt = Integer.valueOf(e_perCnt.getText().toString());

                item item0 =new item(itemName,itemStartTime,itemEndTime,perCnt,-1);
                text = item0.toString();


                databaseHelper.addItem(db,item0);
                Toast.makeText(this,text,Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(add_item.this,showList.class);
                startActivity(intent);
                break;

        }
    }
}
