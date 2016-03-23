package com.max.administrator.commonlayout.common.baseadapter.utils.factory.viewholder;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.max.administrator.commonlayout.R;

/**
 * 修改性别
 * 
 * @author max
 * 
 */
public class ModifySexHolder extends RecyclerView.ViewHolder {
	public CheckBox sex;
	public TextView sexTv;
	private FrameLayout content;

	public CheckBox getSex() {
		return sex;
	}

	public void setSex(CheckBox sex) {
		this.sex = sex;
	}

	public TextView getSexTv() {
		return sexTv;
	}

	public void setSexTv(TextView sexTv) {
		this.sexTv = sexTv;
	}

	public ModifySexHolder(View view) {
		super(view);
		sex = (CheckBox) view.findViewById(R.id.user_info_sexLayout_sexCB);
		sexTv = (TextView) view.findViewById(R.id.user_info_sexLayout_sexTV);
		content = (FrameLayout) view.findViewById(R.id.user_info_sexLayout_content);
		content.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				sex.setChecked(!sex.isChecked());
			}
		});
	}

}
