package com.example.itemassistant;

import android.app.DownloadManager;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    public void onCreate(SQLiteDatabase db) {
        //创建数据库sql语句 并 执行,相当于初始化数据库，这里是新建了一张表
        //这个方法继承自SQLiteOpenHelper,会自动调用  也就是 会 当新建了一个DatabaseHelper对象时，就会m=默认新建一张表

        String sql_create_item = "CREATE TABLE IF NOT EXISTS item(" +
                "   itemId INT not null," +
                "   itemName VARCHAR(100) NOT NULL," +
                "   itemStartTime VARCHAR(20) NOT NULL," +
                "   itemEndTime VARCHAR(20) NOT NULL," +
                "   perCnt INT not null,"+
                "   PRIMARY KEY( itemId )" +
                ")";
        String sql_create_task = "create table if not exists task("+
                "taskId int not null,"+
                "taskName varchar(100) not null,"+
                "taskScript varchar(200) not null,"+
                "taskRecordTime varchar(20) not null,"+
                "taskStartTime varchar(20) not null,"+
                "taskEndTime varchar(20) not null,"+
                "piName varchar(40) not null,"+
                "itemId int not null,"+
                "primary key(taskId)"+
                ")";
//        String sql_create_connection = "create table if not exists conn("+
//                "itemId int not null,"+
//                "taskId int not null)";

        String sql_create_scripts = "create table if not exists scripts("+
                "taskId int not null,"+
                "script var(200) not null)";
        db.execSQL(sql_create_item);
        db.execSQL(sql_create_task);
        //db.execSQL(sql_create_connection);
        db.execSQL(sql_create_scripts);




    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addItem(SQLiteDatabase db,item item){
        Cursor result = db.rawQuery("select * from item",null);
        String cnt = result.getCount()+"";
        ContentValues values = new ContentValues();
        values.put("itemId",cnt+1);
        values.put("itemName",item.getItemName());
        values.put("itemStartTime",item.getItemStartTime());
        values.put("itemEndTime",item.getItemEndTime());
        values.put("perCnt",item.getPerCnt());
        db.insert("item",null,values);
        Log.i("itemCnt",cnt);

    }

    public List<item> queryItems(SQLiteDatabase db){
        List<item> items = new ArrayList<item>();
        Cursor result = db.rawQuery("select * from item",null);
        result.moveToFirst();
        while (!result.isAfterLast()) {
            int itemId = result.getInt(0);
            String itemName=result.getString(1);
            String itemStartTime=result.getString(2);
            String itemEndTime = result.getString(3);
            int perCnt = result.getInt(4);
            items.add(new item(itemName,itemStartTime,itemEndTime,perCnt,itemId));
            result.moveToNext();
        }
        result.close();
        return items;
    }

    public void addTask(SQLiteDatabase db,task task){
        Cursor result = db.rawQuery("select * from task",null);
        String cnt = result.getCount()+"";
        ContentValues values = new ContentValues();
        values.put("taskId",cnt+1);
        values.put("taskName",task.getTaskName());
        values.put("taskScript",task.getTaskScript());
        values.put("taskStartTime",task.getTaskStartTime());
        values.put("taskEndTime",task.getTaskEndTime());
        values.put("piName",task.getPiName());
        values.put("itemId",task.getItemId());
        values.put("taskRecordTime",task.getTaskRecordTime());
        db.insert("task",null,values);
        Log.i("taskCnt",cnt);



    }

    public List<task> queryTask(SQLiteDatabase db,int itemId){
        List<task> tasks = new ArrayList<task>();
        String sql_query_task = "select * from task where itemId = "+String.valueOf(itemId);
        Cursor result = db.rawQuery(sql_query_task,null);
        result.moveToFirst();
        while (!result.isAfterLast()) {
            String taskName = result.getString(1);
            String taskScript = result.getString(2);
            String taskRecordTime = result.getString(3);
            String taskStartTime = result.getString(4);
            String taskEndTime = result.getString(5);
            String piName = result.getString(6);
            task task = new task(taskName,taskScript,taskRecordTime,taskStartTime,taskEndTime,piName,itemId);
            tasks.add(task);
            result.moveToNext();
        }
        result.close();
        return tasks;
    }
}
