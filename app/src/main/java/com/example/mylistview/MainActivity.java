package com.example.mylistview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;

import com.example.mylistview.Bean.Mdata;
import com.example.mylistview.adapter.Mlistadapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lv;
    private ArrayList<Mdata> mdatas;
    private Mlistadapter mlistadapter;
    private boolean isyincang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
////        setSupportActionBar(toolbar);
//        toolbar.setNavigationIcon(R.mipmap.ic_launcher);//设置导航栏图标
//        toolbar.setLogo(R.mipmap.ic_launcher);//设置app logo
//        toolbar.setTitle("Title");//设置主标题
//        toolbar.setSubtitle("Subtitle");//设置子标题
        mdatas = new ArrayList<>();
        lv = (ListView) findViewById(R.id.lv);
       Button quanxuan = (Button) findViewById(R.id.bt1);
        Button quxiao = (Button) findViewById(R.id.bt2);
        final Button yincang = (Button) findViewById(R.id.bt3);
        findViewById(R.id.bt3);

        for (int i = 0; i < 50; i++) {
            Mdata mdata = new Mdata();
            mdata.flag = false;
            mdata.pos = "text"+i;
            mdata.index = i+"";
            mdatas.add(mdata);
        }
        mlistadapter = new Mlistadapter(mdatas, this);
        lv.setAdapter(mlistadapter);
        quanxuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(Mdata mdata: mdatas){
                    mdata.flag = true;

                }
                mlistadapter.notifyDataSetChanged();




            }
        });
        quxiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(Mdata mdata: mdatas){
                    mdata.flag = false;

                }
                mlistadapter.notifyDataSetChanged();






            }
        });
        yincang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isyincang = isyincang==false?true:false;
                if(isyincang){
                    yincang.setText("取消隐藏");
                }else{
                    yincang.setText("隐藏已选");

                }

                mlistadapter.setHide(isyincang);
                mlistadapter.notifyDataSetChanged();



            }
        });


    }


}
