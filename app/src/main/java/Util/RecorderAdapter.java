package Util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.com.newhfuu.R;

import java.util.List;

import entity.Recorder;

/**
 * Created by LLLLLLL on 5/20/2016.
 */
public class RecorderAdapter extends ArrayAdapter<Recorder>{
    private int resourceId;


    public RecorderAdapter(Context context, int resource, List<Recorder> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Recorder recorder = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,null);
            viewHolder = new ViewHolder();
            viewHolder.userMes_num = (TextView) view.findViewById(R.id.userMes_num);
            viewHolder.userMes_state = (TextView) view.findViewById(R.id.userMes_state);
            viewHolder.userMes_name = (TextView) view.findViewById(R.id.userMes_name);
            viewHolder.userMes_position = (TextView) view.findViewById(R.id.userMes_position);
            viewHolder.userMes_hospital = (TextView) view.findViewById(R.id.userMes_hospital);
            viewHolder.userMes_department = (TextView) view.findViewById(R.id.userMes_department);
            viewHolder.userMes_Uname = (TextView) view.findViewById(R.id.userMes_Uname);
            viewHolder.userMes_cost = (TextView) view.findViewById(R.id.userMes_cost);
            viewHolder.userMes_time = (TextView) view.findViewById(R.id.userMes_time);
            viewHolder.userMes_image = (ImageView) view.findViewById(R.id.userMes_image);
            view.setTag(viewHolder);
        }else{
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.userMes_num.setText(recorder.getUserMes_num());
        viewHolder.userMes_state.setText(recorder.getUserMes_state());
        viewHolder.userMes_name.setText(recorder.getUserMes_name());
        viewHolder.userMes_position.setText(recorder.getUserMes_position());
        viewHolder.userMes_hospital.setText(recorder.getUserMes_hospital());
        viewHolder.userMes_department.setText(recorder.getUserMes_department());
        viewHolder.userMes_Uname.setText(recorder.getUserMes_Uname());
        viewHolder.userMes_cost.setText(recorder.getUserMes_cost());
        viewHolder.userMes_time.setText(recorder.getUserMes_time());
        viewHolder.userMes_image.setImageResource(recorder.getUserMes_image());
        return view;
    }

    private class ViewHolder {
        TextView userMes_num,userMes_state,userMes_name,userMes_position,userMes_hospital,userMes_department,userMes_Uname,userMes_cost,userMes_time;
        ImageView userMes_image;
    }
}
