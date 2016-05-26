package com.example.com.newhfuu.registration;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.com.newhfuu.Consult.KeshiActivity;
import com.example.com.newhfuu.R;

public class Consult_doctorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_consult);

        RelativeLayout rl_meifeizixun = (RelativeLayout) findViewById(R.id.rl_meifeizixun);
        rl_meifeizixun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Consult_doctorActivity.this, KeshiActivity.class);//我赞求用KeshiActivity替换MFZXActivity，看一下效果
                startActivity(intent);
            }
        });

    }
}
