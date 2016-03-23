package com.max.administrator.commonlayout.common.baseadapter.utils.factory.viewholder;


import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.max.administrator.commonlayout.R;
import com.max.administrator.commonlayout.utils.uitools.ClearEditText;

/**
 * 修改名字
 * 
 * @author max
 * 
 */
public class ModifyNameHolder extends RecyclerView.ViewHolder {
	public ClearEditText name;

	public ClearEditText getName() {
		return name;
	}

	public void setName(ClearEditText name) {
		this.name = name;
	}

	public ModifyNameHolder(View view) {
		super(view);
		name = (ClearEditText) view.findViewById(R.id.user_info_nameLayout_nameET);
	}

}
