package com.example.com.newhfuu.Hospital;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.com.newhfuu.R;

public class YiyuankeshiActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_yiyuankeshi);
        Button btn_neike = (Button) findViewById(R.id.btn_neike);
       Button btn_waike = (Button) findViewById(R.id.btn_waike);

        btn_neike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(YiyuankeshiActivity.this,Hospital_01mainpage.class);
                startActivity(intent);
            }
        });

        btn_waike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(YiyuankeshiActivity.this,Hospital_01mainpage.class);
                startActivity(intent);
            }
        });

    }
}
