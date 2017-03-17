package lj_3d.pulltorefresh.callbacks;

import android.support.v4.widget.NestedScrollView;

/**
 * Created by LJ on 04.02.2017.
 */
public interface OnNestedScrollViewScrollListener {

    void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY);

}
