package com.example.com.newhfuu.Doctor;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.com.newhfuu.R;
import com.example.com.newhfuu.personal_center.RecorderNowActivity;

public class RegisterSuccActivity extends AppCompatActivity implements MenuItem.OnMenuItemClickListener, View.OnClickListener {

    private TextView text4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_register_succ);

        text4 = (TextView) findViewById(R.id.text4);
        text4.setOnClickListener(this);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem item=menu.add(0,11,0,"完成");
        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        item.setOnMenuItemClickListener(this);
        return true;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case 11:
                alertDialog();
                break;
        }
        return false;
    }

    private void alertDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(RegisterSuccActivity.this);
        builder.setTitle("您还未给医生发送病情描述");
        builder.setMessage("医生会根据病情描述在您就诊前提供合理的建议有利于您的治疗");
        builder.setPositiveButton("马上填写", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                Toast.makeText(RegisterSuccActivity.this,"马上填写",Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("稍候填写", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {            // TODO: 5/25/2016 结束之前其他的activity 
                Intent intent = new Intent(RegisterSuccActivity.this, RecorderNowActivity.class);
                startActivity(intent);
                dialog.cancel();
            }
        });
        builder.show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.text4:
                alertDialog();
                break;
        }
    }
}
