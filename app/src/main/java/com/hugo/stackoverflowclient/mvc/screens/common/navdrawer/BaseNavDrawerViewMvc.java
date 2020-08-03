package com.hugo.stackoverflowclient.mvc.screens.common.navdrawer;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.hugo.stackoverflowclient.R;
import com.hugo.stackoverflowclient.mvc.screens.common.views.BaseObservableViewMvc;

public abstract class BaseNavDrawerViewMvc<ListenerType> extends BaseObservableViewMvc<ListenerType>
        implements NavigationDrawerViewMvc{

    private final DrawerLayout mDrawerLayout;
    private final FrameLayout mFrameLayout;
    private final NavigationView mNavigationView;

    public BaseNavDrawerViewMvc(LayoutInflater inflater, @Nullable ViewGroup parent) {
        super.setmRootView(inflater.inflate(R.layout.layout_drawer, parent, false));
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mFrameLayout = findViewById(R.id.frame_content);
        mNavigationView = findViewById(R.id.nav_view);

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                mDrawerLayout.closeDrawers();

                if (item.getItemId() == R.id.drawer_menu_latest_questions) {
                    onDrawerItemClicked(DrawerItems.QUESTIONS_LIST);
                }
                return false;
            }
        });
    }

    protected abstract void onDrawerItemClicked(DrawerItems item);

    @Override
    public boolean isDrawerOpen() {
        return mDrawerLayout.isDrawerOpen(Gravity.START);
    }

    @Override
    public void closeDrawer() {
        mDrawerLayout.closeDrawers();
    }

    @Override
    public void openDrawer() {
        mDrawerLayout.openDrawer(Gravity.START);
    }

    @Override
    protected void setmRootView(View rootView) {
        mFrameLayout.addView(rootView);
    }
}
