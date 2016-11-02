package com.example.mylistview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by 李韦 on 2016/11/2 15:06
 */

public class Mylistview extends ListView {
    public Mylistview(Context context) {
        super(context);
    }

    public Mylistview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Mylistview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
/**用整数max的前两位来给mode,用整数max的后30位来给size最后再整合成i然后
 * 把i赋值给底层的测量方法
 */

        super.onMeasure(widthMeasureSpec, i);
    }


}
