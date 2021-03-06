package in.championswimmer.xpartman.ui;

import android.app.Activity;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;

import org.json.JSONException;

import java.io.IOException;

import in.championswimmer.xpartman.R;
import in.championswimmer.xpartman.ui.fragments.BackupFragment;
import in.championswimmer.xpartman.ui.fragments.FlashFragment;
import in.championswimmer.xpartman.ui.fragments.RestoreFragment;
import in.championswimmer.xpartman.utils.ModelInfo;


public class MainActivity extends Activity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    public static final String TAG = "MainActivity";

    public static ModelInfo modelInfo;

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));

        try {
            modelInfo = new ModelInfo(this);
            Log.i(TAG, "Using model "
                    + modelInfo.getModelName()
                    + " and properties of generic model " + modelInfo.getActualModelName());
        } catch (Exception e) {
            // Could not open local json file to inflate model info;
            Log.e(TAG, "Could not load modelinfo ", e);
        }
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getFragmentManager();
        switch (position) {
            case 1: {
                fragmentManager.beginTransaction()
                        .replace(R.id.container, BackupFragment.newInstance("A","A"))
                        .commit();
                break;
            }
            case 2: {
                fragmentManager.beginTransaction()
                        .replace(R.id.container, RestoreFragment.newInstance("A", "A"))
                        .commit();
                break;
            }
            case 3: {
                fragmentManager.beginTransaction()
                        .replace(R.id.container, FlashFragment.newInstance("A", "A"))
                        .commit();
                break;
            }
            default: {
                fragmentManager.beginTransaction()
                        .replace(R.id.container, BackupFragment.newInstance("A","A"))
                        .commit();
                break;
            }
        }
        onSectionAttached(position);

    }

    public void onSectionAttached(int number) {
        String[] fragTitles = getResources().getStringArray(R.array.nav_drawer_fragments);
        mTitle = fragTitles[number];
    }

    public void restoreActionBar() {
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
