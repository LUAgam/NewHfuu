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

import entity.Attention;

/**
 * Created by LLLLLLL on 5/21/2016.
 */
public class AttentionAdapter extends ArrayAdapter<Attention> {

    private int resourceId;

    public AttentionAdapter(Context context, int resource, List<Attention> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Attention attention = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,null);
            viewHolder = new ViewHolder();
            viewHolder.userMes_name = (TextView) view.findViewById(R.id.userMes_name);
            viewHolder.userMes_position = (TextView) view.findViewById(R.id.userMes_position);
            viewHolder.userMes_hospital = (TextView) view.findViewById(R.id.userMes_hospital);
            viewHolder.userMes_department = (TextView) view.findViewById(R.id.userMes_department);
            viewHolder.userMes_image = (ImageView) view.findViewById(R.id.userMes_image);
            view.setTag(viewHolder);
        }else{
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.userMes_name.setText(attention.getUserMes_name());
        viewHolder.userMes_position.setText(attention.getUserMes_position());
        viewHolder.userMes_hospital.setText(attention.getUserMes_hospital());
        viewHolder.userMes_department.setText(attention.getUserMes_department());
        viewHolder.userMes_image.setImageResource(attention.getUserMes_imageId());
        return view;
    }

    private class ViewHolder {
        TextView userMes_name,userMes_position,userMes_hospital,userMes_department;
        ImageView userMes_image;
    }
}
