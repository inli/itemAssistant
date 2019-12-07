package com.example.itemassistant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
public class TaskAdapter extends ArrayAdapter<task>{
    private int resourceId;
    public TaskAdapter(Context context,int textViewResourceId,List<task> tasks){
        super(context,textViewResourceId,tasks);
        this.resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position,View converView,ViewGroup parent){
        task task = getItem(position);
        View view = LayoutInflater.from(this.getContext()).inflate(resourceId,null);

        TextView taskName = (TextView)view.findViewById(R.id.taskName);
        taskName.setText(task.getTaskName());

        TextView taskScript = (TextView)view.findViewById(R.id.taskScript);
        taskScript.setText(task.getTaskScript());

        TextView taskRecordTime = (TextView)view.findViewById(R.id.taskRecordTime);
        taskRecordTime.setText(task.getTaskRecordTime());

        TextView taskStartTime = (TextView)view.findViewById(R.id.taskStartTime);
        taskStartTime.setText(task.getTaskStartTime());

        TextView taskEndTime = (TextView)view.findViewById(R.id.taskEndTime);
        taskEndTime.setText(task.getTaskEndTime());

        TextView piName = (TextView)view.findViewById(R.id.piName);
        piName.setText(task.getPiName());
        return view;
    }
}
