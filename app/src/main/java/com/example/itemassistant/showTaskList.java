package com.example.itemassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class showTaskList extends AppCompatActivity implements View.OnClickListener{
    private ListView taskListView;
    private List<task> tasks = new ArrayList<task>();
    private int itemId;
    Button addTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_task_list);

        addTask = (Button)findViewById(R.id.addTask);
        addTask.setOnClickListener(this);

        taskListView = (ListView)this.findViewById(R.id.taskListView);

        //获取项目id
        Intent intent=this.getIntent();
        Bundle bundle=intent.getExtras();
        itemId = bundle.getInt("itemId");

        //从数据库查询任务列表
        DatabaseHelper databaseHelper = new DatabaseHelper(showTaskList.this,"itemAssistant",null,1);
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        tasks = databaseHelper.queryTask(db,itemId);

        TaskAdapter adapter = new TaskAdapter(showTaskList.this,R.layout.task_item,tasks);
        taskListView.setAdapter(adapter);

        taskListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListView listView = (ListView) parent;
                task task = (task)listView.getItemAtPosition(position);
                String taskName = task.getTaskName();
                String taskScript = task.getTaskScript();
                String taskRecordTime = task.getTaskRecordTime();
                String taskStartTime = task.getTaskStartTime();
                String taskEndTime = task.getTaskEndTime();
                String piName = task.getPiName();


                Intent intent = new Intent(showTaskList.this,add_taskScript.class);
                Bundle bundle = new Bundle();
                bundle.putString("taskName",taskName);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.addTask:
                Intent intent_addTask = new Intent(this,add_task.class);
                Bundle bundle = new Bundle();
                bundle.putInt("itemId",itemId);
                intent_addTask.putExtras(bundle);
                startActivity(intent_addTask);

                break;
        }
    }
}
