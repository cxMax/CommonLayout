package com.max.administrator.commonlayout.common.baseadapter.utils.factory.viewholder;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import com.max.administrator.commonlayout.R;

/**
 * 登录模块密码的item
 * 
 * @author max
 * 
 */
public class PasswordHolder extends RecyclerView.ViewHolder {
	public EditText password;

	public EditText getPassword() {
		return password;
	}

	public PasswordHolder(View view) {
		super(view);
		password = (EditText) view.findViewById(R.id.baselogin_passwordET);
	}

}
