package com.example.com.newhfuu.Hospital;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.com.newhfuu.Keshi.Fuke;
import com.example.com.newhfuu.R;

import java.util.ArrayList;
import java.util.List;

import Util.DepartmentAdapter;
import entity.BundleRegistertion;

/**
 * Created by Creat on 2016/4/27.
 */
public class Fragment_yiyuankeshi extends Fragment implements View.OnClickListener, AdapterView.OnItemClickListener {


    private ListView listView1,listView2;
    private List<String> list1 = new ArrayList<String>();
    private List<String> list2 = new ArrayList<String>();
    DepartmentAdapter adapter1;
    ArrayAdapter<String> adapter2;
    String text_1,text_2;
    BundleRegistertion bundleRegistertion;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_yiyuankeshi,null);

        /*Button btn_fuchanke = (Button) view.findViewById(R.id.btn_fuchanke);
        Button btn_neike = (Button) view.findViewById(R.id.btn_neike);
        Button btn_erke = (Button) view.findViewById(R.id.btn_erke);
        Button btn_wuguanke = (Button) view.findViewById(R.id.btn_wuguanke);
        Button btn_waike = (Button) view.findViewById(R.id.btn_waike);
        Button btn_qita = (Button) view.findViewById(R.id.btn_qita);
        Button btn_zhongyike = (Button) view.findViewById(R.id.btn_zhongyike);
        Button btn_zhongliuke = (Button) view.findViewById(R.id.btn_zhongliuke);

        btn_fuchanke.setOnClickListener(this);*/

        init(view);
        return view;
    }

    private void init(View view) {
        listView1 = (ListView) view.findViewById(R.id.listview1);
        listView2 = (ListView) view.findViewById(R.id.listview2);
        initList1();
        adapter1 = new DepartmentAdapter(getActivity(),R.layout.simple_list_item_1,list1);
        listView1.setAdapter(adapter1);
        listView1.setOnItemClickListener(this);
    }

    private void initList1() {
        list1.add("内科");
        list1.add("外科");
        list1.add("儿科");
        list1.add("五官科");
        list1.add("皮肤科");
        list1.add("精神科");
        list1.add("中医科");
        list1.add("其他科");
        list1.add("麻醉医学科");
        list1.add("医学影像科");


    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        adapter1.setSelectItem(position);
        adapter1.notifyDataSetChanged();
        text_1 = list1.get(position);
        initList2(text_1);
        adapter2 = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,list2);
        listView2.setAdapter(adapter2);
        listView2.setOnItemClickListener(new ListViewOnItemCliskListener());
    }

    private void initList2(String text) {       //text为listview中的值
        list2.clear();
        list2.add("肾脏内科");
        list2.add("风湿免疫科");
        list2.add("神经内科");
        list2.add("消化内科");
        list2.add("心血管内科");
        list2.add("血液内科");
        list2.add("内分泌科");
        list2.add("呼吸内科");
        list2.add("感染病科");
    }

    private class ListViewOnItemCliskListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent(getActivity(), Fuke.class);
            Bundle bundle = getActivity().getIntent().getBundleExtra("registertion");                             //获取医院
            bundleRegistertion = bundle.getParcelable("bundleRegistertion");
            bundleRegistertion.setDepartment(list2.get(position));
            bundle.putParcelable("bundleRegistertion",bundleRegistertion);
            intent.putExtra("registertion",bundle);
            startActivity(intent);
        }
    }

 /*   @Override
    public void onClick(View v) {
        android.app.FragmentManager fragmentManager = getFragmentManager();
       android.app.FragmentTransaction beginTransaction=  fragmentManager.beginTransaction();
        switch (v.getId()){
            //医院科室点击事件
            case R.id.btn_fuchanke:
                beginTransaction.replace(R.id.ll_layout4,new Fragment_fuchanke());

                break;

            case R.id.btn_neike:
                beginTransaction.replace(R.id.ll_layout4,new Fragment_neike());
                break;

            case R.id.btn_yiyuanjianjie:
                beginTransaction.replace(R.id.ll_layout4,new Fragment_yiyuanjianjie());
                break;

            default:
                break;
        }
        beginTransaction.commit();

    }*/

    }