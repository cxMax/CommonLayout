package com.max.administrator.commonlayout.common;

/**
 * 初始化一个activity需要的步骤
 * Created by max on 2016/3/17.
 */
public interface BaseGenerateListener {
    /**
     * 初始化常量
     */
    void initSerial();
    /**
     * 初始化视图参数
     */
    void initType();

    /**
     * 初始化视图控件
     */
    void initView();

    /**
     * 初始化视图布局
     */
    void initViewRecyclerView();

    /**
     * 初始化顶部actionbar
     */
    void initActionBar();
}
