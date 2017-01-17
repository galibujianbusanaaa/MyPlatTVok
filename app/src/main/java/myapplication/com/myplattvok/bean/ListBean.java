package myapplication.com.myplattvok.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/10/26.
 */
public class ListBean implements Serializable {
    String title;
    String player;
    String up_time;
    String category;
    String id;
    String cover;

    public ListBean(String title, String player, String up_time, String category, String id, String cover) {
        this.title = title;
        this.player = player;
        this.up_time = up_time;
        this.category = category;
        this.id = id;
        this.cover = cover;
    }

    public String getCover() {
        return cover;
    }

    public String getTitle() {
        return title;
    }

    public String getPlayer() {
        return player;
    }

    public String getUp_time() {
        return up_time;
    }

    public String getCategory() {
        return category;
    }

    public String getId() {
        return id;
    }
}
