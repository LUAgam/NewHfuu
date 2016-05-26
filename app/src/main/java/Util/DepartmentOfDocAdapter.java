package Util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.com.newhfuu.R;

import java.util.List;

import entity.AdapterDocVisit;

/**
 * Created by LLLLLLL on 5/25/2016.
 */
public class DepartmentOfDocAdapter extends ArrayAdapter<AdapterDocVisit> {
    private int resourceId;

    public DepartmentOfDocAdapter(Context context, int resource, List<AdapterDocVisit> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        AdapterDocVisit adapterDocVisit = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,null);
            viewHolder = new ViewHolder();
            viewHolder.text_time = (TextView) view.findViewById(R.id.text_time);
            viewHolder.text_timeOfday = (TextView) view.findViewById(R.id.text_timeOfday);
            viewHolder.text_preNum = (TextView) view.findViewById(R.id.text_preNum);
            viewHolder.text_totalNum = (TextView) view.findViewById(R.id.text_totalNum);
            view.setTag(viewHolder);
        }else{
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.text_time.setText(adapterDocVisit.getText_time());
        viewHolder.text_timeOfday.setText(adapterDocVisit.getText_timeOfday());
        viewHolder.text_preNum.setText(adapterDocVisit.getText_preNum());
        viewHolder.text_totalNum.setText(adapterDocVisit.getText_totalNum());
        return view;
    }

    private class ViewHolder {
        TextView text_time,text_timeOfday,text_preNum,text_totalNum;
    }
}
