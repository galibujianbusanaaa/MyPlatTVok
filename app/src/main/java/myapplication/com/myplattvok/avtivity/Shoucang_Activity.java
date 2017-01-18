package myapplication.com.myplattvok.avtivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.List;

import myapplication.com.myplattvok.R;
import myapplication.com.myplattvok.adapter.ShoucangAdapter;
import myapplication.com.myplattvok.bean.Info;
import myapplication.com.myplattvok.bean.InfoDao;

public class Shoucang_Activity extends AppCompatActivity {

    InfoDao infoDao=new InfoDao();
    ListView listView;
    ImageView image_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoucang);
        listView= (ListView) findViewById(R.id.listView);
        List<Info>data=infoDao.findAll();
        image_back= (ImageView) findViewById(R.id.image_back);
        image_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Shoucang_Activity.this.finish();
            }
        });
        ShoucangAdapter adapter=new ShoucangAdapter(getApplicationContext(),data);
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
    }
}
