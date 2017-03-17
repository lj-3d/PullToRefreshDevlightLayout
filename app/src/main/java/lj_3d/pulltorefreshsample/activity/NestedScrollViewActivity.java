package lj_3d.pulltorefreshsample.activity;

import android.os.Bundle;


/**
 * Created by liubomyr on 06.10.16.
 */

public class NestedScrollViewActivity extends PullToRefreshHeaderActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nested_scroll_view);
        initHeaderUI();
    }

}
