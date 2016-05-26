package com.example.com.newhfuu.Doctor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.com.newhfuu.R;

import entity.BundleRegistertion;

public class SureinfoActivity extends AppCompatActivity implements MenuItem.OnMenuItemClickListener, View.OnClickListener {

    private TextView form_Uname,form_hospital,form_department,form_doctor,form_cost,form_time,form_timeOfDay;

    private Bundle bunble;
    private BundleRegistertion bundleRegistertion;
    private Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setDisplayHomeAsUpEnabled(true);//显示actionbar上的返回箭头.
        setContentView(R.layout.activity_sureinfo);
        init();         // TODO: 5/25/2016 初始化组件
        initForm();
    }



    private void init() {
        bunble = getIntent().getBundleExtra("registertion");
        bundleRegistertion = bunble.getParcelable("bundleRegistertion");

        form_Uname = (TextView) findViewById(R.id.form_Uname);// TODO: 5/25/2016 就诊人 
        form_hospital = (TextView) findViewById(R.id.form_hospital);// TODO: 5/25/2016 就诊医院 
        form_department = (TextView) findViewById(R.id.form_department);// TODO: 5/25/2016 就诊科室 
        form_doctor = (TextView) findViewById(R.id.form_doctor);// TODO: 5/25/2016 医生名称
        form_cost = (TextView) findViewById(R.id.form_cost);// TODO: 5/25/2016 预约费用 
        form_time = (TextView) findViewById(R.id.form_time);// TODO: 5/25/2016 就诊日期 
        form_timeOfDay = (TextView) findViewById(R.id.form_timeOfDay);// TODO: 5/25/2016 就诊时段
        login = (Button) findViewById(R.id.login);// TODO: 5/25/2016 提交按钮组件
    }

    private void initForm() {
        form_Uname.setText("郭大奥");
        form_hospital.setText(bundleRegistertion.getHospital());
        form_department.setText(bundleRegistertion.getDepartment());
        form_doctor.setText(bundleRegistertion.getDoctorName());
        form_cost.setText(bundleRegistertion.getCost());
        form_time.setText(bundleRegistertion.getTime());
        form_timeOfDay.setText(bundleRegistertion.getTimeOfDay());
        login.setOnClickListener(this);// TODO: 5/25/2016 提交按钮事件
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem item=menu.add(0,11,0,"预约规则");
        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        item.setOnMenuItemClickListener(this);
        return true;
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
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case 11:
                Toast.makeText(SureinfoActivity.this,"您点击了预约规则",Toast.LENGTH_SHORT).show();
                break;
        }
        return false;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login:
                Intent intent1 = new Intent(SureinfoActivity.this,RegisterSuccActivity.class);
                startActivity(intent1);
                break;
        }
    }
}
