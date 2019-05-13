package com.lh.changeskinfordatabinding;

import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.lh.changeskinfordatabinding.databinding.ActivityMainBinding;
import com.lh.changeskinfordatabinding.entety.SkinAttr;

public class MainActivity extends AppCompatActivity {

    private SkinAttr skinAttr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        skinAttr = new SkinAttr();
        skinAttr.intBackgroundRes.set(ContextCompat.getColor(this, R.color.skin_background_default));
        skinAttr.intTextColorRes.set(ContextCompat.getColor(this, R.color.skin_color_black));
        skinAttr.str.set("xxx");
        binding.setSkinAttr(skinAttr);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    skinAttr.str.set("qqqqqqqqqq");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    public class Presenter {
        public void onClick(View view, int type) {
            switch (type) {
                case 1:
                    skinAttr.intBackgroundRes.set(ContextCompat.getColor(view.getContext(), R.color.skin_background_red));
                    skinAttr.intTextColorRes.set(ContextCompat.getColor(view.getContext(), R.color.skin_color_white));
                    skinAttr.str.set("ddd");
                    break;
                case 2:
                    skinAttr.intBackgroundRes.set(ContextCompat.getColor(view.getContext(), R.color.skin_background_blue));
                    skinAttr.intTextColorRes.set(ContextCompat.getColor(view.getContext(), R.color.skin_color_black));
                    skinAttr.str.set("fff");
                    break;
                case 3:
                    skinAttr.intBackgroundRes.set(ContextCompat.getColor(view.getContext(), R.color.skin_background_default));
                    skinAttr.intTextColorRes.set(ContextCompat.getColor(view.getContext(), R.color.skin_color_black));
                    skinAttr.str.set("qqq");
                    break;
                default:
                    break;
            }
        }
    }
}
