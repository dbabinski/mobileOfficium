package pl.mobile.divinumofficium.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import pl.mobile.divinumofficium.R;

public class ScrollFab extends FloatingActionButton.Behavior {

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout,
                                       FloatingActionButton child,
                                       View directTargetChild,
                                       View target,
                                       int axes, int type) {

        return axes == ViewCompat.SCROLL_AXIS_VERTICAL ||
                super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, axes, type);
    }

    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout,
                               FloatingActionButton child,
                               View target, int dxConsumed,
                               int dyConsumed, int dxUnconsumed,
                               int dyUnconsumed, int type,
                               int[] consumed) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type, consumed);

        if (dyConsumed > 0 && child.getVisibility() == View.VISIBLE){
            child.hide(new FloatingActionButton.OnVisibilityChangedListener() {
                @Override
                public void onHidden(FloatingActionButton fab) {
                    super.onHidden(fab);
                    fab.setVisibility(View.INVISIBLE);
                }
            });

        } else if (dyConsumed < 0 && child.getVisibility() != View.VISIBLE){
            child.show();
        }

    }

    public ScrollFab (Context context, AttributeSet attrs) {
        super();
    }



}

