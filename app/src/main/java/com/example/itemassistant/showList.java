package com.example.itemassistant;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class showList extends AppCompatActivity implements View.OnClickListener{
    Button addItem,addTask,addTaskScript;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_list);

        addItem = (Button)findViewById(R.id.addItem);
        addItem.setOnClickListener(this);

//        addTask = (Button)findViewById(R.id.addTask);
//        addTask.setOnClickListener(this);

//        addTaskScript = (Button)findViewById(R.id.addTaskScript);
//        addTaskScript.setOnClickListener(this);

        setItemList itemList = new setItemList();

        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();

        transaction.replace(R.id.showList,itemList);

        transaction.commit();





    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.addItem:
                Intent intent_addItem = new Intent(this,add_item.class);
                startActivity(intent_addItem);
                break;
//            case R.id.addTask:
//                Intent intent_addTask = new Intent(this,add_task.class);
//                startActivity(intent_addTask);
//                break;
//            case R.id.addTaskScript:
//                Intent intent_addTaskScript = new Intent(this,add_taskScript.class);
//                startActivity(intent_addTaskScript);
//                break;

        }
    }
}
