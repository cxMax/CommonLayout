package com.max.administrator.commonlayout.common.baseadapter.utils.factory;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * 为各个布局文件绑定监听,具体业务可以直接在对应activity中实现
 * 抽象方法可以随实际业务需求,增加绑定
 * Created by max on 2016/3/16.
 */
public interface ItemClickListener {
    public void itemClick(View view);

    public void codeClick(TextView view, EditText v);//验证码,账号

    public void subItemClick(View view);
}
