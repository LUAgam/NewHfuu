package com.example.com.newhfuu.personal_center;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.com.newhfuu.R;

import java.util.ArrayList;
import java.util.List;

import Util.AttentionAdapter;
import entity.Attention;

public class AttentionActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listView2;
    private List<Attention> list = new ArrayList<Attention>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setDisplayHomeAsUpEnabled(true);//显示actionbar上的返回箭头
        setContentView(R.layout.content_attention);
        init();         //初始化组件
    }

    private void init() {
        listView2 = (ListView) findViewById(R.id.listView2);
        initlist();    //初始化list
        AttentionAdapter attentionAdapter = new AttentionAdapter(AttentionActivity.this,R.layout.user_attention,list);
        listView2.setAdapter(attentionAdapter);
        listView2.setOnItemClickListener(this);
    }

    private void initlist() {
        Attention attention = new Attention("YISHENG0001","郭富贵","主任医师","安徽医科大学第一附属医院","儿科",R.drawable.user_2);
        list.add(attention);
        Attention attention1 = new Attention("YISHENG0002","吴大宝","主任医师","安徽医科大学第一附属医院","儿科",R.drawable.user_2);
        list.add(attention1);
        Attention attention2 = new Attention("YISHENG0003","赵小刀","主任医师","安徽医科大学第一附属医院","儿科",R.drawable.user_female);
        list.add(attention2);
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
        //跳转activity，并传递医生的编号
        Toast.makeText(AttentionActivity.this,"跳转医生详细信息",Toast.LENGTH_SHORT).show();
    }
}
