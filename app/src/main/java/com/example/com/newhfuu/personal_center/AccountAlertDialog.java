package com.example.com.newhfuu.personal_center;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by woshi on 2016/5/19.
 */

public class AccountAlertDialog   {
Context context;
    int a;
    String b,title;
    private CliclkerDispose cliclkerDispose;
    public AccountAlertDialog(Context context, String title){this.context=context;this.title =title;}
    public void shouwzlistDialog(){
        Activity activity = new Activity();
        activity = (Activity) context;
        switch (title){
    case "职业":
        final String[] occupation = new String[]{ "其他", "医生","教师", "幼师","会计师","设计师","空姐","护士","记者"
        ,"学者","公务员", "工程师","职业经纪人","秘书","音乐家","画师","咨询师","审计师","注册会计师","军人","警察"
        ,"消防员","教授","IT工程师","摄影师","企业高管","金融业","计算机业","商业","服务行业","教育业", "政府部门"
        ,"制造业","学生","待业"};

        AlertDialog alertDialog;
         alertDialog = new AlertDialog.Builder(context,AlertDialog.THEME_DEVICE_DEFAULT_DARK).setTitle("职业").setItems(occupation, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                a = which;
                b=occupation[which];

                cliclkerDispose = new CliclkerDispose(title,context,b);
            }
        }).create();
        Window window = alertDialog.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.alpha = 0.6f;
        window.setAttributes(lp);
        alertDialog.show();
        break;
    case "性别":
        final String[] sex = new String[]{ "女", "男"};
        alertDialog = new AlertDialog.Builder(context,AlertDialog.THEME_DEVICE_DEFAULT_DARK).setTitle("性别").setItems(sex, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                a = which;
                b=sex[which];
                cliclkerDispose = new CliclkerDispose(title,context,b);
            }
        }).create();
         window = alertDialog.getWindow();
         lp = window.getAttributes();
        lp.alpha = 0.6f;
        window.setAttributes(lp);
        alertDialog.show();
        break;
    case "血型":
        final String[] bloodtype = new String[]{ "A", "B","AB","O"};
        alertDialog = new AlertDialog.Builder(context,AlertDialog.THEME_DEVICE_DEFAULT_DARK).setTitle("血型").setItems(bloodtype, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                a = which;
                b=bloodtype[which];
                cliclkerDispose = new CliclkerDispose(title,context,b);
            }
        }).create();
        window = alertDialog.getWindow();
        lp = window.getAttributes();
        lp.alpha = 0.6f;
        window.setAttributes(lp);
        alertDialog.show();
        break;
    case "婚姻状况":
        final String[] marriage = new String[]{ "未婚", "已婚"};
        alertDialog = new AlertDialog.Builder(context,AlertDialog.THEME_DEVICE_DEFAULT_DARK).setTitle("婚姻状况").setItems(marriage, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                a = which;
                b=marriage[which];
                cliclkerDispose = new CliclkerDispose(title,context,b);
            }
        }).create();
        window = alertDialog.getWindow();
        lp = window.getAttributes();
        lp.alpha = 0.6f;
        window.setAttributes(lp);
        alertDialog.show();
      break;
            case "头像":
                final String[] pickPhtotType = new String[]{ "本地相册", "拍照"};
                alertDialog = new AlertDialog.Builder(context,AlertDialog.THEME_DEVICE_DEFAULT_DARK).setTitle("选择图片").setItems(pickPhtotType, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        a = which;
                        b=pickPhtotType[which];
                        cliclkerDispose = new CliclkerDispose(title,context,b);
                    }
                }).create();
                window = alertDialog.getWindow();
                lp = window.getAttributes();
                lp.alpha = 0.6f;
                window.setAttributes(lp);
                alertDialog.show();
                break;
    default:
        break;

    }

    }

}
