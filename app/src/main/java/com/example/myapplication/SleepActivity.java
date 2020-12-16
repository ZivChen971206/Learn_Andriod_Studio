package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplication.Adapter.PlayAdapter;

public class SleepActivity extends AppCompatActivity {
    private RecyclerView mRVFinish;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep);
        mRVFinish = findViewById(R.id.rv_finish);
        //利用adapter显示item
        mRVFinish.setLayoutManager(new LinearLayoutManager(SleepActivity.this));
        //设置adapter
        mRVFinish.setAdapter(new PlayAdapter(SleepActivity.this, new PlayAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(SleepActivity.this, "click..." + pos, Toast.LENGTH_SHORT).show();
            }
        }));


    }
}