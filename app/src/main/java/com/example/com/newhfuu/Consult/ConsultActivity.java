package com.example.com.newhfuu.Consult;

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

import Util.ConsultAdapter;
import entity.Consult;

public class ConsultActivity extends AppCompatActivity {

    private ListView listView;
    private List<Consult> list = new ArrayList<Consult>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setDisplayHomeAsUpEnabled(true);         //显示actionbar上的返回箭头
        setContentView(R.layout.content_consult);

        init();     /*初始化*/

        ConsultAdapter adapter = new ConsultAdapter(this,R.layout.consult_item,list);
        listView.setAdapter(adapter);      /*为list添加适配器*/
        listView.setOnItemClickListener(new OnItemClickListener());   /*listView点击事件*/
    }

    private void init() {
        listView = (ListView) findViewById(R.id.listView);

        Consult consult = new Consult("超级管理员",R.drawable.doctor01);
        list.add(consult);
        Consult consult1 = new Consult("超级管理员",R.drawable.doctor01);
        list.add(consult);
        Consult consult2 = new Consult("超级管理员",R.drawable.doctor01);
        list.add(consult);

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

    private class OnItemClickListener implements android.widget.AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Consult consult = list.get(position);              /* listview点击事件*/
            Intent intent = new Intent(ConsultActivity.this,Consult_consult.class);
            intent.putExtra("label",consult.getName());
            startActivity(intent);
        }
    }
}
