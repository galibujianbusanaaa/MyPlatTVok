package myapplication.com.myplattvok.avtivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.File;

import myapplication.com.myplattvok.R;

public class Player_Activity extends AppCompatActivity {

    VideoView videoView;
    MediaStore.Video video;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        Intent intent=getIntent();
        String url=intent.getStringExtra("url");

        /**
         *
         * */
        Uri uri = Uri.parse(url);
//调用系统自带的播放器
        Intent intent2 = new Intent(Intent.ACTION_VIEW);
        Log.v("URI:::::::::", uri.toString());
        intent2.setDataAndType(uri, "video/mp4");
        startActivity(intent2);
    }







}
