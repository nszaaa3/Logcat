package com.hjq.logcat;

import android.app.Application;
import android.content.Intent;
import android.view.Gravity;
import android.view.View;

import com.hjq.xtoast.OnClickListener;
import com.hjq.xtoast.XToast;
import com.hjq.xtoast.draggable.SpringDraggable;

/**
 *    author : Android 轮子哥
 *    github : https://github.com/getActivity/Logcat
 *    time   : 2020/01/24
 *    desc   : 悬浮窗口
 */
final class FloatingWindow extends XToast implements OnClickListener {

    FloatingWindow(Application application) {
        super(application);
        setView(R.layout.logcat_window_floating);
        setAnimStyle(android.R.style.Animation_Toast);
        setAnimStyle(android.R.style.Animation_Translucent);
        setDraggable(new SpringDraggable());
        setGravity(Gravity.END | Gravity.CENTER_VERTICAL);
        setOnClickListener(android.R.id.icon, this);
    }

    @Override
    public void onClick(XToast toast, View view) {
        postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getContext(), LogcatActivity.class);
                startActivity(intent);
                cancel();
            }
        }, 500);
    }
}