package com.example.com.newhfuu.Hospital;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.com.newhfuu.Login.LoginActivity;
import com.example.com.newhfuu.R;

/**
 * Created by Creat on 2016/4/27.
 */
public class Fragment_yiyuanfuwu extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_yiyuanfuwu, null);

        //预约挂号点击事件
        view.findViewById(R.id.tv_yuyueguahao).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });
       return view;
    }
}
