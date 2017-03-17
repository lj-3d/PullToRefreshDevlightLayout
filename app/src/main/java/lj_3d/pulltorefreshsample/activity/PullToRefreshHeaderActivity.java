package lj_3d.pulltorefreshsample.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import lj_3d.gearloadinglayout.gearViews.GearLoadingLayout;
import lj_3d.pulltorefresh.PullToRefreshLayout;
import lj_3d.pulltorefreshsample.utils.PullToRefreshConfigurator;

public class PullToRefreshHeaderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    void initHeaderUI() {
        final GearLoadingLayout gearLoadingLayout = (GearLoadingLayout) findViewById(R.id.gear_layout);
        final PullToRefreshLayout pullToRefreshLayout = (PullToRefreshLayout) findViewById(R.id.ptr_layout);
        PullToRefreshConfigurator.setupPullToRefresh(pullToRefreshLayout, gearLoadingLayout);
    }


}
