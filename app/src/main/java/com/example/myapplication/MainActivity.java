package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.ui.home.HomeFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    final Context context = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


        /*b = new Button[]{(Button)findViewById(R.id.b2_1),(Button)findViewById(R.id.b2_2),(Button)findViewById(R.id.b2_3),
                (Button)findViewById(R.id.b2_4),(Button)findViewById(R.id.b2_5),(Button)findViewById(R.id.b2_6),
                (Button)findViewById(R.id.b2_7),(Button)findViewById(R.id.b2_8),(Button)findViewById(R.id.b2_9),
                (Button)findViewById(R.id.b2_10),(Button)findViewById(R.id.b2_11),(Button)findViewById(R.id.b2_12),
                (Button)findViewById(R.id.b2_13),(Button)findViewById(R.id.b2_14),(Button)findViewById(R.id.b2_15),
                (Button)findViewById(R.id.b2_16)};
        t = new TextView[]{(TextView) findViewById(R.id.t2_1),(TextView) findViewById(R.id.t2_2),(TextView) findViewById(R.id.t2_3),
                (TextView)findViewById(R.id.t2_4),(TextView)findViewById(R.id.t2_5),(TextView)findViewById(R.id.t2_6),
                (TextView)findViewById(R.id.t2_7),(TextView)findViewById(R.id.t2_8),(TextView)findViewById(R.id.t2_9),
                (TextView)findViewById(R.id.t2_10),(TextView)findViewById(R.id.t2_11),(TextView)findViewById(R.id.t2_12),
                (TextView)root.findViewById(R.id.t2_13),(TextView)root.findViewById(R.id.t2_14),(TextView)root.findViewById(R.id.t2_15),
                (TextView)root.findViewById(R.id.t2_16)};


        b[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add_amount();
                double a = Double.parseDouble(String.valueOf(t[1].getText()))+Double.parseDouble(amount_of_dialog);
                t[0].setText(String.valueOf(a));
                sum = sum - a;
            }
        });*/


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}