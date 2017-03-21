package lj_3d.pulltorefreshsample.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.animation.DecelerateInterpolator;

import lj_3d.pulltorefresh.PullToRefreshLayout;
import lj_3d.pulltorefresh.callbacks.OnRefreshCallback;
import lj_3d.pulltorefreshsample.view.GearPreziLayout;

/**
 * Created by liubomyr on 06.10.16.
 */

public class SimpleActivity extends PullToRefreshHeaderActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_layout);
        initHeaderUI();
    }

    void initHeaderUI() {
        final GearPreziLayout gearLoadingLayout = (GearPreziLayout) findViewById(R.id.gear_prezi_layout);
        final PullToRefreshLayout pullToRefreshLayout = (PullToRefreshLayout) findViewById(R.id.ptr_layout);
        pullToRefreshLayout.setTensionInterpolator(new DecelerateInterpolator());
        pullToRefreshLayout.setTensionBackDuration(600);
        gearLoadingLayout.setPullToRefreshLayout(pullToRefreshLayout);
    }

}
