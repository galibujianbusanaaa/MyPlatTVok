package myapplication.com.myplattvok.bean;

/**
 * Created by Administrator on 2016/10/26.
 */
public class Bean {

    String id;
    String title;
    String player;
    String   sys_ctime;
    String   play_conver ;

    String   play_list_0 ;
    String   play_list_1 ;
    String   play_list_2 ;
    String   play_list_3 ;
    String   play_list_4 ;
    String   play_list_5 ;

    public Bean(String id, String title, String play_list_5, String player, String sys_ctime, String play_conver, String play_list_0, String play_list_1, String play_list_2, String play_list_3, String play_list_4) {
        this.id = id;
        this.title = title;
        this.play_list_5 = play_list_5;
        this.player = player;
        this.sys_ctime = sys_ctime;
        this.play_conver = play_conver;
        this.play_list_0 = play_list_0;
        this.play_list_1 = play_list_1;
        this.play_list_2 = play_list_2;
        this.play_list_3 = play_list_3;
        this.play_list_4 = play_list_4;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPlayer() {
        return player;
    }

    public String getSys_ctime() {
        return sys_ctime;
    }

    public String getPlay_conver() {
        return play_conver;
    }

    public String getPlay_list_0() {
        return play_list_0;
    }

    public String getPlay_list_1() {
        return play_list_1;
    }

    public String getPlay_list_2() {
        return play_list_2;
    }

    public String getPlay_list_3() {
        return play_list_3;
    }

    public String getPlay_list_4() {
        return play_list_4;
    }

    public String getPlay_list_5() {
        return play_list_5;
    }
}
