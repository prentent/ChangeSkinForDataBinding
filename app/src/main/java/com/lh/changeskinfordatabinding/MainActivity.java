package com.lh.changeskinfordatabinding;

import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;

import com.lh.changeskinfordatabinding.adapter.ChangeSkinAdapter;
import com.lh.changeskinfordatabinding.databinding.ActivityMainBinding;
import com.lh.changeskinfordatabinding.entety.SkinAttr;
import com.lh.changeskinfordatabinding.entety.User;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SkinAttr skinAttr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.recycle.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false));
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName("xxxx" + i);
            user.setAge(i * 10 + "");
            list.add(user);
        }
        ChangeSkinAdapter adapter = new ChangeSkinAdapter(this, list);
        skinAttr = new SkinAttr();
        skinAttr.intBackgroundRes.set(ContextCompat.getColor(this, R.color.skin_background_red));
        skinAttr.intTextColorRes.set(ContextCompat.getColor(this, R.color.skin_color_white));
        adapter.setSkinAttr(skinAttr);
        binding.recycle.setAdapter(adapter);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_red:
                skinAttr.intBackgroundRes.set(ContextCompat.getColor(view.getContext(), R.color.skin_background_red));
                skinAttr.intTextColorRes.set(ContextCompat.getColor(view.getContext(), R.color.skin_color_white));
                break;
            case R.id.btn_blue:
                skinAttr.intBackgroundRes.set(ContextCompat.getColor(view.getContext(), R.color.skin_background_blue));
                skinAttr.intTextColorRes.set(ContextCompat.getColor(view.getContext(), R.color.skin_color_black));
                break;
            case R.id.btn_default:
                skinAttr.intBackgroundRes.set(ContextCompat.getColor(view.getContext(), R.color.skin_background_default));
                skinAttr.intTextColorRes.set(ContextCompat.getColor(view.getContext(), R.color.skin_color_black));
                break;
        }
    }
}
