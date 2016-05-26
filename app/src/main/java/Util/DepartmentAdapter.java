package Util;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.com.newhfuu.R;

import java.util.List;

/**
 * Created by LLLLLLL on 5/23/2016.
 */
public class DepartmentAdapter extends ArrayAdapter<String> {
    private int resourceId;
    private int  selectItem=-1;

    public void setSelectItem(int selectItem) {
        this.selectItem = selectItem;
    }

    public DepartmentAdapter(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String text = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,null);
            viewHolder = new ViewHolder();
            viewHolder.textView = (TextView) view.findViewById(R.id.text);
            view.setTag(viewHolder);
        }else{
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.textView.setText(text);
        if (position == selectItem) {               //选中的item字体变为绿色
            viewHolder.textView.setTextColor(convertView.getResources().getColor(R.color.green));
        }
        else {
            viewHolder.textView.setTextColor(Color.GRAY);
        }
        return view;
    }

    private class ViewHolder {
        TextView textView;
    }
}
