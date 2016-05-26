package com.example.com.newhfuu;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.com.newhfuu.Consult.ConsultActivity;
import com.example.com.newhfuu.personal_center.AttentionActivity;
import com.example.com.newhfuu.personal_center.CircleImageView;
import com.example.com.newhfuu.personal_center.PersonalClicker;
import com.example.com.newhfuu.personal_center.RecorderNowActivity;

import java.util.ArrayList;
import java.util.List;

import Util.MenuAdapter;

/**
 * Created by woshi on 2016/4/24.
 */
public class PersonalCenterFragment extends Fragment implements AdapterView.OnItemClickListener {

    View view;
    LinearLayout account,about,manage,recorderHistory,recorderNow;
    CircleImageView imageView;
    PersonalClicker personalClicker;
    private LinearLayout myData,cardMan;
    private ListView listView_function;
    private List<entity.Menu> list = new ArrayList<entity.Menu>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       view = inflater.inflate(R.layout.fragment_personal_center,null);
        setHasOptionsMenu(true);
        initList();    // 初始化菜单的list
        init();
        onClick();
        return view;
    }

    private void initList() {
        entity.Menu menu = new entity.Menu("我的挂号",R.drawable.order);
        list.add(menu);
        entity.Menu menu7= new entity.Menu("我的关注",R.drawable.customers);
        list.add(menu7);
        entity.Menu menu1 = new entity.Menu("我的检查",R.drawable.order_1);
        list.add(menu1);
        entity.Menu menu6 = new entity.Menu("我的咨询",R.drawable.communication);
        list.add(menu6);
        entity.Menu menu2 = new entity.Menu("我的病历",R.drawable.library);
        list.add(menu2);
        entity.Menu menu3 = new entity.Menu("药品使用清单",R.drawable.donate);
        list.add(menu3);
        entity.Menu menu4 = new entity.Menu("支付中心",R.drawable.billing);
        list.add(menu4);
        entity.Menu menu5 = new entity.Menu("评价中心",R.drawable.consulting);
        list.add(menu5);
        entity.Menu menu8 = new entity.Menu("帮助与反馈",R.drawable.collaboration);
        list.add(menu8);
        entity.Menu menu9 = new entity.Menu("设置",R.drawable.settings);
        list.add(menu9);
    }

    private void onClick() {
        //about.setOnClickListener(personalClicker);
        account.setOnClickListener(personalClicker);
        //recorderHistory.setOnClickListener(personalClicker);
        //recorderNow.setOnClickListener(personalClicker);
        //manage.setOnClickListener(personalClicker);
        imageView.setOnClickListener(personalClicker);
        myData.setOnClickListener(personalClicker);
        cardMan.setOnClickListener(personalClicker);
    }

    private void init() {
        personalClicker = new PersonalClicker(getActivity());
        //about = (LinearLayout) view.findViewById(R.id.About);
        account = (LinearLayout) view.findViewById(R.id.Account);
        /*recorderHistory = (LinearLayout) view.findViewById(R.id.N_Recorder);
        recorderNow = (LinearLayout) view.findViewById(R.id.C_Recorder);
        manage = (LinearLayout) view.findViewById(R.id.J_Manage);*/
        imageView = (CircleImageView) view.findViewById(R.id.User_Image);
        myData = (LinearLayout) view.findViewById(R.id.myData);         //个人资料
        cardMan = (LinearLayout) view.findViewById(R.id.cardMan);       //就诊卡管理
        listView_function = (ListView) view.findViewById(R.id.listView_function);
        MenuAdapter menuAdapter = new MenuAdapter(getActivity(),R.layout.main_menu,list);
        listView_function.setAdapter(menuAdapter);
        listView_function.setOnItemClickListener(this);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.add("设置").setIcon(android.R.drawable.ic_lock_power_off).setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);  //在标题栏增加按钮
        /*MenuItem item1 = menu.add(0, 1, 0, "设置");
        item1.setIcon(android.R.drawable.ic_menu_set_as);*/
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(getActivity(), "注销账号", Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent ;
        switch (list.get(position).getName()){
            case "我的挂号":
                intent = new Intent(getActivity(), RecorderNowActivity.class);
                startActivity(intent);
                break;
            case "我的咨询":
                intent = new Intent(getActivity(), ConsultActivity.class);
                startActivity(intent);
                break;
            case "我的关注":
                intent = new Intent(getActivity(), AttentionActivity.class);
                startActivity(intent);
                break;
        }
    }
}
