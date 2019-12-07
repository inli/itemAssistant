package com.example.itemassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class add_taskScript extends AppCompatActivity implements View.OnClickListener{
    private Button addTaskScript;
    private String taskScript;
    EditText e_taskScript;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task_script);

        e_taskScript = (EditText)findViewById(R.id.taskScript);


        addTaskScript = (Button)findViewById(R.id.addTaskScript);
        addTaskScript.setOnClickListener(this);


    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.addTaskScript:
                taskScript = e_taskScript.getText().toString();
                Toast.makeText(this,taskScript,Toast.LENGTH_SHORT).show();


                Intent intent = new Intent(add_taskScript.this,showTaskList.class);
                startActivity(intent);
                break;
        }

    }
}
