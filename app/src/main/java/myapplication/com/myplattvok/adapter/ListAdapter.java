package myapplication.com.myplattvok.adapter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import myapplication.com.myplattvok.R;
import myapplication.com.myplattvok.bean.ListBean;


/**
 * Created by Administrator on 2016/10/26.
 */
public class ListAdapter extends BaseAdapter {
    List<ListBean>datas;
    Context context;
    Activity activity;

    public ListAdapter(List<ListBean> datas, Context context, Activity activity) {
        this.datas = datas;
        this.context = context;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if(convertView==null){
            convertView=View.inflate(context, R.layout.mainitem_layout,null);
            holder=new ViewHolder();
            holder.imageView= (ImageView) convertView.findViewById(R.id.image);
            holder.textView1= (TextView) convertView.findViewById(R.id.title);
            holder.textView2= (TextView) convertView.findViewById(R.id.player);
            holder.textView3= (TextView) convertView.findViewById(R.id.category);
            holder.textView4= (TextView) convertView.findViewById(R.id.up_time);
            convertView.setTag(holder);
        }
        else{
            holder= (ViewHolder) convertView.getTag();
        }
        ListBean bean=datas.get(position);
        String title=bean.getTitle();
        String player=bean.getPlayer();
        String category=bean.getCategory();
        String up_time=bean.getUp_time();
        String cover=bean.getCover();
        if(!TextUtils.isEmpty(cover)){
            Picasso.with(activity.getApplicationContext()).load(cover).resize(150, 150).centerCrop().into(holder.imageView);

        }
        holder.textView1.setText(""+title);
        if(!TextUtils.isEmpty(player)){
            holder.textView2.setText("演员："+player);
        }else {
            holder.textView2.setText("");

        }
        if(!TextUtils.isEmpty(category)){
            holder.textView3.setText("类型:"+category);
        }else {
            holder.textView3.setText("");
        }


        holder.textView4.setText("更新时间:"+up_time);
     System.out.println("***"+title);

        return convertView;
    }
    class ViewHolder{
        ImageView imageView;
        TextView textView1,textView2,textView3,textView4;

    }
}
