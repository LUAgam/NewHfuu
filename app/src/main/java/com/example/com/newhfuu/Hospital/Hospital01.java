package com.example.com.newhfuu.Hospital;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.com.newhfuu.R;

/**
 * 无用
 */
public class Hospital01 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital01);
       RelativeLayout rl_jixilu = (RelativeLayout) findViewById(R.id.rl_jixilu);
        //绩溪路门诊点击事件
        rl_jixilu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Hospital01.this,Hospital_01mainpage.class);
                startActivity(intent);
            }
        });
    }
}
