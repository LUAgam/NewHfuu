package com.example.com.newhfuu.personal_center;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.com.newhfuu.R;

public class RecorderMesActivity extends AppCompatActivity implements View.OnClickListener, MenuItem.OnMenuItemClickListener {

    private TextView recoderMes_datee,recoderMes_num,recoderMes_name,recoderMes_position,recoderMes_hospital,
            recoderMes_department,recoderMes_Uname,recoderMes_date;
    private ImageView recoderMes_image;
    private RelativeLayout note,recoderMes_mes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setDisplayHomeAsUpEnabled(true);//显示actionbar上的返回箭头
        setContentView(R.layout.content_recorder_mes);
        init();     //初始化各组件
        Intent intent = getIntent();
        String num = intent.getStringExtra("num");                       //获取订单的编号,从网络获取详细信息，并判断状态，根据状态来修改界面
        Toast.makeText(RecorderMesActivity.this,num,Toast.LENGTH_SHORT).show();
        initOnclick();
    }

    private void initOnclick() {
        recoderMes_mes.setOnClickListener(this);
        note.setOnClickListener(this);
    }

    private void init() {
        recoderMes_datee = (TextView) findViewById(R.id.recoderMes_datee); //就诊日期
        recoderMes_num = (TextView) findViewById(R.id.recoderMes_num);    //订单编号
        recoderMes_name = (TextView) findViewById(R.id.recoderMes_name);   //医生名称
        recoderMes_position = (TextView) findViewById(R.id.recoderMes_position);    //医生职位
        recoderMes_hospital = (TextView) findViewById(R.id.recoderMes_hospital);       //医院名称
        recoderMes_department = (TextView) findViewById(R.id.recoderMes_department);    //医院科室
        recoderMes_Uname = (TextView) findViewById(R.id.recoderMes_Uname);          //就诊人名称
        recoderMes_date = (TextView) findViewById(R.id.recoderMes_date);            //就诊时间
        recoderMes_image = (ImageView) findViewById(R.id.recoderMes_image);     //医生照片
        note = (RelativeLayout) findViewById(R.id.note);        //就诊须知
        recoderMes_mes = (RelativeLayout) findViewById(R.id.recoderMes_mes);        //订单详情
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case android.R.id.home:

                this.finish();
                //overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                return true;
            default:
                return super.onOptionsItemSelected(item);}
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.recoderMes_mes:       //订单详情组件
                intent = new Intent(RecorderMesActivity.this,RecorderMesMesActivity.class);
                startActivity(intent);
                break;
            case R.id.note:       //就诊须知组件
                intent = new Intent(RecorderMesActivity.this,RecoderNoteActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("取消订单").setOnMenuItemClickListener(this).setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);  //在标题栏增加按钮
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onMenuItemClick(MenuItem item) {
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(RecorderMesActivity.this);
        alertDialog.setTitle("提示");
        alertDialog.setMessage("确认取消当前订单吗？");
        alertDialog.setPositiveButton("是的", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(RecorderMesActivity.this,"您取消了订单！",Toast.LENGTH_SHORT).show();
            }
        });
        alertDialog.setNegativeButton("不了", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alertDialog.create().show();
        return false;
    }
}
