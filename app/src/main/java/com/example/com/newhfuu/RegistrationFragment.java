package com.example.com.newhfuu;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.com.newhfuu.registration.Consult_doctorActivity;
import com.example.com.newhfuu.registration.GynecologicalActivity;
import com.example.com.newhfuu.registration.RegistrationActivity;
import com.example.com.newhfuu.registration.Sickness_advanceActivity;
import com.example.com.newhfuu.registration.Subsequent_visitActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Creat on 2016/4/23.
 */
public class RegistrationFragment extends Fragment implements View.OnClickListener {

    private ViewPager viewPager;
    private List<ImageView> imageViews;

    private String[] titles;
    private int[] imageResId;
    private List<View> dots;

    private TextView tv_title;
    private int currentItem = 0;

    private ScheduledExecutorService scheduledExecutorService;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            viewPager.setCurrentItem(currentItem);
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        预约挂号的点击事件
        View view = inflater.inflate(R.layout.fragment_registration,null);


        imageResId = new int[]{R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e};
        titles = new String[imageResId.length];
        titles[0] = "巩俐不低俗，我就不能低俗";
        titles[1] = "扑树又回来啦！再唱经典老歌引万人大合唱";
        titles[2] = "揭秘北京电影如何升级";
        titles[3] = "乐视网TV版大派送";
        titles[4] = "热血屌丝的反杀";

        imageViews = new ArrayList<>();
        for(int i=0;i<imageResId.length;i++){
            ImageView imageView = new ImageView(getActivity());
            imageView.setImageResource(imageResId[i]);
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            imageViews.add(imageView);
        }

        dots = new ArrayList<>();
        dots.add(view.findViewById(R.id.v_dot0));
        dots.add(view.findViewById(R.id.v_dot1));
        dots.add(view.findViewById(R.id.v_dot2));
        dots.add(view.findViewById(R.id.v_dot3));
        dots.add(view.findViewById(R.id.v_dot4));

        tv_title = (TextView) view.findViewById(R.id.tv_title);
        tv_title.setText(titles[0]);

        viewPager = (ViewPager) view.findViewById(R.id.vp);
        viewPager.setAdapter(new MyAdapter());
        viewPager.setOnPageChangeListener(new MyPageChangeListener());


        view.findViewById(R.id.ll_yuyueguahao).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RegistrationActivity.class);
                startActivity(intent);
            }
        });


//        咨询医生的点击事件
        view.findViewById(R.id.rl_zixunyisheng).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Consult_doctorActivity.class);
                startActivity(intent);
            }
        });

//        疾病导诊点击事件
        view.findViewById(R.id.tv_jbdz).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Sickness_advanceActivity.class);
                startActivity(intent);
            }
        });

//        预约复诊的点击事件

        view.findViewById(R.id.tv_yyfz).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Subsequent_visitActivity.class);
                startActivity(intent);
            }
        });

