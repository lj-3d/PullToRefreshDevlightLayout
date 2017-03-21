package lj_3d.pulltorefreshsample.utils;

import android.os.Handler;
import android.util.Log;

import lj_3d.gearloadinglayout.gearViews.GearLoadingLayout;
import lj_3d.pulltorefresh.PullToRefreshLayout;
import lj_3d.pulltorefresh.callbacks.OnRefreshCallback;

/**
 * Created by liubomyr on 08.02.17.
 */

public class PullToRefreshConfigurator {

    public static void setupPullToRefresh(final PullToRefreshLayout pullToRefreshLayout, final GearLoadingLayout gearLoadingLayout) {
        pullToRefreshLayout.setFullBackDuration(500);
        pullToRefreshLayout.setTensionBackDuration(1500);
//        pullToRefreshLayout.setTensionInterpolator(new OvershootInterpolator());
        pullToRefreshLayout.setOnRefreshCallback(new OnRefreshCallback() {
            @Override
            public void onRefresh() {
                gearLoadingLayout.start(true);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        pullToRefreshLayout.finishRefresh();
                    }
                }, 2000);
            }

            @Override
            public void onDrag(float offset) {
                gearLoadingLayout.rotateByValue(offset);
            }

            @Override
            public void onTension(float offset) {
                final float scaleValue = 0.1f * offset;
                gearLoadingLayout.setScaleX(1 + scaleValue);
                gearLoadingLayout.setScaleY(1 + scaleValue);
            }

            @Override
            public void onTensionUp(float offset) {
                final float scaleValue = 0.1f * offset;
                final float rotateValue = -360f * (offset * 0.07f);
                gearLoadingLayout.setScaleX(1.1f - scaleValue);
                gearLoadingLayout.setScaleY(1.1f - scaleValue);
                gearLoadingLayout.rotateByValue(offset);
                Log.d("rotate_tension", " " + rotateValue);
            }

            @Override
            public void onStartClose() {

            }

            @Override
            public void onFinishClose() {
                gearLoadingLayout.stop();
            }

            @Override
            public void onTensionUpComplete() {

            }

            @Override
            public void onTensionUpStart() {

            }
        });

//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                pullToRefreshLayout.callAutoRefresh();
//            }
//        }, 1000);
    }


}
