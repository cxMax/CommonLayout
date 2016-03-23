package com.max.administrator.commonlayout.activity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.max.administrator.commonlayout.R;
import com.max.administrator.commonlayout.common.baseadapter.utils.factory.MyTypeFactory;
import com.max.administrator.commonlayout.common.baseadapter.utils.factory.TypeFactory;
import com.max.administrator.commonlayout.common.baseadapter.utils.factory.bean.LoginItem;
import com.max.administrator.commonlayout.common.baseadapter.utils.factory.bean.SetPassType;
import com.max.administrator.commonlayout.common.baseclass.TrainOnlineBaseActivity;

import java.util.List;


/**
 * 用户设置账号和密码
 * 从哪个页面过来的,1注册页/2忘记密码页/3修改密码/4 邦定手机号（短信登录当前用户未注册时）
 * @author max
 * 
 */
public class CommonLayoutSetPassActivity extends TrainOnlineBaseActivity {
	private List<LoginItem> items;
	private Button signTV;
    private TextView hintTV;

	/**
	 * 初始化自身的View
	 */
	@Override
	public void initView() {
		super.initView();
		signTV = (Button) findViewById(R.id.login_signTV);
		signTV.setText("确定");
        hintTV = (TextView) findViewById(R.id.login_hintTV);
        hintTV.setVisibility(View.VISIBLE);
	}

	@Override
	public void initType() {
		super.initType();
		TypeFactory factory = new MyTypeFactory();
		SetPassType type = factory.createType(SetPassType.class);
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
		getActionbar().getActionCenterBtn().setText("账号密码");
	}

}
