package myapplication.com.myplattvok;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

import myapplication.com.myplattvok.adapter.ListAdapter;
import myapplication.com.myplattvok.avtivity.Aboutme_Activity;
import myapplication.com.myplattvok.avtivity.Detail_Activity;
import myapplication.com.myplattvok.avtivity.Search_Activity;
import myapplication.com.myplattvok.avtivity.Shoucang_Activity;
import myapplication.com.myplattvok.bean.Constant;
import myapplication.com.myplattvok.bean.ListBean;
import myapplication.com.myplattvok.utils.JsonParseUtlis;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "MainActivity";
    String tag="galitv";
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        x.Ext.init(getApplication());
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RequestParams requestParams = new RequestParams(Constant.HOME_URL);
                requestParams.setAsJsonContent(true);
                x.http().get(requestParams,new A());
                Snackbar.make(view, "重新加载数据中……", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        init();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//        if (id == R.id.action_seted) {
//
//
//        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Intent intent=new Intent(MainActivity.this, Shoucang_Activity.class);
            startActivity(intent);

        } else if (id == R.id.nav_gallery) {
            /**
             *搜索功能
             * */
            AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
            localBuilder.setTitle("搜索框").setIcon(R.mipmap.search);
           final View view=getLayoutInflater().inflate(R.layout.search_alert_layout, null);
            localBuilder.setView(view);
            localBuilder.setPositiveButton("确定", new DialogInterface.OnClickListener()
            {
                public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                    EditText editText= (EditText) view.findViewById(R.id.edit_search);
                    if(TextUtils.isEmpty(editText.getText().toString().toString())){
                        Toast.makeText(MainActivity.this, "演员不能为空!", Toast.LENGTH_SHORT).show();

                    }else {
                        Intent intent=new Intent(MainActivity.this, Search_Activity.class);
                        intent.putExtra("player",editText.getText().toString().trim());
                        startActivity(intent);

                    }
                }
            }).setNegativeButton("取消", new DialogInterface.OnClickListener()
            {
                public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                }
            }).create().show();

        } else if (id == R.id.nav_slideshow) {
            /**
             * 欧美分类
             * */
            Intent intent=new Intent(MainActivity.this, Search_Activity.class);
            intent.putExtra("player","欧美");
            startActivity(intent);

        } else if (id == R.id.nav_manage) {

            Intent intent=new Intent(MainActivity.this, Search_Activity.class);
            intent.putExtra("player","國產");
            startActivity(intent);
        } else if (id == R.id.nav_share) {
            Toast.makeText(getApplicationContext(),"不可分享!",Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_send) {
            Intent intent=new Intent(MainActivity.this, Aboutme_Activity.class);
            startActivity(intent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void init(){

        listView= (ListView) findViewById(R.id.content_main).findViewById(R.id.listView);
        RequestParams requestParams = new RequestParams(Constant.HOME_URL);
        requestParams.setAsJsonContent(true);
        x.http().get(requestParams,new A());
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ListBean bean = (ListBean) parent.getItemAtPosition(position);
                String id_player=bean.getId();
                String name_palyer=bean.getPlayer();
                Intent intent = new Intent(MainActivity.this, Detail_Activity.class);
                intent.putExtra("id",id_player);
              //  intent.putExtra("name",name_palyer);
                startActivity(intent);
            }
        });
    }

    class A implements Callback.CommonCallback<String>{
        @Override
        public void onSuccess(String result) {
            try {
                Log.d(TAG, "onSuccess: "+result);

                List<ListBean> datas= JsonParseUtlis.Jsonforlistbean(result);
                ListAdapter myadapter=new ListAdapter(datas,getApplicationContext(),MainActivity.this);
                listView.setAdapter(myadapter);
            } catch (Exception e) {
                e.printStackTrace();
            }




        }
        @Override
        public void onError(Throwable ex, boolean isOnCallback) {
            Log.d(TAG, "onError: "+ex.toString());
        }
        @Override
        public void onCancelled(Callback.CancelledException cex) {
        }
        @Override
        public void onFinished() {
        }
    }
}
