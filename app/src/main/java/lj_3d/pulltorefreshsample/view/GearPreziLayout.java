package lj_3d.pulltorefreshsample.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

import lj_3d.gearloadinglayout.gearViews.GearView;
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

    private final float mRotateCoefficient = 0.59f;

    public GearPreziLayout(Context context) {
        this(context, null);
    }

    public GearPreziLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GearPreziLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(getContext()).inflate(R.layout.prezi_gears_layout, this);
        initChildren();
    }

    private void initChildren() {
        mFirstGear = (GearView) findViewById(R.id.gear_view);
        mSecondGear = (GearView) findViewById(R.id.gear_view_2);
        mThirdGear = (GearView) findViewById(R.id.gear_view_3);
        mForthGear = (GearView) findViewById(R.id.gear_view_4);
        mFifthGear = (GearView) findViewById(R.id.gear_view_5);

        mSecondGear.setRotateCoefficent(mRotateCoefficient);
        mThirdGear.setRotateCoefficent(mRotateCoefficient);
        mForthGear.setRotateCoefficent(mRotateCoefficient);
        mFifthGear.setRotateCoefficent(mRotateCoefficient);
    }

    public void onRotate(final float rotateFraction) {
        mFirstGear.rotateByValue(rotateFraction, false);
        mSecondGear.rotateByValue(rotateFraction, true);
        mThirdGear.rotateByValue(rotateFraction, false);
        mForthGear.rotateByValue(rotateFraction, true);
        mFifthGear.rotateByValue(rotateFraction, false);
    }

}
