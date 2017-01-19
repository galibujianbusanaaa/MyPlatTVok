package myapplication.com.myplattvok.avtivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

import myapplication.com.myplattvok.MainActivity;
import myapplication.com.myplattvok.R;
import myapplication.com.myplattvok.adapter.ListAdapter;
import myapplication.com.myplattvok.bean.ListBean;
import myapplication.com.myplattvok.utils.JsonParseUtlis;

public class Search_Activity extends AppCompatActivity {
    private static final String TAG = "Search_Activity";
    ListView listView;
    TextView textView;
    ImageView imageView;
    String URL="http://www.5781000.co/av/api/get_video_list/player/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        x.Ext.init(getApplication());
        Intent intent=getIntent();
        String player=intent.getStringExtra("player");
        init();
        String url=URL+java.net.URLEncoder.encode(player);
        textView.setText(player);
        RequestParams requestParams=new RequestParams(url);
        Log.i(TAG, "onCreate: "+url);
        requestParams.setAsJsonContent(true);
        x.http().get(requestParams, new Callback.CacheCallback<String>() {
            @Override
            public boolean onCache(String result) {
                return false;
            }

            @Override
            public void onSuccess(String result) {
                List<ListBean> datas= JsonParseUtlis.Jsonforlistbean(result);
                ListAdapter myadapter=new ListAdapter(datas,getApplicationContext(),Search_Activity.this);
                listView.setAdapter(myadapter);
                if(datas.size()!=0){
                    Toast.makeText(getApplicationContext(),"搜索到"+datas.size()+"条数据",Toast.LENGTH_SHORT).show();

                }else if(datas.size()==0){
                    Toast.makeText(getApplicationContext(),"坑！没有搜索到,再试试！",Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Toast.makeText(getApplicationContext(),"搜索失败！",Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });


    }
    public void init(){
        listView= (ListView) findViewById(R.id.listView);
        textView= (TextView) findViewById(R.id.textView_search);
        imageView= (ImageView) findViewById(R.id.image_back);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListBean bean = (ListBean) parent.getItemAtPosition(position);
                String id_player=bean.getId();
                String name_palyer=bean.getPlayer();
                Intent intent = new Intent(Search_Activity.this, Detail_Activity.class);
                intent.putExtra("id",id_player);
                //  intent.putExtra("name",name_palyer);
                startActivity(intent);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Search_Activity.this.finish();
            }
        });

    }
}
