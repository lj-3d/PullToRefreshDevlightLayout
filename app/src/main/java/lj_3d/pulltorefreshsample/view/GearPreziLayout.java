package lj_3d.pulltorefreshsample.view;

import android.animation.Animator;
import android.content.Context;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.animation.AnticipateInterpolator;
import android.widget.RelativeLayout;

import lj_3d.gearloadinglayout.gearViews.GearView;
import lj_3d.pulltorefresh.PullToRefreshLayout;
import lj_3d.pulltorefresh.callbacks.OnRefreshCallback;
import lj_3d.pulltorefreshsample.activity.R;

/**
 * Created by liubomyr on 20.03.17.
 */

public class GearPreziLayout extends RelativeLayout {

    private GearView mFirstGear;
    private GearView mSecondGear;
    private GearView mThirdGear;
    private GearView mForthGear;
    private GearView mFifthGear;

    private PullToRefreshLayout mPullToRefreshLayout;
    private final float ROTATE_COEFFICIENT = 0.59f;
    private final int FIRST_GEAR_SHIFT = getResources().getDimensionPixelSize(R.dimen.pull_2_refresh_prezi_main_gear_shift);
    private final int FIRST_GEAR_SPIN_DURATION = 1000;
    private float mTensionValue = -1f;

    public GearPreziLayout(Context context) {
        this(context, null);
    }

    public GearPreziLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GearPreziLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(getContext()).inflate(R.layout.layout_prezi_gears, this);
        initChildren();
    }

    private void initChildren() {
        mFirstGear = (GearView) findViewById(R.id.gear_view);
        mSecondGear = (GearView) findViewById(R.id.gear_view_2);
        mThirdGear = (GearView) findViewById(R.id.gear_view_3);
        mForthGear = (GearView) findViewById(R.id.gear_view_4);
        mFifthGear = (GearView) findViewById(R.id.gear_view_5);

        mSecondGear.setRotateCoefficient(ROTATE_COEFFICIENT);
        mThirdGear.setRotateCoefficient(ROTATE_COEFFICIENT);
        mForthGear.setRotateCoefficient(ROTATE_COEFFICIENT);
        mFifthGear.setRotateCoefficient(ROTATE_COEFFICIENT);
    }

    public void onRotate(final float rotateFraction) {
        mFirstGear.rotateByValue(rotateFraction, false);
        mSecondGear.rotateByValue(rotateFraction, true);
        mThirdGear.rotateByValue(rotateFraction, false);
        mForthGear.rotateByValue(rotateFraction, true);
        mFifthGear.rotateByValue(rotateFraction, false);
    }

    public void onTensionUpStart() {
        mFirstGear.setDuration(FIRST_GEAR_SPIN_DURATION);
        mFirstGear.startSpinning(false);
    }

    public void onTensionUp(final float fraction) {
        final float shiftValue = 400 * fraction;
        final float minusShiftValue = -1 * shiftValue;
        Log.d("onTensionUp ", fraction + " " + shiftValue + " " + minusShiftValue);

        mFirstGear.setTranslationY(FIRST_GEAR_SHIFT * fraction);


        mSecondGear.setTranslationX(minusShiftValue);
        mSecondGear.setTranslationY(shiftValue);

        mThirdGear.setTranslationX(minusShiftValue);
        mThirdGear.setTranslationY(minusShiftValue);

        mForthGear.setTranslationX(shiftValue);
        mForthGear.setTranslationY(minusShiftValue);

        mFifthGear.setTranslationX(shiftValue);
        mFifthGear.setTranslationY(shiftValue);
    }

    public void onReset() {
        mFirstGear.setScaleX(1f);
        mFirstGear.setScaleY(1f);
        mFirstGear.setTranslationY(1f);
        mSecondGear.setTranslationX(1f);
        mSecondGear.setTranslationY(1f);
        mThirdGear.setTranslationX(1f);
        mThirdGear.setTranslationY(1f);
        mForthGear.setTranslationX(1f);
        mForthGear.setTranslationY(1f);
        mFifthGear.setTranslationX(1f);
        mFifthGear.setTranslationY(1f);
        mTensionValue = -1f;
    }

    public void setPullToRefreshLayout(PullToRefreshLayout pullToRefreshLayout) {
        mPullToRefreshLayout = pullToRefreshLayout;

        mPullToRefreshLayout.setOnRefreshCallback(new OnRefreshCallback() {
            @Override
            public void onRefresh() { // start update data instead handler example
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        completeClose();
                    }
                }, 3000);
            }

            @Override
            public void onDrag(float offset) {
                GearPreziLayout.this.onRotate(offset * 0.3f);
            }

            @Override
            public void onTension(float offset) {

            }

            @Override
            public void onTensionUp(float offset) {
                if (mTensionValue == -1) {
                    mTensionValue = 1 - offset;
                }
                final float calculatedOffset = 1 - ((1 - offset) / mTensionValue);
                Log.d("onTensionUp(", offset + " " + calculatedOffset + " " + mTensionValue);
                GearPreziLayout.this.onTensionUp(calculatedOffset);
            }

            @Override
            public void onStartClose() {

            }

            @Override
            public void onFinishClose() {
                onReset();
            }

            @Override
            public void onTensionUpComplete() {

            }

            @Override
            public void onTensionUpStart() {
                GearPreziLayout.this.onTensionUpStart();
            }
        });

        mFirstGear.setOnSpinAnimationListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                ViewCompat.animate(mFirstGear).scaleX(0).scaleY(0)
                        .setInterpolator(new AnticipateInterpolator())
                        .withEndAction(new Runnable() {
                            @Override
                            public void run() {
                                mPullToRefreshLayout.finishRefresh();
                            }
                        });
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    private void completeClose() {
        mFirstGear.stopSpinningWithInertia();
    }
}
