package com.ibookshop.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Menu;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.ibookshop.R;
import com.ibookshop.fragments.CartPageFragment;
import com.ibookshop.fragments.myBookFragment;
import com.ibookshop.fragments.tieuThuyetFragment;
import com.ibookshop.fragments.mainPageFragment;
import com.ibookshop.fragments.truyenFragment;
import com.ibookshop.fragments.vienTuongFragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.ibookshop.R.layout.activity_main);

        Toolbar toolbar  = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open
                ,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new mainPageFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.nav_home) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new mainPageFragment()).commit();
        }
        if(id==R.id.nav_tieuThuyet)
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new tieuThuyetFragment()).commit();
        if(id==R.id.nav_vienTuong)
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new vienTuongFragment()).commit();
        if(id==R.id.nav_truyen)
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new truyenFragment()).commit();
        if(id==R.id.nav_myBook)
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new myBookFragment()).commit();

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START);
        else
            super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.log_out)
        {
            Intent intent = new Intent(MainActivity.this,welcomePageActivity.class);
            startActivity(intent);
            finish();
        }

        if(id==R.id.setting)
            Toast.makeText(this, "Setting button selected", Toast.LENGTH_SHORT).show();
        if(id==R.id.profile)
            Toast.makeText(this, "Profile button selected", Toast.LENGTH_SHORT).show();
        if(id==R.id.cart)
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new CartPageFragment()).commit();
        return super.onOptionsItemSelected(item);
    }

}