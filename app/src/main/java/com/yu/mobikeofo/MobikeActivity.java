package com.yu.mobikeofo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.mobike.library.MobikeView;

public class MobikeActivity extends AppCompatActivity {
    private MobikeView mobikeView;
    private Button btnTest;
    private Button btnNext;
    private int[] imgs = {
            R.mipmap.share_fb,
            R.mipmap.share_kongjian,
            R.mipmap.share_pyq,
            R.mipmap.share_qq,
            R.mipmap.share_tw,
            R.mipmap.share_wechat,
            R.mipmap.share_weibo
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile);
        getSupportActionBar().setTitle("摩拜贴纸");
        mobikeView = (MobikeView) findViewById(R.id.mobike_view);
        btnNext = (Button) findViewById(R.id.btn_next);
        btnTest = (Button) findViewById(R.id.test);
        initViews();
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mobikeView.getmMobike().random();
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.startActivity(MobikeActivity.this,Mobike2Activity.class);
            }
        });
    }

    private void initViews() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.gravity = Gravity.CENTER;
        for (int i = 0; i < imgs.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(imgs[i]);
            if (i == imgs.length - 1) {
                imageView.setTag(R.id.mobike_view_circle_tag, false);
            } else {
                imageView.setTag(R.id.mobike_view_circle_tag, true);
            }
            mobikeView.addView(imageView, layoutParams);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        mobikeView.getmMobike().onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mobikeView.getmMobike().onStop();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 110 && data != null) {
            float density = data.getFloatExtra("density", -1);
            float friction = data.getFloatExtra("friction", -1);
            float restitution = data.getFloatExtra("restitution", -1);
            float ratio = data.getFloatExtra("ratio", -1);
            mobikeView.getmMobike().setDensity(density);
            mobikeView.getmMobike().setFriction(friction);
            mobikeView.getmMobike().setRestitution(restitution);
            mobikeView.getmMobike().setRatio(ratio);
            mobikeView.getmMobike().update();
        }
    }
}
