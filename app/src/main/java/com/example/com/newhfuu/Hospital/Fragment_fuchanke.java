package com.example.com.newhfuu.Hospital;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.com.newhfuu.Keshi.Fuke;
import com.example.com.newhfuu.R;

/**
 * Created by Creat on 2016/5/10.  无用
 */
public class Fragment_fuchanke extends Fragment  {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fuchanke,null);
        Button btn_fuchanke = (Button) view.findViewById(R.id.btn_fuchanke);
        Button btn_neike = (Button) view.findViewById(R.id.btn_neike);

        btn_fuchanke.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Fuke.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
