package com.example.itemassistant;

public class task {

    private String taskName;
    private String taskScript;
    private String taskStartTime;
    private String taskEndTime;
    private String taskRecordTime;
    private String piName;
    private int itemId;

    public task(){

    }
    public task(String taskName,String taskScript,String taskRecordTime,String taskStartTime,String taskEndTime,String piName,int itemId){
        this.taskName = taskName;
        this.taskScript = taskScript;
        this.taskStartTime = taskStartTime;
        this.taskEndTime = taskEndTime;
        this.piName = piName;
        this.taskRecordTime = taskRecordTime;
        this.itemId = itemId;
    }
    public  void setItemId(int itemId){
        this.itemId = itemId;
    }
    public int getItemId(){
        return itemId;
    }
    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskScript() {
        return taskScript;
    }

    public void setTaskScript(String taskScript) {
        this.taskScript = taskScript;
    }

    public String getTaskStartTime() {
        return taskStartTime;
    }

    public void setTaskStartTime(String taskStartTime) {
        this.taskStartTime = taskStartTime;
    }

    public String getTaskEndTime() {
        return taskEndTime;
    }

    public void setTaskEndTime(String taskEndTime) {
        this.taskEndTime = taskEndTime;
    }

    public String getPiName() {
        return piName;
    }

    public void setPiName(String piName) {
        this.piName = piName;
    }

    public String getTaskRecordTime() {
        return taskRecordTime;
    }

    public void setTaskRecordTime(String taskRecordTime) {
        this.taskRecordTime = taskRecordTime;
    }

    public String toString(){
        String text = "任务名称" + this.taskName +
                "任务描述" + this.taskScript;
        return  text;
    }
}


