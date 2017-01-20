package myapplication.com.myplattvok.avtivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import myapplication.com.myplattvok.R;

public class Aboutme_Activity extends AppCompatActivity {
    ImageView zuo_back;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutme);
        zuo_back= (ImageView) findViewById(R.id.image_back);
        zuo_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Aboutme_Activity.this.finish();
            }
        });
        textView= (TextView) findViewById(R.id.textView_connect);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"待定",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
