package com.jack.basevideo.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import com.jack.basevideo.R;
import com.jack.basevideo.fragment.VideoListFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;

    private Fragment[] mFragmentArrays = new Fragment[2];
    private String[] mTabTitles = new String[2];

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        mTabTitles[0] = "推荐";
        mTabTitles[1] = "热点";

        tabLayout.setLayoutMode(TabLayout.MODE_SCROLLABLE);

        mFragmentArrays[0] = VideoListFragment.newInstance();
        mFragmentArrays[1] = VideoListFragment.newInstance();

        PagerAdapter adapter = new VideoViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        //将ViewPager和TabLayout绑定
        tabLayout.setupWithViewPager(viewPager);

    }

    final class VideoViewPagerAdapter extends FragmentPagerAdapter {
        public VideoViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentArrays[position];
        }

        @Override
        public int getCount() {
            return mFragmentArrays.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTabTitles[position];
        }
    }

}
