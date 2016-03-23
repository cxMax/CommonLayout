package com.max.administrator.commonlayout.common.baseclass;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.max.administrator.commonlayout.activity.MainActivity;
import com.max.administrator.commonlayout.utils.SystemBarTintManager;

/**
 * Created by Administrator on 2016/3/17.
 */
public class BaseActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 添加Activity到堆栈
        AppManager.getAppManager().addActivity(this);
        //沉浸式状态栏
        changeTintBarColor();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 结束Activity&从堆栈中移除
        AppManager.getAppManager().finishActivity(this);
    }

    /**
     * 沉浸式状态栏
     */
    private void changeTintBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

            if(!(this instanceof MainActivity)){
                window.setFlags(
                        WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION,
                        WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
                // 创建状态栏的管理实例
                SystemBarTintManager tintManager = new SystemBarTintManager(this);
                // 激活状态栏设置
                tintManager.setStatusBarTintEnabled(true);
                // 激活导航栏设置
                tintManager.setNavigationBarTintEnabled(true);
                tintManager.setTintColor(Color.parseColor("#409be4"));
            }
        }
    }

}
