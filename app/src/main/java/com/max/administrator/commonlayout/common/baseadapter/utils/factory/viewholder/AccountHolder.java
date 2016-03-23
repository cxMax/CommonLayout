package com.max.administrator.commonlayout.common.baseadapter.utils.factory.viewholder;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import com.max.administrator.commonlayout.R;

/**
 * 登录模块账号的item
 * 
 * @author max
 * 
 */
public class AccountHolder extends RecyclerView.ViewHolder {
	public EditText account;

	public EditText getAccount() {
		return account;
	}

	public AccountHolder(View view) {
		super(view);
		account = (EditText) view.findViewById(R.id.baselogin_acountET);
	}

}
