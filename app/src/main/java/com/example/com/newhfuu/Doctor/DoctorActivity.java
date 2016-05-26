package com.example.com.newhfuu.Doctor;

import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.com.newhfuu.R;

import entity.BundleRegistertion;

public class DoctorActivity extends AppCompatActivity implements View.OnClickListener {
    private PopupWindow popupWindow;
    private Context mContext;
    Bundle bundle;
    BundleRegistertion bundleRegistertion;
    Button btn_guahao,btn_zixun;
    LinearLayout lin_1,lin_2;
    TextView userMes_name_1;    // TODO: 5/25/2016 医生职位
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setDisplayHomeAsUpEnabled(true);//显示actionbar上的返回箭头
        setContentView(R.layout.activity_doctor);

        init();         // TODO: 5/25/2016 初始化组件
    }

    private void init() {
        bundle = getIntent().getBundleExtra("registertion");
        bundleRegistertion = bundle.getParcelable("bundleRegistertion");

        btn_guahao = (Button) findViewById(R.id.btn_guahao);
        btn_zixun = (Button) findViewById(R.id.btn_zixun);
        lin_1 = (LinearLayout) findViewById(R.id.lin_1);
        lin_2 = (LinearLayout) findViewById(R.id.lin_2);
        userMes_name_1 = (TextView) findViewById(R.id.userMes_name_1);

        btn_guahao.setOnClickListener(this);
        btn_guahao.performClick();
        btn_zixun.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        android.app.FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();

        switch (v.getId()) {
            case R.id.btn_guahao:
                lin_1.setBackgroundColor(Color.WHITE);
                lin_2.setBackgroundColor(getResources().getColor(R.color.blue_2));
                btn_guahao.setBackground(getResources().getDrawable(R.drawable.textview_other_1));
                btn_zixun.setBackgroundColor(getResources().getColor(R.color.blue_2));
                beginTransaction.replace(R.id.ll_layout5, new Fragment_guaohao());
                break;

            case R.id.btn_zixun:
                lin_1.setBackgroundColor(getResources().getColor(R.color.blue_1));
                lin_2.setBackgroundColor(Color.WHITE);
                btn_guahao.setBackgroundColor(getResources().getColor(R.color.blue_1));
                btn_zixun.setBackground(getResources().getDrawable(R.drawable.textview_other_2));
                beginTransaction.replace(R.id.ll_layout5, new Fragment_zixun());
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
