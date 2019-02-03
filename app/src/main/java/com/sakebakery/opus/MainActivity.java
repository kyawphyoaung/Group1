package com.sakebakery.opus;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.sakebakery.opus.adapter.CakeImagelistAdapter;
import com.sakebakery.opus.obj.Cakeobj;
import com.sakebakery.opus.util.Util;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Button btn_test;
    private CakeImagelistAdapter cakeImagelistAdapter;

    private RecyclerView cake_list;

    private ProgressDialog progressDialog;

    private ArrayList<Cakeobj> cakeObjs;

    private static FirebaseAnalytics firebaseAnalytics;

    private DatabaseReference mDatabase;

    private FirebaseAuth mAuth;

    public ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        btn_test = findViewById(R.id.bt_create);

        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "List Event", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, Cakelist_firebase_api.class);
                startActivity(intent);

            }
        });

        cake_list= findViewById(R.id.cake_list);

        cakeObjs = new ArrayList<>();

        if(Util.isOnline(getApplicationContext())){
            LoadFirebaseDB();
        }else {
            Toast.makeText(getApplicationContext(), "No internet connection!", Toast.LENGTH_SHORT).show();
        }

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
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_profile) {
            Intent intent = new Intent(MainActivity.this, myprofile.class);
            startActivity(intent);
        } else if (id == R.id.nav_mycart) {
            Intent intent = new Intent(MainActivity.this, Cartlist_firebase_api.class);
            startActivity(intent);
        } else if (id == R.id.nav_myorders) {

        } else if (id == R.id.nav_fav) {

        } else if (id == R.id.nav_logout) {
            signOut();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private void signOut() {
        mAuth.signOut();
        updateUI(null);
    }

    private void updateUI(FirebaseUser user) {
        hideProgressDialog();
        if (user != null) {
            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        }
    }

    public void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        firebaseAnalytics = FirebaseAnalytics.getInstance(this);
        firebaseAnalytics.setCurrentScreen(MainActivity.this,"FirebaseAPI_Screen",null);
    }

    public void LoadFirebaseDB() {


        if (progressDialog == null) {
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setCancelable(true);
            progressDialog.setMessage("Loading...");
            progressDialog.show();
        }

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("cakedata").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                Log.d("Cake_list", "" + dataSnapshot.toString());

                for (DataSnapshot ds : dataSnapshot.getChildren()) {

                    Cakeobj cakeobj = new Cakeobj();
                    cakeobj.setCake_id(ds.child("id").getValue() + "");
                    cakeobj.setCake_name(ds.child("name").getValue() + "");
                    cakeobj.setCake_flavor(ds.child("flavor").getValue() + "");
                    cakeobj.setCake_price(ds.child("price").getValue() + "");
                    cakeobj.setCake_image(ds.child("thumbnail").getValue() + "");
                    cakeobj.setActive(Integer.parseInt(ds.child("active").getValue() + ""));


                    if (cakeobj.getActive() == 1) {
                        cakeObjs.add(cakeobj);
                    }

                    if (cakeObjs.size() == 0) {
                        Toast.makeText(MainActivity.this, "No Data!", Toast.LENGTH_SHORT).show();
                    }

                }

                LoadUI();

                DismissDialog();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                DismissDialog();
            }
        });

    }

    public void DismissDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }


    public void LoadUI() {

        cakeImagelistAdapter = new CakeImagelistAdapter(MainActivity.this,cakeObjs);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());

        cake_list.setLayoutManager(mLayoutManager);
        cake_list.setItemAnimator(new DefaultItemAnimator());
        cake_list.setAdapter(cakeImagelistAdapter);

    }
}
