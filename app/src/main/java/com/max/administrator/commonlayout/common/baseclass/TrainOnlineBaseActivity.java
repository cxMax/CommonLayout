package com.max.administrator.commonlayout.common.baseclass;

import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.max.administrator.commonlayout.R;
import com.max.administrator.commonlayout.common.BaseGenerateListener;
import com.max.administrator.commonlayout.common.baseadapter.CommonLayoutRecyclerAdapter;
import com.max.administrator.commonlayout.common.baseadapter.utils.factory.ItemClickListener;
import com.max.administrator.commonlayout.common.baseadapter.utils.widget.DividerItemDecoration;
import com.max.administrator.commonlayout.common.baseadapter.utils.widget.WrapHeightLinearLayoutManager;
import com.max.administrator.commonlayout.utils.uitools.CommonToast;


/**
 * 用友共同布局的activity基类
 * todo 组件间通信之前用的handler和广播实现,现在改成eventbus
 * @author max
 * 
 */
public class TrainOnlineBaseActivity extends BaseActivity implements BaseGenerateListener,
		BaseActionBar.OnActionBarClick, ItemClickListener {
	private BaseActionBar actionbar;
	public Context mContext;
	public CommonLayoutRecyclerAdapter mRecyclerAdapter;
	public RecyclerView mRecyclerView;
	private CountDownTimer codeTimer;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.max_baselogin_activity);
        initSerial();
		initView();
		initType();
		initActionBar();
		initViewRecyclerView();
	}


	@Override
	public void initSerial() {
		mContext = this;
	}

	@Override
	public void initType() {

	}

	@Override
	public void initView() {

	}


	@Override
	public void initViewRecyclerView() {
		mRecyclerView = (RecyclerView) findViewById(R.id.login_optionLayout);
		WrapHeightLinearLayoutManager layoutManager = new WrapHeightLinearLayoutManager(this);
		layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
		mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(layoutManager.getOrientation(),this));
		mRecyclerAdapter = new CommonLayoutRecyclerAdapter(mContext);
        mRecyclerAdapter.setListener(this);
	}

	@Override
	public void initActionBar() {
		actionbar = new BaseActionBar(this, findViewById(R.id.base_actionbar));
		actionbar.setClick(this);
	}


	public BaseActionBar getActionbar() {
		return actionbar;
	}

	@Override
	public void onActionBarClick(View view) {
		switch (view.getId()) {
		case R.id.top_left:
			finish();
			break;

		default:
			break;
		}
	}

	// 各个子类重写该点击事件
	// 账号的点击事件
	@Override
	public void itemClick(View view) {

	}

	// 验证码的点击事件
	@Override
	public void codeClick(TextView view,EditText acount) {
		StartTimeer(view, 60 * 1000, 1 * 1000);
	}

	/**
	 * 计时器
	 * 
	 * @param countTime
	 * @param interval
	 */
	private void StartTimeer(final TextView textView,long countTime, long interval) {
		codeTimer = new CountDownTimer(countTime, interval) {
			public void onTick(long millisUntilFinished) {
				textView.setText((millisUntilFinished / 1000) + "s");
			}

			public void onFinish() {
				textView.setClickable(true);
				textView.setEnabled(true);
				textView.setText("获取验证码");
			}
		}.start();
		textView.setClickable(false);
	}

	// 密码的点击事件
	@Override
	public void subItemClick(View view) {

	}


	/**
	 * 设置显示时间
	 * 
	 * @param message
	 * @param gravity
	 * @param time
	 */
	public void showToast(String message, int gravity, long time) {
		CommonToast toast = new CommonToast(TrainOnlineBaseActivity.this);
		toast.setDuration(time);
		toast.setMessage(message);
		toast.setLayoutGravity(gravity);
		toast.show();
	}

}
