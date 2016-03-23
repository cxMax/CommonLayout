package com.max.administrator.commonlayout.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.max.administrator.commonlayout.R;
import com.max.administrator.commonlayout.common.baseadapter.utils.factory.MyTypeFactory;
import com.max.administrator.commonlayout.common.baseadapter.utils.factory.TypeFactory;
import com.max.administrator.commonlayout.common.baseadapter.utils.factory.bean.LoginItem;
import com.max.administrator.commonlayout.common.baseadapter.utils.factory.bean.LoginType;
import com.max.administrator.commonlayout.common.baseclass.TrainOnlineBaseActivity;

import java.util.List;


/**
 * 忘记密码---账号和密码
 * 继承ItemClickListener接口,实现各控件相关业务
 *
 * @author max
 * 
 */
public class CommonLayoutForgetPassActivity extends TrainOnlineBaseActivity{
	private List<LoginItem> items;
	private Button signTV;
	/**
	 * 初始化自身的View
	 */
	@Override
	public void initView() {
		super.initView();
		signTV = (Button) findViewById(R.id.login_signTV);
		signTV.setText("下一步");
		signTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CommonLayoutForgetPassActivity.this,CommonLayoutSetPassActivity.class));
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
		getActionbar().getActionCenterBtn().setText("账号密码");
	}

}
