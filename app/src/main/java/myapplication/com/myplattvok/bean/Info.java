package myapplication.com.myplattvok.bean;

/**
 * Created by gxw on 2017/1/18.
 */

public class Info {
    private String title;
    private String id;
    private String player;

    public Info(String title, String id, String player) {
        this.title = title;
        this.id = id;
        this.player = player;
    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    public String getPlayer() {
        return player;
    }
}
