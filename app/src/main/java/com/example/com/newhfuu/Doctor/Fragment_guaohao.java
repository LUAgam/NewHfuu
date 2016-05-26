package com.example.com.newhfuu.Doctor;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.com.newhfuu.R;

import java.util.ArrayList;
import java.util.List;

import Util.DepartmentOfDocAdapter;
import entity.AdapterDocVisit;
import entity.BundleRegistertion;

/**
 * Created by Creat on 2016/5/21.
 */
public class Fragment_guaohao extends Fragment implements  AdapterView.OnItemClickListener {
    private PopupWindow popWindow;

    private TextView department_name,hospital_name;
    private Bundle bunble;
    private BundleRegistertion bundleRegistertion;
    private ListView listview;
    private List<AdapterDocVisit> list = new ArrayList<AdapterDocVisit>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_guahao, null);
       /* Button btn_yuyue = (Button) view.findViewById(R.id.btn_yuyue);
        Button btn_yuyue2 = (Button) view.findViewById(R.id.btn_yuyue2);

        btn_yuyue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupWindow();
            }
        });

        btn_yuyue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupWindow();
            }
        });*/

        init(view);         // TODO: 5/25/2016 初始化组件


        return view;
    }

    private void init(View view) {
        department_name = (TextView) view.findViewById(R.id.department_name);               //科室名称
        hospital_name = (TextView) view.findViewById(R.id.hospital_name);                  //医院名称
        listview= (ListView) view.findViewById(R.id.listview);

        bunble = getActivity().getIntent().getBundleExtra("registertion");
        bundleRegistertion = bunble.getParcelable("bundleRegistertion");
        department_name.setText(bundleRegistertion.getDepartment().toString());
        hospital_name.setText(bundleRegistertion.getHospital().toString());


        initList();
        DepartmentOfDocAdapter departmentOfDocAdapter = new DepartmentOfDocAdapter(getActivity(),R.layout.simple_list_item_2,list);
        listview.setAdapter(departmentOfDocAdapter);
        listview.setOnItemClickListener(this);
    }

    private void initList() {
        AdapterDocVisit adapterDocVisit = new AdapterDocVisit("2016-05-30","上午","0","15");
        list.add(adapterDocVisit);
        AdapterDocVisit adapterDocVisit1 = new AdapterDocVisit("2016-05-30","下午","0","15");
        list.add(adapterDocVisit1);
        AdapterDocVisit adapterDocVisit2 = new AdapterDocVisit("2016-05-31","上午","5","15");
        list.add(adapterDocVisit2);
        AdapterDocVisit adapterDocVisit3 = new AdapterDocVisit("2016-05-31","下午","5","15");
        list.add(adapterDocVisit3);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(getActivity(),SureinfoActivity.class);
        bundleRegistertion.setTime(list.get(position).getText_time());
        bundleRegistertion.setTimeOfDay(list.get(position).getText_timeOfday());
        bundleRegistertion.setCost("0.00");
        TextView userMes_name_1 = (TextView) getActivity().findViewById(R.id.userMes_name_1);
        bundleRegistertion.setDoctorType(userMes_name_1.getText().toString().trim());
        bunble = new Bundle();
        bunble.putParcelable("bundleRegistertion",bundleRegistertion);
        intent.putExtra("registertion",bunble);
        startActivity(intent);
    }

  /*  private void showPopupWindow() {
        //设置contentView
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.popwindow_layout, null);
        PopupWindow mPopupWindow = new PopupWindow(view, 400, LinearLayoutCompat.LayoutParams.WRAP_CONTENT);
        // mPopupWindow.setBackgroundDrawable(new
        // BitmapDrawable());//必须设置background才能消失
        mPopupWindow.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg2));
//        mPopupWindow.setOutsideTouchable(true);

        Button button1 = (Button) view.findViewById(R.id.button1);
        Button button2 = (Button) view.findViewById(R.id.button2);
        Button button3 = (Button) view.findViewById(R.id.button3);
        Button button4 = (Button) view.findViewById(R.id.button4);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);

        // 自定义动画
        // mPopupWindow.setAnimationStyle(R.style.PopupAnimation);
        // 使用系统动画
        mPopupWindow.setAnimationStyle(android.R.style.Animation_Dialog);
        mPopupWindow.update();
        mPopupWindow.setTouchable(true);
        mPopupWindow.setFocusable(true);

        if (!mPopupWindow.isShowing()) {
            // mPopupWindow.showAsDropDown(view,0,0);
//            mPopupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
            mPopupWindow.showAsDropDown(view);
        }//显示 popupwindow
    }*/

/*    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1: {
                Intent intent = new Intent(getActivity(),SureinfoActivity.class);
                startActivity(intent);
            }
            break;

            case R.id.button2:{
                Toast.makeText(getActivity(),"您预约在下午",Toast.LENGTH_SHORT).show();
            }
            break;

            case R.id.button3:{
                Toast.makeText(getActivity(),"您预约在上午",Toast.LENGTH_SHORT).show();
            }
            break;

            case R.id.button4:{
                Toast.makeText(getActivity(),"您预约在下午",Toast.LENGTH_SHORT).show();
            }
            break;
        }
    }*/
}
