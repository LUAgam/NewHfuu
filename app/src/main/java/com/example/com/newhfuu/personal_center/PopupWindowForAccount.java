package com.example.com.newhfuu.personal_center;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.com.newhfuu.R;

/**
 * Created by woshi on 2016/5/10.
 */
public class PopupWindowForAccount {
    private Context context;
    private Activity activity;
    private TextView popupTitle,popupContent,popupBtn,popup_sex_male,popup_sex_female,
            popup_bloodtype_a,popup_bloodtype_b,popup_bloodtype_ab,popup_bloodtype_o,popup_marriage_false,popup_marriage_true;
    private CliclkerDispose cliclkerDispose;
    public PopupWindowForAccount(Context context) {

        this.context = context;
    }

    /**
     * 显示popupWindow
     * @param title
     */
    public void showPopwindow(final String title) {

       activity = (Activity) context;
        View view;
        // 利用layoutInflater获得View
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //找时间重构一下代码↓
        switch (title){
            case "职业":
              //  view = inflater
                break;
            case "性别":
                view = inflater.inflate(R.layout.accoun_pop_window_sex,null);
                popupTitle = (TextView) view.findViewById(R.id.popupTitle);
                popupTitle.setText(title);


                // 下面是两种方法得到宽度和高度 getWindow().getDecorView().getWidth()
                final PopupWindow window= popWindowHindle(view,activity);

                // 这里检验popWindow里的button是否可以点击
                popup_sex_male = (TextView) view.findViewById(R.id.popup_sex_male);
                //触摸改变背景色
                popup_sex_male.setOnTouchListener(new View.OnTouchListener() {
                    public boolean onTouch(View arg0,MotionEvent arg1) {
                        if (arg1.getAction() == MotionEvent.ACTION_DOWN) {
                            arg0.setBackgroundResource(R.color.male_pressed); //按下的图片对应pressed
                        } else if (arg1.getAction() == MotionEvent.ACTION_UP) {
                            arg0.setBackgroundResource(R.color.male_normal); //常态下的图片对应normal
                        } else{}; //if() //这里还可以继续实现MotionEvent.ACTION_MOVE和MotionEvent.ACTION_CANCEL等实现更多的特效
                        return false;
                    }
                });
                popup_sex_female = (TextView) view.findViewById(R.id.popup_sex_female);

                popup_sex_female.setOnTouchListener(new View.OnTouchListener() {
                    public boolean onTouch(View arg0,MotionEvent arg1) {
                        if (arg1.getAction() == MotionEvent.ACTION_DOWN) {
                            arg0.setBackgroundResource(R.color.female_pressed); //按下的图片对应pressed
                        } else if (arg1.getAction() == MotionEvent.ACTION_UP) {
                            arg0.setBackgroundResource(R.color.female_normal); //常态下的图片对应normal
                        } else{}; //if() //这里还可以继续实现MotionEvent.ACTION_MOVE和MotionEvent.ACTION_CANCEL等实现更多的特效
                        return false;
                    }
                });
                popup_sex_female.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String b = popup_sex_female.getText().toString();
                        cliclkerDispose = new CliclkerDispose(title,context, b);
                        window.dismiss();
                    }
                });

                popup_sex_male.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {


                        String b = popup_sex_male.getText().toString();
                        cliclkerDispose = new CliclkerDispose(title,context, b);
                        window.dismiss();
                    }
                });

                //popWindow消失监听方法
                window.setOnDismissListener(new PopupWindow.OnDismissListener() {

                    @Override
                    public void onDismiss() {
                        //恢复颜色
                        WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
                        lp.alpha = 1f;
                        activity.getWindow().setAttributes(lp);
                        System.out.println("popWindow消失");
                    }
                });
                break;
            case "婚姻状况":
                view = inflater.inflate(R.layout.account_pop_window_marriage,null);
                popupTitle = (TextView) view.findViewById(R.id.popupTitle);
                popupTitle.setText(title);


                // 下面是两种方法得到宽度和高度 getWindow().getDecorView().getWidth()
                final PopupWindow windowMarriage= popWindowHindle(view,activity);

                // 这里检验popWindow里的button是否可以点击
                popup_marriage_false = (TextView) view.findViewById(R.id.popup_marriage_false);
                //触摸改变背景色
                popup_marriage_false.setOnTouchListener(new View.OnTouchListener() {
                    public boolean onTouch(View arg0,MotionEvent arg1) {
                        if (arg1.getAction() == MotionEvent.ACTION_DOWN) {
                            arg0.setBackgroundResource(R.color.male_pressed); //按下的图片对应pressed
                        } else if (arg1.getAction() == MotionEvent.ACTION_UP) {
                            arg0.setBackgroundResource(R.color.male_normal); //常态下的图片对应normal
                        } else{}; //if() //这里还可以继续实现MotionEvent.ACTION_MOVE和MotionEvent.ACTION_CANCEL等实现更多的特效
                        return false;
                    }
                });
                popup_marriage_true = (TextView) view.findViewById(R.id.popup_marriage_true);

                popup_marriage_true.setOnTouchListener(new View.OnTouchListener() {
                    public boolean onTouch(View arg0,MotionEvent arg1) {
                        if (arg1.getAction() == MotionEvent.ACTION_DOWN) {
                            arg0.setBackgroundResource(R.color.female_pressed); //按下的图片对应pressed
                        } else if (arg1.getAction() == MotionEvent.ACTION_UP) {
                            arg0.setBackgroundResource(R.color.female_normal); //常态下的图片对应normal
                        } else{}; //if() //这里还可以继续实现MotionEvent.ACTION_MOVE和MotionEvent.ACTION_CANCEL等实现更多的特效
                        return false;
                    }
                });
                popup_marriage_false.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String b = popup_marriage_false.getText().toString();
                        cliclkerDispose = new CliclkerDispose(title,context, b);
                        windowMarriage.dismiss();
                    }
                });

                popup_marriage_true.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {


                        String b = popup_marriage_true.getText().toString();
                        cliclkerDispose = new CliclkerDispose(title,context, b);
                        windowMarriage.dismiss();
                    }
                });

                //popWindow消失监听方法
                windowMarriage.setOnDismissListener(new PopupWindow.OnDismissListener() {

                    @Override
                    public void onDismiss() {
                        //恢复颜色
                        WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
                        lp.alpha = 1f;
                        activity.getWindow().setAttributes(lp);
                        System.out.println("popWindow消失");
                    }
                });
                break;
            case "血型":
                view = inflater.inflate(R.layout.account_pop_window_bloodtype,null);
                popupTitle = (TextView) view.findViewById(R.id.popupTitle);
                popupTitle.setText(title);


                // 下面是两种方法得到宽度和高度 getWindow().getDecorView().getWidth()
                final PopupWindow windowBloodtype= popWindowHindle(view,activity);

                // 这里检验popWindow里的button是否可以点击
                popup_bloodtype_a = (TextView) view.findViewById(R.id.popup_bloodtype_a);
                //触摸改变背景色
                popup_bloodtype_a.setOnTouchListener(new View.OnTouchListener() {
                    public boolean onTouch(View arg0,MotionEvent arg1) {
                        if (arg1.getAction() == MotionEvent.ACTION_DOWN) {
                            arg0.setBackgroundResource(R.color.male_pressed); //按下的图片对应pressed
                        } else if (arg1.getAction() == MotionEvent.ACTION_UP) {
                            arg0.setBackgroundResource(R.color.male_normal); //常态下的图片对应normal
                        } else{}; //if() //这里还可以继续实现MotionEvent.ACTION_MOVE和MotionEvent.ACTION_CANCEL等实现更多的特效
                        return false;
                    }
                });
                popup_bloodtype_b = (TextView) view.findViewById(R.id.popup_bloodtype_b);

                popup_bloodtype_b.setOnTouchListener(new View.OnTouchListener() {
                    public boolean onTouch(View arg0,MotionEvent arg1) {
                        if (arg1.getAction() == MotionEvent.ACTION_DOWN) {
                            arg0.setBackgroundResource(R.color.female_pressed); //按下的图片对应pressed
                        } else if (arg1.getAction() == MotionEvent.ACTION_UP) {
                            arg0.setBackgroundResource(R.color.female_normal); //常态下的图片对应normal
                        } else{}; //if() //这里还可以继续实现MotionEvent.ACTION_MOVE和MotionEvent.ACTION_CANCEL等实现更多的特效
                        return false;
                    }
                });

                popup_bloodtype_ab = (TextView) view.findViewById(R.id.popup_bloodtype_ab);

                popup_bloodtype_ab.setOnTouchListener(new View.OnTouchListener() {
                    public boolean onTouch(View arg0,MotionEvent arg1) {
                        if (arg1.getAction() == MotionEvent.ACTION_DOWN) {
                            arg0.setBackgroundResource(R.color.male_pressed); //按下的图片对应pressed
                        } else if (arg1.getAction() == MotionEvent.ACTION_UP) {
                            arg0.setBackgroundResource(R.color.male_normal); //常态下的图片对应normal
                        } else{}; //if() //这里还可以继续实现MotionEvent.ACTION_MOVE和MotionEvent.ACTION_CANCEL等实现更多的特效
                        return false;
                    }
                });

                popup_bloodtype_o = (TextView) view.findViewById(R.id.popup_bloodtype_o);

                popup_bloodtype_o.setOnTouchListener(new View.OnTouchListener() {
                    public boolean onTouch(View arg0,MotionEvent arg1) {
                        if (arg1.getAction() == MotionEvent.ACTION_DOWN) {
                            arg0.setBackgroundResource(R.color.female_pressed); //按下的图片对应pressed
                        } else if (arg1.getAction() == MotionEvent.ACTION_UP) {
                            arg0.setBackgroundResource(R.color.female_normal); //常态下的图片对应normal
                        } else{}; //if() //这里还可以继续实现MotionEvent.ACTION_MOVE和MotionEvent.ACTION_CANCEL等实现更多的特效
                        return false;
                    }
                });
                popup_bloodtype_a.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String b = popup_bloodtype_a.getText().toString();
                        cliclkerDispose = new CliclkerDispose(title,context, b);
                        windowBloodtype.dismiss();
                    }
                });

                popup_bloodtype_b.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        String b = popup_bloodtype_b.getText().toString();
                        cliclkerDispose = new CliclkerDispose(title,context, b);
                        windowBloodtype.dismiss();
                    }
                });
                popup_bloodtype_ab.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        String b = popup_bloodtype_ab.getText().toString();
                        cliclkerDispose = new CliclkerDispose(title,context, b);
                        windowBloodtype.dismiss();
                    }
                });
                popup_bloodtype_o.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        String b = popup_bloodtype_o.getText().toString();
                        cliclkerDispose = new CliclkerDispose(title,context, b);
                        windowBloodtype.dismiss();
                    }
                });

                //popWindow消失监听方法
                windowBloodtype.setOnDismissListener(new PopupWindow.OnDismissListener() {

                    @Override
                    public void onDismiss() {
                        //恢复颜色
                        WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
                        lp.alpha = 1f;
                        activity.getWindow().setAttributes(lp);
                        System.out.println("popWindow消失");
                    }
                });
                break;
            default:

                view = inflater.inflate(R.layout.account_pop_window, null);

                popupTitle = (TextView) view.findViewById(R.id.popupTitle);
                popupTitle.setText(title);


                // 下面是两种方法得到宽度和高度 getWindow().getDecorView().getWidth()
                final PopupWindow windowDefault= popWindowHindle(view,activity);

                // 这里检验popWindow里的button是否可以点击
                popupBtn = (TextView) view.findViewById(R.id.popupBtn);
                popupBtn.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {


                        String b = popupBtn.getText().toString();
                        cliclkerDispose = new CliclkerDispose(title,context, b);
                        windowDefault.dismiss();
                    }
                });

                //popWindow消失监听方法
                windowDefault.setOnDismissListener(new PopupWindow.OnDismissListener() {

                    @Override
                    public void onDismiss() {
                        //恢复颜色
                        WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
                        lp.alpha = 1f;
                        activity.getWindow().setAttributes(lp);

                    }
                });
                break;
        }
    }




    private PopupWindow popWindowHindle(View view, Activity activity){
        final PopupWindow window = new PopupWindow(view,
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT);

        // 设置popWindow弹出窗体可点击，这句话必须添加，并且是true
        window.setFocusable(true);


        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0xbbfbfbf);
        window.setBackgroundDrawable(dw);


        // 设置popWindow的显示和消失动画
        window.setAnimationStyle(R.style.popwindow_anim_style);
        // 在底部显示
        window.showAtLocation(this.activity.findViewById(R.id.account_tv_sex),//若findViewById寻找的id不在所寻找的view上 会报 a null object reference （空指针引用）
                Gravity.CENTER, 0, 0);

        // 设置背景颜色变暗
        WindowManager.LayoutParams lp = this.activity.getWindow().getAttributes();
        lp.alpha = 0.5f;
        this.activity.getWindow().setAttributes(lp);
        return window;
    }
    }
