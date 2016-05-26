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

import entity.Consult;

/**
 * Created by LLLLLLL on 5/14/2016.
 */
public class ConsultAdapter extends ArrayAdapter<Consult> {
    private int resourceId;
    public ConsultAdapter(Context context, int resource, List<Consult> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Consult consult = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,null);
            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView) view.findViewById(R.id.imageView);
            viewHolder.textView = (TextView) view.findViewById(R.id.consultName);
            view.setTag(viewHolder);
        }else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.imageView.setImageResource(consult.getImageID());
        viewHolder.textView.setText(consult.getName());
        return view;
    }

     static  class ViewHolder  {
        ImageView imageView;
        TextView textView;


    }
}
