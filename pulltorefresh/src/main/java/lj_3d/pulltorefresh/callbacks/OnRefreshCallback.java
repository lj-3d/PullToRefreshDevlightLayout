package lj_3d.pulltorefresh.callbacks;

/**
 * Created by LJ on 04.02.2017.
 */
public interface OnRefreshCallback {

    void onRefresh();

    void onDrag(float offset);

    void onTension(float offset);

    void onTensionUp(float offset);

    void onStartClose();

    void onFinishClose();

    void onTensionComplete();

}
