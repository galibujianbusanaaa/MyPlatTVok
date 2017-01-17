package myapplication.com.myplattvok.utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import myapplication.com.myplattvok.bean.Bean;
import myapplication.com.myplattvok.bean.ChankanListbena;
import myapplication.com.myplattvok.bean.ListBean;


/**
 * Created by Administrator on 2016/10/26.
 */
public class JsonParseUtlis {

    public  static List<ListBean>  Jsonforlistbean(String str)  {
        List<ListBean> datas=new ArrayList<>();
        try {
            JSONObject jsonObject=new JSONObject(str);
            JSONArray array=jsonObject.optJSONArray("rows");
            for(int i=0;i<array.length();i++){
                JSONObject jsonObject1=array.optJSONObject(i);
                String title=jsonObject1.optString("title");
                String player=jsonObject1.optString("player");
                String up_time=jsonObject1.optString("up_time");
                String category=jsonObject1.optString("category");
                String id=jsonObject1.optString("id");
                String cover=jsonObject1.optString("cover");
            //  datas.add(new ListBean(title,player,up_time,category,id,cover));
                datas.add(new ListBean(title,player,up_time,category,id,cover));


            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return  datas;
    }

    public static List<ChankanListbena> Jsonforchakan(String str){

        List<ChankanListbena> datas=new ArrayList<>();
        try {
            JSONObject jsonObject=new JSONObject(str);
            JSONArray array=jsonObject.optJSONArray("rows");
            for(int i=0;i<array.length();i++){
                JSONObject jsonObject1=array.getJSONObject(i);
                String title=jsonObject1.optString("title");
                String sys_ctime=jsonObject1.optString("sys_ctime");
                String barcode=jsonObject1.optString("barcode");

                String id=jsonObject1.optString("id");
                String cover=jsonObject1.optString("cover");
          datas.add(new ChankanListbena(id,title,cover,sys_ctime,barcode));


            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return  datas;
    }

    public static Bean Jsonforbean(String str){
        Bean bean=null;
        try {
            System.out.println("xi**1");
            JSONObject object=new JSONObject(str);
            System.out.println("xi**2");

            String id=object.optString("id");
            System.out.println("xi**3");
            String title=object.optString("title");
            System.out.println("xi**4");
            String player=object.optString("player");
            System.out.println("xi**5");
            String play_conver=object.optString("play_conver");
            System.out.println("xi**6");
            String sys_ctime =object.optString("sys_ctime");
            System.out.println("xi**7");
            JSONArray array=object.optJSONArray("play_list");
            String play_list_0= (String) array.get(0);

            String play_list_1=(String) array.get(1);
            String play_list_2=(String) array.get(2);
            String play_list_3=(String) array.get(3);
            String play_list_4=(String) array.get(4);
            String play_list_5=(String) array.get(5);
            bean=new Bean(id,title,play_list_5,player,sys_ctime,play_conver,play_list_0,play_list_1,play_list_2,play_list_3,play_list_4);



        } catch (JSONException e) {
            e.printStackTrace();
        }
        return bean;

    }
}
