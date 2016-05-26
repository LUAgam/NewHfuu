package com.example.com.newhfuu;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_personal_center,btn_registration,btn_consult,btn_find;
    private Drawable endDra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn_registration = (Button) findViewById(R.id.btn_registration);
        btn_consult = (Button) findViewById(R.id.btn_consult);
        btn_find = (Button) findViewById(R.id.btn_find);
        btn_personal_center = (Button) findViewById(R.id.btn_personal_center);

        btn_registration.setOnClickListener(this);
        btn_consult.setOnClickListener(this);
        btn_find.setOnClickListener(this);
        btn_personal_center.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction beginTransaction =fragmentManager.beginTransaction();


        switch (v.getId()){
            case R.id.btn_registration:
                this.setTitle("首页");
                endDra = getResources().getDrawable(R.drawable.add_66);
                btn_registration.setCompoundDrawablesWithIntrinsicBounds(null,endDra,null,null);
                btn_registration.setTextColor(getResources().getColor(R.color.green));
                endDra = getResources().getDrawable(R.drawable.ic_forum_black_48dp);
                btn_consult.setCompoundDrawablesWithIntrinsicBounds(null,endDra,null,null);
                btn_consult.setTextColor(getResources().getColor(R.color.gray));

                endDra = getResources().getDrawable(R.drawable.ic_remove_red_eye_black_48dp);
                btn_find.setCompoundDrawablesWithIntrinsicBounds(null,endDra,null,null);
                btn_find.setTextColor(getResources().getColor(R.color.gray));

                endDra = getResources().getDrawable(R.drawable.icon_user_normal);
                btn_personal_center.setCompoundDrawablesWithIntrinsicBounds(null,endDra,null,null);
                btn_personal_center.setTextColor(getResources().getColor(R.color.gray));
                beginTransaction.replace(R.id.ll_layout,new RegistrationFragment());
                break;

            case R.id.btn_consult:
                this.setTitle("咨询");
                endDra = getResources().getDrawable(R.drawable.add_7);
                btn_registration.setCompoundDrawablesWithIntrinsicBounds(null,endDra,null,null);
                btn_registration.setTextColor(getResources().getColor(R.color.gray));
                endDra = getResources().getDrawable(R.drawable.ic_remove_red_eye_black_48dp);
                btn_find.setCompoundDrawablesWithIntrinsicBounds(null,endDra,null,null);
                btn_find.setTextColor(getResources().getColor(R.color.gray));
                endDra = getResources().getDrawable(R.drawable.ic_forum_black_48dp_other);
                btn_consult.setCompoundDrawablesWithIntrinsicBounds(null,endDra,null,null);
                btn_consult.setTextColor(getResources().getColor(R.color.green));
                endDra = getResources().getDrawable(R.drawable.icon_user_normal);
                btn_personal_center.setCompoundDrawablesWithIntrinsicBounds(null,endDra,null,null);
                btn_personal_center.setTextColor(getResources().getColor(R.color.gray));
                beginTransaction.replace(R.id.ll_layout,new ConsultFragment());
                break;

            case R.id.btn_find:
                this.setTitle("发现");
                endDra = getResources().getDrawable(R.drawable.add_7);
                btn_registration.setCompoundDrawablesWithIntrinsicBounds(null,endDra,null,null);
                btn_registration.setTextColor(getResources().getColor(R.color.gray));

                endDra = getResources().getDrawable(R.drawable.ic_remove_red_eye_black_48dp_other);
                btn_find.setCompoundDrawablesWithIntrinsicBounds(null,endDra,null,null);
                btn_find.setTextColor(getResources().getColor(R.color.green));

                endDra = getResources().getDrawable(R.drawable.ic_forum_black_48dp);
                btn_consult.setCompoundDrawablesWithIntrinsicBounds(null,endDra,null,null);
                btn_consult.setTextColor(getResources().getColor(R.color.gray));
                endDra = getResources().getDrawable(R.drawable.icon_user_normal);
                btn_personal_center.setCompoundDrawablesWithIntrinsicBounds(null,endDra,null,null);
                btn_personal_center.setTextColor(getResources().getColor(R.color.gray));
                break;

            case R.id.btn_personal_center:
                this.setTitle("");
                endDra = getResources().getDrawable(R.drawable.add_7);
                btn_registration.setCompoundDrawablesWithIntrinsicBounds(null,endDra,null,null);
                btn_registration.setTextColor(getResources().getColor(R.color.gray));
                endDra = getResources().getDrawable(R.drawable.ic_remove_red_eye_black_48dp);
                btn_find.setCompoundDrawablesWithIntrinsicBounds(null,endDra,null,null);
                btn_find.setTextColor(getResources().getColor(R.color.gray));
                endDra = getResources().getDrawable(R.drawable.ic_forum_black_48dp);
                btn_consult.setCompoundDrawablesWithIntrinsicBounds(null,endDra,null,null);
                btn_consult.setTextColor(getResources().getColor(R.color.gray));
                endDra = getResources().getDrawable(R.drawable.icon_user_pressedd);
                btn_personal_center.setCompoundDrawablesWithIntrinsicBounds(null,endDra,null,null);
                btn_personal_center.setTextColor(getResources().getColor(R.color.green));
                beginTransaction.replace(R.id.ll_layout, new PersonalCenterFragment());
                break;


            default:
                break;
        }
            beginTransaction.commit();
    }
}
