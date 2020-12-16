package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.util.ToastUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //声明控件
    private Button mBtnLogin;
    private EditText mEtUser;
    private EditText mEtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //找到控件
        mBtnLogin = findViewById(R.id.btn_login);
        mEtUser = findViewById(R.id.et_1);
        mEtPassword = findViewById(R.id.et_2);

        //实现跳转方法1
//        mBtnLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = null;
//                intent = new Intent(MainActivity.this, FunctionActivity.class);
//                startActivity(intent);
//            }
//        });
        //匹配对应的用户名和密码才能进行登录操作和密码
        mBtnLogin.setOnClickListener(this);
    }

    public void onClick(View v) {


        String username = mEtUser.getText().toString();
        String password = mEtPassword.getText().toString();
        //弹出的内容设置
        String success = "登陆成功";
        String fail = "密码或者账号有误，请重新登陆";
        Intent intent = null;

        if (username.equals("czj") && password.equals("123456")) {
            //toast普通版
            //Toast.makeText(getApplicationContext(), success, Toast.LENGTH_LONG).show();

            //封装好的类
            ToastUtil.shortMsg(getApplicationContext(),success);

            //如果正确的话进行跳转
            intent = new Intent(MainActivity.this, SlideActivity.class);
            startActivity(intent);
        } else {
            //不正确
            //提升版，居中显示的话
//            Toast toastCenter = Toast.makeText(getApplicationContext(), fail, Toast.LENGTH_LONG);
//            toastCenter.setGravity(Gravity.CENTER, 0, 0);
//            toastCenter.show();
            ToastUtil.shortMsg(MainActivity.this,fail);
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}