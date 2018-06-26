package com.example.scitmaster.memoria;


import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.File;
import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class Videosub extends Activity{

        VideoView video_view;
        ArrayList<String> videolist;
        ListView listview_video;
        ArrayAdapter adapter;

        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.video_activity);

            video_view = (VideoView)findViewById(R.id.video_view);
            listview_video = (ListView)findViewById(R.id.listview_video);
            videolist = new ArrayList<>();
            videolist.add("[국민건강보험공단 치매예방체조] 활기차게 따라하기");
            videolist.add("치매건강을 위한 웃음체조");
            videolist.add("[국민체육진흥공단] 국민건강체조 - 앉아서하는체조 매뉴얼");


            adapter = new ArrayAdapter(Videosub.this,android.R.layout.simple_list_item_1,videolist);
            listview_video.setAdapter(adapter);
            listview_video.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    //Toast.makeText(getApplicationContext(),i+"",Toast.LENGTH_SHORT).show();
                    switch (i){
                        case 0:
                            try{
                                video_view.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.video1));
                                video_view.setMediaController(new MediaController(Videosub.this));
                                video_view.requestFocus();
                                video_view.start();
                            }
                            catch (Exception e){
                                Log.d(TAG,"Message"+e.getMessage());
                                e.printStackTrace();
                                finish();
                            }
                            break;
                        case 1:
                            try {
                                video_view.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/"+R.raw.video2));
                                Log.d(TAG, getPackageName()+R.raw.video2);
                                //MediaController mediaController = new MediaController(Videosub.this);
                                video_view.setMediaController(new MediaController(Videosub.this));
                                video_view.requestFocus();
                                video_view.start();
                            }
                            catch (Exception e){
                                Log.d(TAG,"Message"+e.getMessage());
                                e.printStackTrace();
                                finish();
                            }
                            break;
                        case 2:
                            try {
                                video_view.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/"+R.raw.video3_1));
                                Log.d(TAG, getPackageName()+R.raw.video2);
                                //MediaController mediaController = new MediaController(Videosub.this);
                                video_view.setMediaController(new MediaController(Videosub.this));
                                video_view.requestFocus();
                                video_view.start();
                            }
                            catch (Exception e){
                                Log.d(TAG,"Message"+e.getMessage());
                                e.printStackTrace();
                                finish();
                            }
                            break;
                        default:
                            break;
                    }


                }

            });



    }

}
