package com.viewgroup;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;

public class Creator {
    public static void createSwipeDismissLayout(Activity activity, boolean enabled, SwipeDismissLayout.DragFrom dragFrom){
        SwipeDismissLayout swipeDismissLayout = new SwipeDismissLayout(activity);
        swipeDismissLayout.setSwipeEnabled(enabled);
        swipeDismissLayout.setDismissDirection(dragFrom);
        setActivityRoot(activity, swipeDismissLayout);
    }
    private static void setActivityRoot(Activity activity, ViewGroup newRoot) {
        View currentRoot = ((ViewGroup)(activity.findViewById(android.R.id.content))).getChildAt(0);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        newRoot.setLayoutParams(layoutParams);
        ((ViewGroup)(currentRoot.getParent())).removeAllViews();
        currentRoot.setBackgroundColor(getColorBackground(activity));
        newRoot.addView(currentRoot);
        activity.addContentView(newRoot, layoutParams);
    }
    private static int getColorBackground(Context context){
        int[] attribute = new int[] { android.R.attr.colorBackground };
        TypedArray array = context.getTheme().obtainStyledAttributes(attribute);
        int color = array.getColor(0, Color.TRANSPARENT);
        array.recycle();
        return color;
    }
}
