package com.example.itemassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class add_task extends AppCompatActivity implements View.OnClickListener{
    private String taskName;
    private String taskScript;
    private String taskStartTime;
    private String taskEndTime;
    private String taskRecordTime;
    private String piName;
    private int itemId;
    Button addTask;
    EditText e_taskName,e_taskScript,e_taskStartTime,e_taskEndTime,e_piName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        //获取项目id
        Intent intent=this.getIntent();
        Bundle bundle=intent.getExtras();
        itemId = bundle.getInt("itemId");


        e_taskName = (EditText)findViewById(R.id.taskName);
        e_taskScript = (EditText)findViewById(R.id.taskScript);
        e_taskStartTime = (EditText)findViewById(R.id.taskStartTime);
        e_taskEndTime = (EditText)findViewById(R.id.taskEndTime);
        e_piName = (EditText)findViewById(R.id.piName);

        addTask = (Button)findViewById(R.id.addTask);
        addTask.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
        task task0 = new task();
        String text = "";
        switch (view.getId()){
            case R.id.addTask:
                taskName = e_taskName.getText().toString();
                taskScript = e_taskScript.getText().toString();
                taskStartTime = e_taskStartTime.getText().toString();
                taskEndTime = e_taskEndTime.getText().toString();
                piName = e_piName.getText().toString();

                //初始化task0
                task0.setTaskName(taskName);
                task0.setPiName(piName);
                task0.setTaskEndTime(taskEndTime);
                task0.setTaskScript(taskScript);
                task0.setTaskStartTime(taskStartTime);
                task0.setItemId(itemId);
                task0.setTaskRecordTime("2019");

                //向数据库添加任务信息
                DatabaseHelper databaseHelper = new DatabaseHelper(add_task.this,"itemAssistant",null,1);
                SQLiteDatabase db = databaseHelper.getWritableDatabase();
                databaseHelper.addTask(db,task0);

                text = "添加成功";
                Toast.makeText(this, text,
                        Toast.LENGTH_SHORT).show();
                Log.i("text",text);

                //跳转到任务列表
                Intent intent = new Intent(add_task.this,showTaskList.class);
                startActivity(intent);
                break;
        }
    }
}
