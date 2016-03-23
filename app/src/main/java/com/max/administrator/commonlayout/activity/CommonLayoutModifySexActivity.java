package com.max.administrator.commonlayout.activity;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.max.administrator.commonlayout.R;
import com.max.administrator.commonlayout.common.baseadapter.utils.factory.MyTypeFactory;
import com.max.administrator.commonlayout.common.baseadapter.utils.factory.TypeFactory;
import com.max.administrator.commonlayout.common.baseadapter.utils.factory.bean.LoginItem;
import com.max.administrator.commonlayout.common.baseadapter.utils.factory.bean.ModifySexType;
import com.max.administrator.commonlayout.common.baseclass.TrainOnlineBaseActivity;

import java.util.List;

/**
 * 修改用户个人性别
 *
 * @author max
 */
public class CommonLayoutModifySexActivity extends TrainOnlineBaseActivity {
    private Context mContext;
    private List<LoginItem> items;
    private Button signTV;
    private String sexNew;

    @Override
    public void initSerial() {
        super.initSerial();
        mContext = this;
    }

    /**
     * 初始化自身的View
     */
    @Override
    public void initView() {
        super.initView();
        signTV = (Button) findViewById(R.id.login_signTV);
        signTV.setVisibility(View.GONE);
    }

    @Override
    public void initType() {
        super.initType();
        TypeFactory factory = new MyTypeFactory();
        ModifySexType type = factory.createType(ModifySexType.class);
        items = type.selfType();
    }

    /**
     * 初始化列表
     */
    @Override
    public void initViewRecyclerView() {
        super.initViewRecyclerView();
        mRecyclerAdapter.setData(items);
        mRecyclerView.setAdapter(mRecyclerAdapter);
        LinearLayout layout = (LinearLayout) mRecyclerView.getParent();
        layout.setBackgroundColor(Color.parseColor("#ebebeb"));
        mRecyclerAdapter.setSignTV(signTV);
    }

    @Override
    public void initActionBar() {
        super.initActionBar();
        getActionbar().getActionLiftBtn();
        getActionbar().getActionCenterBtn().setText("性别");
        getActionbar().getActionRightBtn().setText("保存");

    }

    @Override
    public void onActionBarClick(View view) {
        switch (view.getId()) {
            case R.id.top_left:
                onBackPressed();
                break;
            case R.id.top_right:
                onBackPressed();
                break;

            default:
                break;
        }
    }

    @Override
    public void onBackPressed() {
        finish();

    }
}
