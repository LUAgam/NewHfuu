package com.example.com.newhfuu.Hospital;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.com.newhfuu.R;

import entity.BundleRegistertion;

public class Hospital_01mainpage extends AppCompatActivity implements View.OnClickListener {

    private TextView userMes_name,userMes_department,userMes_department_1;
    private ImageView userMes_image,location_1;
    BundleRegistertion bundleRegistertion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setDisplayHomeAsUpEnabled(true);//显示actionbar上的返回箭头
        setContentView(R.layout.activity_hospital_01mainpage);

        Bundle bundle = getIntent().getBundleExtra("registertion");                             //获取医院
        bundleRegistertion = bundle.getParcelable("bundleRegistertion");

        init();     //初始化组件
    }

    private void init() {
        userMes_name = (TextView) findViewById(R.id.userMes_name);  //  医院名称
        userMes_department = (TextView) findViewById(R.id.userMes_department);          //医生数
        userMes_department_1 = (TextView) findViewById(R.id.userMes_department_1);          //医院地址
        userMes_image = (ImageView) findViewById(R.id.userMes_image);               //医院图片
        location_1 = (ImageView) findViewById(R.id.location_1);             //定位图片

        Button btn_yiyuankeshi = (Button) findViewById(R.id.btn_yiyuankeshi);
        Button btn_yiyuanfuwu = (Button) findViewById(R.id.btn_yiyuanfuwu);
        Button btn_yiyuanjianjie = (Button) findViewById(R.id.btn_yiyuanjianjie);

        btn_yiyuankeshi.setOnClickListener(this);
        btn_yiyuankeshi.performClick();
        btn_yiyuanfuwu.setOnClickListener(this);
        btn_yiyuanjianjie.setOnClickListener(this);
        location_1.setOnClickListener(this);

        userMes_name.setText(bundleRegistertion.getHospital().toString());
        userMes_department.setText("553");
        userMes_department_1.setText("合肥市蜀山区绩溪路218号合肥市蜀山区绩溪路218号");
        userMes_image.setImageResource(R.drawable.hospital);
    }

    @Override
    public void onClick(View v) {
        android.app.FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction beginTransaction =fragmentManager.beginTransaction();

        switch (v.getId()){
            //医院科室点击事件
            case R.id.btn_yiyuankeshi:
                beginTransaction.replace(R.id.ll_layout4,new Fragment_yiyuankeshi());
                break;
            //医院服务点击事件
            case R.id.btn_yiyuanfuwu:
                beginTransaction.replace(R.id.ll_layout4,new Fragment_yiyuanfuwu());
                break;
            //医院简介点击事件
            case R.id.btn_yiyuanjianjie:
                beginTransaction.replace(R.id.ll_layout4,new Fragment_yiyuanjianjie());
                break;
            case R.id.location_1:
                Toast.makeText(Hospital_01mainpage.this,"定位图片",Toast.LENGTH_SHORT).show();
                break;

            default:
                break;
        }
        beginTransaction.commit();

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
}
