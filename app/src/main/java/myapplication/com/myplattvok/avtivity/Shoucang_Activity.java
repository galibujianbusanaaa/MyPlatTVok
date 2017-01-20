package myapplication.com.myplattvok.avtivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import myapplication.com.myplattvok.MainActivity;
import myapplication.com.myplattvok.R;
import myapplication.com.myplattvok.adapter.ShoucangAdapter;
import myapplication.com.myplattvok.bean.Info;
import myapplication.com.myplattvok.bean.InfoDao;

public class Shoucang_Activity extends AppCompatActivity {

    InfoDao infoDao=new InfoDao();
    ListView listView;
    ImageView image_back;
    ShoucangAdapter adapter;
    List<Info>data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoucang);
        listView= (ListView) findViewById(R.id.listView);
        data=infoDao.findAll();
        image_back= (ImageView) findViewById(R.id.image_back);
        image_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Shoucang_Activity.this.finish();
            }
        });
         adapter=new ShoucangAdapter(getApplicationContext(),data);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Info info= (Info) parent.getItemAtPosition(position);
                String id1=info.getId();
                Intent intent=new Intent(Shoucang_Activity.this,Detail_Activity.class);
                intent.putExtra("id",id1);
                startActivity(intent);

            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(final AdapterView<?> parent, View view, final int position, long id) {
                final Info info= (Info) parent.getItemAtPosition(position);
                AlertDialog.Builder localBuilder = new AlertDialog.Builder(Shoucang_Activity.this);
                localBuilder.setTitle("删除选项");
                localBuilder.setIcon(R.mipmap.jinggao);
                localBuilder.setMessage("是否确认删除该收藏?");
                localBuilder.setPositiveButton("确定", new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                    {

                        String Str_id=info.getId();
                        data.remove(info);
                        infoDao.delete(Str_id);
                        adapter.notifyDataSetChanged();
                    }
                });
                localBuilder.setNegativeButton("取消", new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                    {

                    }
                });
                localBuilder.create().show();
                /***/


                return true;
            }
        });
    }
}
