package com.example.com.newhfuu.Hospital;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.com.newhfuu.R;

/**
 * Created by Creat on 2016/5/10.   无用
 */
public class Fragment_neike extends Fragment implements View.OnClickListener {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_neike,null);
        Button btn_fuchanke = (Button) view.findViewById(R.id.btn_fuchanke);
        Button btn_neike = (Button) view.findViewById(R.id.btn_neike);

        btn_fuchanke.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        android.app.FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction beginTransaction= fragmentManager.beginTransaction();
        switch (getId()){
            case R.id.btn_neike:
                beginTransaction.replace(R.id.ll_layout4,new Fragment_neike());
                break;

            default:
                break;

        }
        beginTransaction.commit();
    }
}