//        热门科室的点击事件
        Button btn_gynecological = (Button) view.findViewById(R.id.btn_gynecological);             //妇科
        Button btn_obstetrics = (Button) view.findViewById(R.id.btn_obstetrics);                   //产科
        Button btn_pediatrics = (Button) view.findViewById(R.id.btn_pediatrics);                   //儿科
        Button btn_TCM = (Button) view.findViewById(R.id.btn_TCM);                                  //中医科
        Button btn_gastroenterology = (Button) view.findViewById(R.id.btn_gastroenterology);      //消化内科
        Button btn_ophthalmic = (Button) view.findViewById(R.id.btn_ophthalmic);                   //眼科
        Button btn_dermatology = (Button) view.findViewById(R.id.btn_dermatology);                //皮肤科
        Button btn_other = (Button) view.findViewById(R.id.btn_other);                             //其他

        btn_gynecological.setOnClickListener(this);
        btn_obstetrics.setOnClickListener(this);
        btn_pediatrics.setOnClickListener(this);
        btn_TCM.setOnClickListener(this);
        btn_gastroenterology.setOnClickListener(this);
        btn_ophthalmic.setOnClickListener(this);
        btn_dermatology.setOnClickListener(this);
        btn_other.setOnClickListener(this);
        return view;
    }

    @Override
    //用来实现上述科室的点击事件
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_gynecological:
                Intent intent = new Intent(getActivity(), GynecologicalActivity.class);
                startActivity(intent);
                break;

            case R.id.btn_obstetrics:
                Intent intent1 = new Intent(getActivity(), GynecologicalActivity.class);
                startActivity(intent1);
                break;

            case R.id.btn_pediatrics:
                Intent intent2 = new Intent(getActivity(), GynecologicalActivity.class);
                startActivity(intent2);
                break;

            case R.id.btn_TCM:
                Intent intent3= new Intent(getActivity(), GynecologicalActivity.class);
                startActivity(intent3);
                break;

            case R.id.btn_gastroenterology:
                Intent intent4 = new Intent(getActivity(), GynecologicalActivity.class);
                startActivity(intent4);
                break;

            case R.id.btn_ophthalmic:
                Intent intent5 = new Intent(getActivity(), GynecologicalActivity.class);
                startActivity(intent5);
                break;

            case R.id.btn_dermatology:
                Intent intent6 = new Intent(getActivity(), GynecologicalActivity.class);
                startActivity(intent6);
                break;

            case R.id.btn_other:
                Intent intent7 = new Intent(getActivity(), GynecologicalActivity.class);
                startActivity(intent7);
                break;

            default:

                break;
        }

    }

    @Override
    public void onStart() {
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        // 当Activity显示出来后，每两秒钟切换一次图片显示
        scheduledExecutorService.scheduleAtFixedRate(new ScrollTask(), 1, 4, TimeUnit.SECONDS);
        super.onStart();
    }

    @Override
    public void onStop() {
        // 当Activity不可见的时候停止切换
        scheduledExecutorService.shutdown();
        super.onStop();
    }

    /**
     * 换行切换任务
     *
     * @author Administrator
     *
     */
    private class ScrollTask implements Runnable {

        public void run() {
            synchronized (viewPager) {
                System.out.println("currentItem: " + currentItem);
                currentItem = (currentItem + 1) % imageViews.size();
                handler.obtainMessage().sendToTarget(); // 通过Handler切换图片
            }
        }

    }

    /**
     * 当ViewPager中页面的状态发生改变时调用
     *
     * @author Administrator
     *
     */
    private class MyPageChangeListener implements ViewPager.OnPageChangeListener {
        private int oldPosition = 0;

        /**
         * This method will be invoked when a new page becomes selected.
         * position: Position index of the new selected page.
         */
        public void onPageSelected(int position) {
            currentItem = position;
            tv_title.setText(titles[position]);
            dots.get(oldPosition).setBackgroundResource(R.drawable.dot_normal);
            dots.get(position).setBackgroundResource(R.drawable.dot_focused);
            oldPosition = position;
        }

        public void onPageScrollStateChanged(int arg0) {

        }

        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }
    }

    /**
     * 填充ViewPager页面的适配器
     *
     * @author Administrator
     *
     */
    private class MyAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return imageResId.length;
        }

        @Override
        public Object instantiateItem(View arg0, int arg1) {
            ((ViewPager) arg0).addView(imageViews.get(arg1));
            return imageViews.get(arg1);
        }

        @Override
        public void destroyItem(View arg0, int arg1, Object arg2) {
            ((ViewPager) arg0).removeView((View) arg2);
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public void restoreState(Parcelable arg0, ClassLoader arg1) {

        }

        @Override
        public Parcelable saveState() {
            return null;
        }

        @Override
        public void startUpdate(View arg0) {

        }

        @Override
        public void finishUpdate(View arg0) {

        }
    }



}
