package com.example.com.newhfuu.Keshi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.com.newhfuu.Doctor.DoctorActivity;
import com.example.com.newhfuu.R;

import java.util.ArrayList;
import java.util.List;

import Util.DepartmentOtherAdapter;
import entity.BundleRegistertion;
import entity.Doctor;

public class Fuke extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listView4;
    private List<Doctor> list = new ArrayList<Doctor>();
    BundleRegistertion bundleRegistertion;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        bundle = getIntent().getBundleExtra("registertion");
        bundleRegistertion = bundle.getParcelable("bundleRegistertion");

        super.onCreate(savedInstanceState);
        ActionBar mActionBar = getSupportActionBar();
        this.setTitle(bundleRegistertion.getDepartment());
        mActionBar.setDisplayHomeAsUpEnabled(true);//显示actionbar上的返回箭头
        setContentView(R.layout.activity_fuke);



       init();
    }

    private void init() {
        listView4 = (ListView) findViewById(R.id.listView4);
        initList();             // TODO: 5/24/2016 初始化listview4
        DepartmentOtherAdapter departmentOtherAdapter = new DepartmentOtherAdapter(Fuke.this,R.layout.departmentother,list);
        listView4.setAdapter(departmentOtherAdapter);
        listView4.setOnItemClickListener(this);
    }

    private void initList() {
        Doctor doctor = new Doctor(R.drawable.user_2,"黄涛","主任医师","心病",23);
        list.add(doctor);
        Doctor doctor1 = new Doctor(R.drawable.user_2,"黄涛","主任医师","心病",23);
        list.add(doctor1);
        Doctor doctor2 = new Doctor(R.drawable.user_2,"黄涛","主任医师","心病",23);
        list.add(doctor2);
        Doctor doctor3 = new Doctor(R.drawable.user_2,"黄涛","主任医师","心病",23);
        list.add(doctor3);
        Doctor doctor4 = new Doctor(R.drawable.user_2,"黄涛","主任医师","心病",23);
        list.add(doctor4);
        Doctor doctor5 = new Doctor(R.drawable.user_2,"黄涛","主任医师","心病",23);
        list.add(doctor5);
        Doctor doctor6 = new Doctor(R.drawable.user_2,"黄涛","主任医师","心病",23);
        list.add(doctor6);
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
        bundleRegistertion.setDoctorName(list.get(position).getDoctorInfo_name().toString());
        Intent intent = new Intent(Fuke.this, DoctorActivity.class);
        bundle = new Bundle();
        bundle.putParcelable("bundleRegistertion",bundleRegistertion);
        intent.putExtra("registertion",bundle);
        startActivity(intent);
    }
}
