package com.example.com.newhfuu.personal_center;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.com.newhfuu.R;

import java.util.ArrayList;
import java.util.List;

import Util.RecorderAdapter;
import entity.Recorder;

public class RecorderNowActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {


    private ListView listView;
    private List<Recorder> list = new ArrayList<Recorder>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setDisplayHomeAsUpEnabled(true);//显示actionbar上的返回箭头
        setContentView(R.layout.activity_personal_center_now_recorder);

        init();
    }

    private void init() {
        listView = (ListView) findViewById(R.id.listView);
        initlist();    //初始化list
        RecorderAdapter recorderAdapter = new RecorderAdapter(RecorderNowActivity.this,R.layout.recorder_user,list);
        listView.setAdapter(recorderAdapter);
        listView.setOnItemClickListener(this);
    }

    private void initlist() {
        Recorder menu = new Recorder("31780641","待就诊",R.drawable.mini_avatar_shadow,"吴永贵","主任医师","安徽省医科大学附属第一医院","儿科","郭奥门","0.00元","06-20 下午");
        list.add(menu);
        Recorder menu1 = new Recorder("31780642","已取消",R.drawable.mini_avatar_shadow,"吴永贵","主任医师","安徽省医科大学附属第一医院","儿科","郭奥门","0.00元","06-20 下午");
        list.add(menu1);
        Recorder menu2 = new Recorder("31780643","已取消",R.drawable.mini_avatar_shadow,"吴永贵","主任医师","安徽省医科大学附属第一医院","儿科","郭奥门","0.00元","06-20 下午");
        list.add(menu2);
        Recorder menu3 = new Recorder("31780644","已取消",R.drawable.mini_avatar_shadow,"吴永贵","主任医师","安徽省医科大学附属第一医院","儿科","郭奥门","0.00元","06-20 下午");
        list.add(menu3);
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
        Intent intent = new Intent(RecorderNowActivity.this,RecorderMesActivity.class);
        intent.putExtra("num",list.get(position).getUserMes_num());
        startActivity(intent);
    }
}
