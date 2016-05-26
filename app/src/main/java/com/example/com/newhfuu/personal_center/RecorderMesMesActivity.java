package com.example.com.newhfuu.personal_center;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.com.newhfuu.R;

public class RecorderMesMesActivity extends AppCompatActivity {

    private TextView form_num,form_name,form_hospital,form_department,form_doctor,form_position,form_cost,form_time,form_pay,form_state,form_mes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setDisplayHomeAsUpEnabled(true);//显示actionbar上的返回箭头
        setContentView(R.layout.content_recorder_mes_mes);

        init();         //初始化组件
    }

    private void init() {
        form_num = (TextView) findViewById(R.id.form_num);          //订单编号
        form_name = (TextView) findViewById(R.id.form_name);        //就诊人
        form_hospital = (TextView) findViewById(R.id.form_hospital);        //就诊医院
        form_department = (TextView) findViewById(R.id.form_department);        //就诊科室
        form_doctor = (TextView) findViewById(R.id.form_doctor);        //就诊医生
        form_position = (TextView) findViewById(R.id.form_position);        //医生职称
        form_cost = (TextView) findViewById(R.id.form_cost);        //费用
        form_time = (TextView) findViewById(R.id.form_time);        //就诊时间
        form_pay = (TextView) findViewById(R.id.form_pay);          //支付方式
        form_state = (TextView) findViewById(R.id.form_state);      //订单状态
        form_mes = (TextView) findViewById(R.id.form_mes);          //病情信息
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
