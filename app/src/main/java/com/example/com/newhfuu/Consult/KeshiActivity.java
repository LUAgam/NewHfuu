package com.example.com.newhfuu.Consult;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.com.newhfuu.R;

public class KeshiActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keshi);

       Button btn_fuchanke = (Button) findViewById(R.id.btn_fuchanke);
        Button btn_neike = (Button) findViewById(R.id.btn_neike);
        Button btn_erke = (Button) findViewById(R.id.btn_erke);
        Button btn_wuguanke = (Button) findViewById(R.id.btn_wuguanke);
        Button btn_waike = (Button) findViewById(R.id.btn_waike);
        Button btn_qita = (Button) findViewById(R.id.btn_qita);
        Button btn_zhongyike = (Button) findViewById(R.id.btn_zhongyike);
        Button btn_zhongliuke = (Button) findViewById(R.id.btn_zhongliuke);


        btn_fuchanke.setOnClickListener(this);
        btn_neike.setOnClickListener(this);
        btn_erke.setOnClickListener(this);
        btn_wuguanke.setOnClickListener(this);
        btn_waike.setOnClickListener(this);
        btn_qita.setOnClickListener(this);
        btn_zhongyike.setOnClickListener(this);
        btn_zhongliuke.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
      android.app.FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction beginTransaction =fragmentManager.beginTransaction();

        switch (v.getId()){
            case R.id.btn_fuchanke:
                beginTransaction.replace(R.id.ll_layout3,new Keshi_fuchan());
                break;

            case R.id.btn_neike:
                beginTransaction.replace(R.id.ll_layout3,new Keshi_neike());
                break;

            case R.id.btn_erke:

                break;

            case R.id.btn_wuguanke:

                break;

            case R.id.btn_waike:

                break;

            case R.id.btn_qita:

                break;

            case R.id.btn_zhongyike:

                break;

            case R.id.btn_zhongliuke:

                break;

            default:
                break;
        }
        beginTransaction.commit();
    }
}
