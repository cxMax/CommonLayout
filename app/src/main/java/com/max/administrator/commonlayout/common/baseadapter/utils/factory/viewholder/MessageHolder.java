package com.max.administrator.commonlayout.common.baseadapter.utils.factory.viewholder;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.max.administrator.commonlayout.R;

/**
 * 登录模块账号和验证码的item
 * @author max
 *
 */
public class MessageHolder extends RecyclerView.ViewHolder{
	public EditText account; //账号
	public TextView code; //验证码
	
	public EditText getAccount() {
		return account;
	}



	public TextView getCode() {
		return code;
	}



	public MessageHolder(View view) {
		super(view);
		account = (EditText) view.findViewById(R.id.baselogin_accountET);
		code = (TextView) view.findViewById(R.id.baselogin_codeET);
	}

}
