package myapplication.com.myplattvok.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import myapplication.com.myplattvok.R;
import myapplication.com.myplattvok.bean.Info;

/**
 * Created by Administrator on 2017/1/18.
 */

public class ShoucangAdapter extends BaseAdapter{
    Context context;
    List<Info>data;

    public ShoucangAdapter(Context context, List<Info> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if(convertView==null){
            convertView=View.inflate(context, R.layout.shoucangitem_layout,null);
            holder=new ViewHolder();

            holder.textView1= (TextView) convertView.findViewById(R.id.textView1);
            holder.textView2= (TextView) convertView.findViewById(R.id.textView2);
            holder.textView3= (TextView) convertView.findViewById(R.id.textView3);
            convertView.setTag(holder);
        }
        else{
            holder= (ViewHolder) convertView.getTag();
        }
        Info info=data.get(position);
        holder.textView1.setText("编号:"+info.getId());
        holder.textView2.setText("演员:"+info.getPlayer());
        holder.textView3.setText("类型:"+info.getTitle());
        return convertView;
    }
    class ViewHolder{
        TextView textView1,textView2,textView3;
    }
}
