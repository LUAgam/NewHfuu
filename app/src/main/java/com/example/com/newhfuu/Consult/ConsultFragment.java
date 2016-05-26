package com.example.com.newhfuu.Consult;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.com.newhfuu.MFZXActivity;
import com.example.com.newhfuu.R;

/**
 * Created by Creat on 2016/4/27.
 */
public class ConsultFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_consult,null);

       view.findViewById(R.id.rl_meifeizixun).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(getActivity(), MFZXActivity.class);//我赞求用KeshiActivity替换MFZXActivity，看一下效果
               startActivity(intent);
           }
       });


        view.findViewById(R.id.rl_zdyszx).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MFZXActivity.class);
                startActivity(intent);
            }
        });


        view.findViewById(R.id.rl_sirenyisheng).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MFZXActivity.class);
                startActivity(intent);
            }
        });


        return view;
    }
}
