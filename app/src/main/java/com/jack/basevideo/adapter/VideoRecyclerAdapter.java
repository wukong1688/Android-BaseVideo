package com.jack.basevideo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jack.basevideo.R;
import com.squareup.picasso.Picasso;
import com.zhangqie.zqvideolibrary.ZQVideoPlayer;
import com.zhangqie.zqvideolibrary.ZQVideoPlayerStandard;

public class VideoRecyclerAdapter extends RecyclerView.Adapter<VideoRecyclerAdapter.AuthorViewHolder> {

    public static final String TAG = "AdapterRecyclerViewVideo";
    private Context context;
    private String[] strings = {
            "https://scb.liaidi.com//data//image//photo//2017//12//20171214205200832660.jpg",
            "https://scb.liaidi.com//data//image//photo//2017//12//20171214204955317939.jpg",
            "https://scb.liaidi.com//data//image//photo//2017//12//20171214205008812743.jpg",
            "http://jzvd-pic.nathen.cn/jzvd-pic/1bb2ebbe-140d-4e2e-abd2-9e7e564f71ac.png"
    };
    private String[] video = {
            "https://scb.liaidi.com//data//video//2017//12//20171214212407880750.mp4",
            "https://scb.liaidi.com//data//video//2017//12//20171214234546834418.mp4",
            "https://scb.liaidi.com//data//video//2017//12//20171214235251279358.mp4",
            "http://jzvd.nathen.cn/342a5f7ef6124a4a8faf00e738b8bee4/cf6d9db0bd4d41f59d09ea0a81e918fd-5287d2089db37e62345123a1be272f8b.mp4"
    };

    private String[] title = {"玉舍", "玫瑰庄园", "火把节", "boy"};

    @Override
    public AuthorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View childView = inflater.inflate(R.layout.item_videoview, parent, false);
        AuthorViewHolder viewHolder = new AuthorViewHolder(childView);
        return viewHolder;
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    @Override
    public void onBindViewHolder(AuthorViewHolder holder, int position) {
        //设置视频地址和标题
        holder.zqVideoPlayerStandard.setUp(video[position], ZQVideoPlayer.SCREEN_WINDOW_LIST,
                title[position]);

        //设置封面图
        Picasso.with(holder.zqVideoPlayerStandard.getContext())
                .load(strings[position])
                .into(holder.zqVideoPlayerStandard.thumbImageView);
    }

    class AuthorViewHolder extends RecyclerView.ViewHolder {

        ZQVideoPlayerStandard zqVideoPlayerStandard;

        public AuthorViewHolder(View itemView) {
            super(itemView);

            zqVideoPlayerStandard = (ZQVideoPlayerStandard) itemView.findViewById(R.id.video_player);

        }
    }
}