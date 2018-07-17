package in.edu.itsecgn.itsengineeringcollege.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import in.edu.itsecgn.itsengineeringcollege.R;
import in.edu.itsecgn.itsengineeringcollege.adaptor.HomeFragment;
import in.edu.itsecgn.itsengineeringcollege.constants.MyConstants;
import in.edu.itsecgn.itsengineeringcollege.fragment.AboutFragment;
import in.edu.itsecgn.itsengineeringcollege.fragment.DeveloperConsoleFragment;
import in.edu.itsecgn.itsengineeringcollege.fragment.ExploreITSFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    NavigationView navigationView;
    private boolean doubleBackToExitPressedOnce;
    SharedPreferences sharedPreferences;

    SharedPreferences.Editor sharedPreferencesEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);
        fragmentTransaction(new HomeFragment());
    }


    @Override
    public void onBackPressed() {
        DrawerLayout mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (mDrawer.isDrawerOpen(GravityCompat.START)) {
            mDrawer.closeDrawer(GravityCompat.START);
        } else {

            if (doubleBackToExitPressedOnce) {
                super.onBackPressed();
                return;
            }

            doubleBackToExitPressedOnce = true;
            Toast.makeText(this, R.string.press_again_to_exit, Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    doubleBackToExitPressedOnce = false;
                }
            }, 2000);
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_home:
                fragmentTransaction(new HomeFragment());
                break;
            case R.id.nav_about:
                fragmentTransaction(new AboutFragment());
                break;
            case R.id.nac_explore:
                fragmentTransaction(new ExploreITSFragment());

                break;
            case R.id.nav_rate:
                String packageName = getApplicationContext().getPackageName();
                String playStoreLink = "https://play.google.com/store/apps/details?id=" + packageName;
                Intent appRateUsIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(playStoreLink));
                startActivity(appRateUsIntent);
                break;
            case R.id.nav_share:
                String packageName2 = getApplicationContext().getPackageName();
                Intent appShareIntent = new Intent(Intent.ACTION_SEND);
                appShareIntent.setType("text/plain");
                String extraText = "Hey! Check out this amazing app of I.T.S Engineering College.\n";
                extraText += "https://play.google.com/store/apps/details?id=" + packageName2;
                appShareIntent.putExtra(Intent.EXTRA_TEXT, extraText);
                startActivity(appShareIntent);
                break;
            case R.id.nav_facebook:
                setIntent(MyConstants.FACEBOOK_LINK);
                break;
            case R.id.nav_instagram:
                setIntent(MyConstants.INSTAGRAM_LINK);
                break;
            case R.id.nav_youtube:
                setIntent(MyConstants.YOUTUBE_LINK);
                break;
            case R.id.nav_twitter:
                setIntent(MyConstants.TWITTER_LINK);
                break;
            case R.id.nav_developer:
                fragmentTransaction(new DeveloperConsoleFragment());
                break;
            case R.id.nav_logout:
                sharedPreferencesEditor = sharedPreferences.edit();
                sharedPreferencesEditor.putBoolean(MyConstants.LOGGED_IN, false);
                sharedPreferencesEditor.putBoolean(MyConstants.GUEST_LOGIN, false);
                sharedPreferencesEditor.apply();
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                finish();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    void setIntent(String url) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);

    }

    private void fragmentTransaction(Fragment fragment) {
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.nav_container, fragment);
            ft.commit();
        }
    }
}
