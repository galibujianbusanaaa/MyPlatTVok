package myapplication.com.myplattvok.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/10/26.
 */
public class ChankanListbena  implements Serializable {
    String id;
    String title;
    String cover;
    String sys_ctime ;
    String barcode ;

    public ChankanListbena(String id, String title, String cover, String sys_ctime, String barcode) {
        this.id = id;
        this.title = title;
        this.cover = cover;
        this.sys_ctime = sys_ctime;
        this.barcode = barcode;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCover() {
        return cover;
    }

    public String getSys_ctime() {
        return sys_ctime;
    }

    public String getBarcode() {
        return barcode;
    }
}
