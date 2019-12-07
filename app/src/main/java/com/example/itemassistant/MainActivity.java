package com.example.itemassistant;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private String id_str="";
    private String paswd_str="";
    EditText id_edit,paswd_edit;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("activity1","onCreate()");
        setContentView(R.layout.activity_main);

        id_edit = (EditText) findViewById(R.id.phone);
        paswd_edit = (EditText) findViewById(R.id.paswd);

        login = (Button) findViewById(R.id.register);
        login.setOnClickListener(this);


    }


    @Override
    public void onClick(View view){

        switch (view.getId()){
            case R.id.register:
                id_str=id_edit.getText().toString();
                if(id_str.length() != 1){
                    Toast.makeText(this,"请输入6位数字",Toast.LENGTH_SHORT).show();
                    return;
                }
                paswd_str=paswd_edit.getText().toString();
                //验证账户名和密码
                if(id_str.equals("1") && paswd_str.equals( "1")){

                }else{
                    Toast.makeText(this,"账号或密码错误",Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(this,showList.class);
                Bundle bundle = new Bundle();
                bundle.putString("id",id_str);
                bundle.putString("paswd",paswd_str);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
        }

    }



}
