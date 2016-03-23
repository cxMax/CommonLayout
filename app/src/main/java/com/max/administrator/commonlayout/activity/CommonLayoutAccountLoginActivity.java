package com.max.administrator.commonlayout.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.max.administrator.commonlayout.R;
import com.max.administrator.commonlayout.common.baseadapter.utils.factory.MyTypeFactory;
import com.max.administrator.commonlayout.common.baseadapter.utils.factory.TypeFactory;
import com.max.administrator.commonlayout.common.baseadapter.utils.factory.bean.AcAndPasType;
import com.max.administrator.commonlayout.common.baseadapter.utils.factory.bean.LoginItem;
import com.max.administrator.commonlayout.common.baseclass.TrainOnlineBaseActivity;

import java.util.List;

/**
 * 账号登录 
 * 继承ItemClickListener接口,实现各控件相关业务
 * @author max
 * 
 */
public class CommonLayoutAccountLoginActivity extends TrainOnlineBaseActivity{
	private List<LoginItem> items;
	private Button signTV;
    private TextView forgetTV;

	@Override
	public void initView() {
		super.initView();
		signTV = (Button) findViewById(R.id.login_signTV);
        forgetTV = (TextView) findViewById(R.id.login_forgetTV);
        forgetTV.setVisibility(View.VISIBLE);
        forgetTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CommonLayoutAccountLoginActivity.this,CommonLayoutForgetPassActivity.class));
            }
        });
	}

	@Override
	public void initType() {
		TypeFactory factory = new MyTypeFactory();
		AcAndPasType type = factory.createType(AcAndPasType.class);
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
        mRecyclerAdapter.setSignTV(signTV);
	}

	@Override
	public void initActionBar() {
		super.initActionBar();
		getActionbar().getActionLiftBtn();
		getActionbar().getActionCenterBtn().setText("账号密码登录");
		getActionbar().getActionRightBtn().setText("注册");

	}
	/**
	 * 左边按钮统一是返回,右边按钮根据各页面需求来写
	 */
	@Override
	public void onActionBarClick(View view) {
		switch (view.getId()) {
		case R.id.top_right:
			// 跳转到注册页面
			startActivity(new Intent(CommonLayoutAccountLoginActivity.this,
					CommonLayoutRegisterActivity.class));
			break;
		case R.id.top_left:
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
