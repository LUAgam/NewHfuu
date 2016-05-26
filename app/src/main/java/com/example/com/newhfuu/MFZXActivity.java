package com.example.com.newhfuu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.com.newhfuu.Consult.KeshiActivity;

public class MFZXActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mfzx);

       RelativeLayout rl_xuanzekeshi = (RelativeLayout) findViewById(R.id.rl_xuanzekeshi);
        rl_xuanzekeshi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MFZXActivity.this, KeshiActivity.class);
                startActivity(intent);
            }
        });
    }
}
