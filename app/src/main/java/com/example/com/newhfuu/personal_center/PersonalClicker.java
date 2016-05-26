package com.example.com.newhfuu.personal_center;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.example.com.newhfuu.Login.LoginActivity;
import com.example.com.newhfuu.R;

/**
 * Created by woshi on 2016/4/26.
 */
public class PersonalClicker implements View.OnClickListener {
    private Activity activity;
    public PersonalClicker(Activity activity){
        this.activity = activity;
    }
    @Override

    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            /*case R.id.About:

                Intent intent = new Intent(activity,AboutActivity.class);
                activity.startActivity(intent);
                break;*/
            case R.id.myData:
                 intent = new Intent(activity,AccountActivity.class);
                activity.startActivity(intent);
//                activity.overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                break;
            case R.id.cardMan:   //就诊卡管理
                 /*intent = new Intent(activity,AccountActivity.class);
                 activity.startActivity(intent);*/
                Toast.makeText(activity,"就诊卡管理",Toast.LENGTH_SHORT).show();
                break;
           /* case R.id.C_Recorder:                       /*//*查看挂号记录*//**//*
                intent = new Intent(activity,RecorderHistoryActivity.class);
                activity.startActivity(intent);
                break;*/
            /*case R.id.C_Recorder:          /*//* 医患咨询管理*//**//*
                intent = new Intent(activity,ConsultActivity.class);
                activity.startActivity(intent);
                break;
            case R.id.N_Recorder:
                intent = new Intent(activity,RecorderNowActivity.class);
                activity.startActivity(intent);
                break;
            case R.id.J_Manage:
                intent = new Intent(activity,ManageActivity.class);
                activity.startActivity(intent);
                break;*/
            case R.id.User_Image:
                intent = new Intent(activity, LoginActivity.class);
                activity.startActivity(intent);
                break;
            default:
                break;
        }

    }
}
