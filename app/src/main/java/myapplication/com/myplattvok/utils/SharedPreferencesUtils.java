package myapplication.com.myplattvok.utils;

/**
 * Created by Administrator on 2017/1/20.
 */


import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2016/8/9.
 */
public class SharedPreferencesUtils {


    private  static String NAME="share_data";
    public static  void  setParam(Context context, String key, Object object){
        SharedPreferences p=context.getSharedPreferences(NAME,Context.MODE_APPEND);
        String type=object.getClass().getSimpleName();
        SharedPreferences.Editor editor=p.edit();
        if(type.equals("String")){
            editor.putString(key,(String)object);
        }
        else if(type.equals("Integer")){
            editor.putInt(key,(Integer) object);
        }
        else if(type.equals("Boolean")){
            editor.putBoolean(key,(Boolean) object);
        }else if(type.equals("Long")){
            editor.putLong(key,(Long)object);
        }
        editor.commit();

    }
    public  static  Object getParam(Context context,String key,Object object){

        SharedPreferences p=context.getSharedPreferences(NAME,Context.MODE_APPEND);
        String type=object.getClass().getSimpleName();
        if(type.equals("String")){
            return p.getString(key,(String)object);
        }
        else if(type.equals("Integer")){
            return p.getInt(key,(Integer)object);

        } else if (type.equals("Boolean")) {
            return p.getBoolean(key, (Boolean) object);

        } else if (type.equals("Long")) {
            return p.getLong(key, (Long) object);

        }
        return null;
    }
    //  SharePreferenceUtils.setParam(getApplicationContext(), "is_first", true);//
//      boolean is_first= (boolean) SharePreferenceUtils.getParam(getApplicationContext(),"is_first",false);
}