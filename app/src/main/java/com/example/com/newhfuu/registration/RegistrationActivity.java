package com.example.com.newhfuu.registration;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.com.newhfuu.Hospital.Hospital_01mainpage;
import com.example.com.newhfuu.R;

import java.util.ArrayList;
import java.util.List;

import Util.HospitalAdapter;
import entity.BundleRegistertion;
import entity.Hospital;


public class RegistrationActivity extends AppCompatActivity implements  AdapterView.OnItemClickListener {

    private ListView listView3;
    private List<Hospital> list = new ArrayList<Hospital>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setDisplayHomeAsUpEnabled(true);//显示actionbar上的返回箭头
        setContentView(R.layout.activity_registration);

        /*Button btn_allcity = (Button) findViewById(R.id.btn_allcity);
        Button btn_zhpx = (Button) findViewById(R.id.btn_zhpx);
        Button btn_shuaixuan = (Button) findViewById(R.id.btn_shuaixuan);

        RelativeLayout rl_yiyuan01 = (RelativeLayout) findViewById(R.id.rl_yiyuan01);
        rl_yiyuan01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistrationActivity.this, Hospital01.class);
                startActivity(intent);
            }
        });


        btn_allcity.setOnClickListener(this);
        btn_zhpx.setOnClickListener(this);
        btn_shuaixuan.setOnClickListener(this);

*/

        init();
    }

    private void init() {
        listView3 = (ListView) findViewById(R.id.listView3);
        initlist();    //初始化list
        HospitalAdapter hospitalAdapter = new HospitalAdapter(RegistrationActivity.this,R.layout.hospital_listview,list);
        listView3.setAdapter(hospitalAdapter);
        listView3.setOnItemClickListener(this);
    }

    private void initlist() {
        Hospital hospital = new Hospital("YIYUAN0001","安徽医科大学第一附属医院",R.drawable.hospital,345);
        list.add(hospital);
        Hospital hospital1 = new Hospital("YIYUAN0002","安徽省立医院",R.drawable.hospital,345);
        list.add(hospital1);
        Hospital hospital2 = new Hospital("YIYUAN0003","解放军105医院",R.drawable.hospital,345);
        list.add(hospital2);
        Hospital hospital3 = new Hospital("YIYUAN0004","安徽医科大学第二附属医院",R.drawable.hospital,345);
        list.add(hospital3);
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
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        /*Intent intent = new Intent(RegistrationActivity.this,RecorderMesActivity.class);
        intent.putExtra("num",list.get(position).getUserMes_num());
        startActivity(intent);*/

        BundleRegistertion bundleRegistertion = new BundleRegistertion(list.get(position).getHospital_name().toString(),"","","","","","");
        Intent intent = new Intent(RegistrationActivity.this, Hospital_01mainpage.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("bundleRegistertion",bundleRegistertion);
        intent.putExtra("registertion",bundle);
        startActivity(intent);
    }

/*    @Override
    public void onClick(View v) {

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction beginTransaction =fragmentManager.beginTransaction();

                switch (v.getId()) {
            case R.id.btn_allcity:
                beginTransaction.replace(R.id.ll_layout2, new Quancheng());
                break;

            case R.id.btn_zhpx:
                beginTransaction.replace(R.id.ll_layout2, new Zonghepaixu());
                break;

            case R.id.btn_shuaixuan:
                beginTransaction.replace(R.id.ll_layout2, new Shuaixuan());
                break;

            default:
                break;
        }
        beginTransaction.commit();
    }*/

}
