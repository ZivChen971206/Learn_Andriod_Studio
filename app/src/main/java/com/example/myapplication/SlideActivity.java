package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.myapplication.util.ToastUtil;

public class SlideActivity extends AppCompatActivity {
    //声明控件
    private ImageView mIvAvatar;
    private SlideMenu slideMenu;
    private Button mBtnStudy;
    private Button mBtnSleep;
    private Button mBtnExercise;
    private Button mBtnRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide);

        //找到控件
        mIvAvatar = findViewById(R.id.iv_avatar);
        slideMenu = findViewById(R.id.slideMenu);
        mBtnStudy = findViewById(R.id.btn_main_study);
        mBtnSleep = findViewById(R.id.btn_main_sleep);
        mBtnExercise = findViewById(R.id.btn_main_exercise);
        mBtnRead = findViewById(R.id.btn_main_read);

        //实现侧滑的功能
        mIvAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slideMenu.switchMenu();
                ToastUtil.shortMsg(SlideActivity.this, "success");
            }
        });
        setListener();
    }

    private void setListener() {
        Onclick onClick = new Onclick();
        //对每一个按钮进行setOnClickListener
        mBtnStudy.setOnClickListener(onClick);
        mBtnSleep.setOnClickListener(onClick);
        mBtnExercise.setOnClickListener(onClick);
        mBtnRead.setOnClickListener(onClick);
    }

    private class Onclick implements View.OnClickListener {


        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.btn_main_study:
                    intent = new Intent(SlideActivity.this, StudyActivity.class);
                    break;
                case R.id.btn_main_sleep:
                    intent = new Intent(SlideActivity.this, SleepActivity.class);
                    break;
                case R.id.btn_main_exercise:
                    intent = new Intent(SlideActivity.this, ExerciseActivity.class);
                    break;
                case R.id.btn_main_read:
                    intent = new Intent(SlideActivity.this, ReadActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}