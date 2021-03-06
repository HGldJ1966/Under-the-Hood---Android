package aws.apps.underthehood.ui;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;

// code by Victor Elias: http://stackoverflow.com/questions/6920137/android-viewpager-and-horizontalscrollview 

public class CustomViewPager extends ViewPager {

    public CustomViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public CustomViewPager(Context context) {
        super(context);
    }
    protected boolean canScroll(View v, boolean checkV, int dx, int x, int y) {
        return super.canScroll(v, checkV, dx, x, y) || (checkV && customCanScroll(v));
    }
    protected boolean customCanScroll(View v) {
        if (v instanceof HorizontalScrollView) {
            View hsvChild = ((HorizontalScrollView) v).getChildAt(0);
            if (hsvChild.getWidth() > v.getWidth())
                return true;
        }
        return false;
   }
}
