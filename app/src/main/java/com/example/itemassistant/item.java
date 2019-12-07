package com.example.itemassistant;

public class item {
    private String itemName;
    private String itemStartTime;
    private String itemEndTime;
    private int perCnt;
    private int itemId;
    public  item(){

    }
    public  item(String itemName,String itemStartTime,String itemEndTime,int perCnt,int itemId){
        this.itemName = itemName;
        this.itemStartTime = itemStartTime;
        this.itemEndTime = itemEndTime;
        this.perCnt = perCnt;
        this.itemId = itemId;
    }
    public int getItemId(){
        return itemId;
    }

    public String getItemName(){
        return itemName;
    }
    public String getItemStartTime(){
        return itemStartTime;
    }
    public String getItemEndTime(){
        return itemEndTime;
    }
    public int getPerCnt(){
        return perCnt;
    }

    @Override
    public String toString() {
        return this.itemName+this.itemStartTime+this.itemEndTime+this.perCnt;
    }
}
