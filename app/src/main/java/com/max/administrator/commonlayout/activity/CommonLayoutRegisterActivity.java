package com.max.administrator.commonlayout.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.max.administrator.commonlayout.R;
import com.max.administrator.commonlayout.common.baseadapter.utils.factory.MyTypeFactory;
import com.max.administrator.commonlayout.common.baseadapter.utils.factory.TypeFactory;
import com.max.administrator.commonlayout.common.baseadapter.utils.factory.bean.LoginItem;
import com.max.administrator.commonlayout.common.baseadapter.utils.factory.bean.LoginType;
import com.max.administrator.commonlayout.common.baseclass.TrainOnlineBaseActivity;

import java.util.List;

/**
 * 注册 继承ItemClickListener接口,实现各控件相关业务
 * 
 * @author max
 * 
 */
public class CommonLayoutRegisterActivity extends TrainOnlineBaseActivity {

	private List<LoginItem> items;
	private Button signTV; // 登录按钮
    private LinearLayout readTV; // 阅读更多

	/**
	 * 初始化自身的View
	 */
	@Override
	public void initView() {
		super.initView();
		signTV = (Button) findViewById(R.id.login_signTV);
		signTV.setText("下一步");
        readTV = (LinearLayout) findViewById(R.id.login_readTV);
        readTV.setVisibility(View.VISIBLE);
        readTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CommonLayoutRegisterActivity.this,CommonLayoutModifySexActivity.class));
            }
        });
	}

	@Override
	public void initType() {
		super.initType();
		TypeFactory factory = new MyTypeFactory();
		LoginType type = factory.createType(LoginType.class);
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
		getActionbar().getActionCenterBtn().setText("注册");

	}

}
