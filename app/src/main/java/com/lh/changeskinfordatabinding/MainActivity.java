package com.lh.changeskinfordatabinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.lh.changeskinfordatabinding.adapter.ChangeSkinAdapter;
import com.lh.changeskinfordatabinding.databinding.ActivityMainBinding;
import com.lh.changeskinfordatabinding.entety.SkinAttr;
import com.lh.changeskinfordatabinding.entety.User;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private SkinAttr skinAttr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        binding.appBarMain.contentMain.recycle.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false));
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            User user = new User();
            user.setName("xxxx" + i);
            user.setAge(i * 10 + "");
            list.add(user);
        }
        ChangeSkinAdapter adapter = new ChangeSkinAdapter(this, list);
        skinAttr = new SkinAttr();
        int color = ContextCompat.getColor(this, R.color.skin_background_red);
        int color1 = ContextCompat.getColor(this, R.color.skin_color_white);
        skinAttr.intBackgroundRes.set(color);
        skinAttr.intTextColorRes.set(color1);
        adapter.setSkinAttr(skinAttr);
        binding.appBarMain.contentMain.recycle.setAdapter(adapter);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.skin_red) {
            skinAttr.intBackgroundRes.set(ContextCompat.getColor(this, R.color.skin_background_red));
            skinAttr.intTextColorRes.set(ContextCompat.getColor(this, R.color.skin_color_white));

        } else if (id == R.id.skin_blue) {
            skinAttr.intBackgroundRes.set(ContextCompat.getColor(this, R.color.skin_background_blue));
            skinAttr.intTextColorRes.set(ContextCompat.getColor(this, R.color.skin_color_black));

        } else if (id == R.id.skin_default) {
            skinAttr.intBackgroundRes.set(ContextCompat.getColor(this, R.color.skin_background_default));
            skinAttr.intTextColorRes.set(ContextCompat.getColor(this, R.color.skin_color_black));

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
