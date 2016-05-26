package com.example.com.newhfuu.Hospital;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.com.newhfuu.R;

/**
 * Created by Creat on 2016/4/28.
 */
public class Fragment_yiyuanjianjie extends Fragment {

    private TextView hospital_name,hospital_phone,hospital_address,hospital_website,hospital_info;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_yiyuanjianjie,null);

        init(view);
        return view;
    }

    private void init(View view) {
        hospital_name = (TextView) view.findViewById(R.id.hospital_name);           //别名
        hospital_phone = (TextView) view.findViewById(R.id.hospital_phone);             //电话
        hospital_address = (TextView) view.findViewById(R.id.hospital_address);         //地址
        hospital_website = (TextView) view.findViewById(R.id.hospital_website);             //网址
        hospital_info = (TextView) view.findViewById(R.id.hospital_info);               //简介

        hospital_name.setText("");
        hospital_phone.setText("0551-62922114");
        hospital_address.setText("合肥市绩溪路218号");
        hospital_website.setText("http://www.ayfy.com");
        hospital_info.setText("安徽医科大学第一附属医院前身为上海东南医学院附属东南医院，创办于1926年。1949年迁至安徽怀远县，1952年再迁至合肥市。");
    }

}
