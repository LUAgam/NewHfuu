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

import entity.Hospital;

/**
 * Created by LLLLLLL on 5/23/2016.
 */
public class HospitalAdapter extends ArrayAdapter<Hospital> {
    private int resourceId;

    public HospitalAdapter(Context context, int resource, List<Hospital> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Hospital hospital = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,null);
            viewHolder = new ViewHolder();
            viewHolder.hospital_name = (TextView) view.findViewById(R.id.hospital_name);
            viewHolder.hospital_regisNum = (TextView) view.findViewById(R.id.hospital_regisNum);
            viewHolder.hospital_imageID = (ImageView) view.findViewById(R.id.hospital_imageID);
            view.setTag(viewHolder);
        }else{
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.hospital_name.setText(hospital.getHospital_name());
        viewHolder.hospital_regisNum.setText(hospital.getHospital_regisNum()+"");
        viewHolder.hospital_imageID.setImageResource(hospital.getHospital_imageID());
        return view;
    }

    private class ViewHolder {
        TextView hospital_name,hospital_regisNum;
        ImageView hospital_imageID;
    }
}
