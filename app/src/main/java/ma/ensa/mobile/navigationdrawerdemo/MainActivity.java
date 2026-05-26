package ma.ensa.mobile.navigationdrawerdemo;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.activity.OnBackPressedCallback;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mainDrawer;
    private NavigationView drawerMenu;
    private TextView toolbarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar topBar = findViewById(R.id.toolbar);
        setSupportActionBar(topBar);
        toolbarTitle = findViewById(R.id.toolbarTitle);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        mainDrawer = findViewById(R.id.drawer_layout);
        drawerMenu = findViewById(R.id.nav_view);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                mainDrawer,
                topBar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        );

        mainDrawer.addDrawerListener(toggle);
        toggle.syncState();

        drawerMenu.setNavigationItemSelectedListener(this);

        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                if (mainDrawer.isDrawerOpen(GravityCompat.START)) {
                    mainDrawer.closeDrawer(GravityCompat.START);
                } else {
                    setEnabled(false);
                    getOnBackPressedDispatcher().onBackPressed();
                }
            }
        });

        if (savedInstanceState == null) {
            openFragment(new AuroraFragment(), "Accueil Aurora");
            drawerMenu.setCheckedItem(R.id.nav_aurora);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int selectedId = item.getItemId();

        if (selectedId == R.id.nav_aurora) {
            openFragment(new AuroraFragment(), "Accueil Aurora");

        } else if (selectedId == R.id.nav_ocean) {
            openFragment(new OceanFragment(), "Espace Océan");

        } else if (selectedId == R.id.nav_palette) {
            openFragment(new PaletteListFragment(), "Palette List");
        }

        mainDrawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void openFragment(Fragment fragment, String title) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_stage, fragment)
                .commit();

        toolbarTitle.setText(title);
    }


}