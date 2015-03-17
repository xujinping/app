package com.xjp.myapp.View;

import android.util.SparseArray;
import android.view.View;

/**
 * Description:
 * User: xjp
 * Date: 2015/3/11
 * Time: 15:36
 */
public class ViewHolder {
    public static <T extends View> T get(View view, int id) {
        SparseArray<View> viewHolder = (SparseArray<View>) view.getTag();
        if (viewHolder == null) {
            viewHolder = new SparseArray<View>();
            view.setTag(viewHolder);
        }
        View childView = viewHolder.get(id);
        if (childView == null) {
            childView = view.findViewById(id);
            viewHolder.put(id, childView);
        }
        return (T) childView;
    }
}
