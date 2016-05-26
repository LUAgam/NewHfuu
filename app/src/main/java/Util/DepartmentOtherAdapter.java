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

import entity.Doctor;

/**
 * Created by LLLLLLL on 5/24/2016.
 */
public class DepartmentOtherAdapter extends ArrayAdapter<Doctor> {
    private int resourceId;

    public DepartmentOtherAdapter(Context context, int resource, List<Doctor> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Doctor doctor = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,null);
            viewHolder = new ViewHolder();
            viewHolder.doctorInfo_name = (TextView) view.findViewById(R.id.doctorInfo_name);
            viewHolder.doctorInfo_position = (TextView) view.findViewById(R.id.doctorInfo_position);
            viewHolder.doctorInfo_disease = (TextView) view.findViewById(R.id.doctorInfo_disease);
            viewHolder.doctorInfo_num = (TextView) view.findViewById(R.id.doctorinfo_num);
            viewHolder.doctorInfo_photoID = (ImageView) view.findViewById(R.id.doctorInfo_photoID);
            view.setTag(viewHolder);
        }else{
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.doctorInfo_name.setText(doctor.getDoctorInfo_name());
        viewHolder.doctorInfo_position.setText(doctor.getDoctorInfo_position());
        viewHolder.doctorInfo_disease.setText(doctor.getDoctorInfo_disease());
        viewHolder.doctorInfo_num.setText(doctor.getDoctorInfo_num()+"");
        viewHolder.doctorInfo_photoID.setImageResource(doctor.getDoctorInfo_photoID());
        /*if (position == selectItem) {               //选中的item字体变为绿色
            viewHolder.textView.setTextColor(convertView.getResources().getColor(R.color.green));
        }
        else {
            viewHolder.textView.setTextColor(Color.GRAY);
        }*/
        return view;
    }

    private class ViewHolder {
        TextView doctorInfo_name,doctorInfo_position,doctorInfo_disease,doctorInfo_num;
        ImageView doctorInfo_photoID;
    }
}
