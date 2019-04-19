package com.jack.basevideo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jack.basevideo.R;
import com.zhangqie.zqvideolibrary.ZQVideoPlayerStandard;

public class TestVideoActivity extends AppCompatActivity {
    public ZQVideoPlayerStandard video_player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_video);

        initView();
    }

    private void initView() {
        video_player = (ZQVideoPlayerStandard) findViewById(R.id.video_player);

        video_player.setUp("https://scb.liaidi.com//data//video//2017//12//20171214235251279358.mp4",
                ZQVideoPlayerStandard.SCREEN_WINDOW_LIST,
                "标题");
        video_player.startVideo();
    }

    @Override
    public void onBackPressed() {
        if (video_player.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        video_player.releaseAllVideos();
    }
}
