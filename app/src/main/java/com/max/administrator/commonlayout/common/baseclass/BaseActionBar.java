package com.max.administrator.commonlayout.common.baseclass;


import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.max.administrator.commonlayout.R;
import com.max.administrator.commonlayout.utils.TextViewDrawableUtils;

/**
 * 可以通用的actionbar
 * @author max
 *
 */
public class BaseActionBar implements OnClickListener{
	private final Context mContext;
	private View actionLayout;
	private TextView left;
	private TextView center;
	private TextView right;
	private OnActionBarClick click;
	
	public BaseActionBar(Context context, View view) {
		super();
		this.mContext = context;
		this.actionLayout = view;
		init();
	}



	private void init() {
		if (actionLayout != null) {
			left = (TextView) actionLayout.findViewById(R.id.top_left);
			center = (TextView) actionLayout.findViewById(R.id.top_center);
			right = (TextView) actionLayout.findViewById(R.id.top_right);
			left.setOnClickListener(this);
			center.setOnClickListener(this);
			right.setOnClickListener(this);
		}
	}

	 public void setActionBarIcon(int drawableid,TextView actionbarbtn){
	        switch (actionbarbtn.getId()){
	            case R.id.top_left:
	                TextViewDrawableUtils.setDrawable(actionbarbtn, mContext.getResources().getDrawable((drawableid)), null, null, null);
	                break;
	            case R.id.top_right:
	                TextViewDrawableUtils.setDrawable(actionbarbtn,null,null,mContext.getResources().getDrawable((drawableid)),null);
	                break;
	            case R.id.top_center:
	                TextViewDrawableUtils.setDrawable(actionbarbtn,mContext.getResources().getDrawable((drawableid)),null,null,null);
	                break;
	        }
	    }

	    public View getActionLayout() {
	        return actionLayout;
	    }

	    public TextView getActionLiftBtn() {
	    	left.setVisibility(View.VISIBLE);
	        return left;
	    }

	    public TextView getActionRightBtn() {
	    	right.setVisibility(View.VISIBLE);
	        return right;
	    }

	    public TextView getActionCenterBtn() {
	    	center.setVisibility(View.VISIBLE);
	        return center;
	    }

	    @Override
	    public void onClick(View v) {
	        click.onActionBarClick(v);
	    }

	    public void setClick(OnActionBarClick click) {
	        this.click = click;
	    }

	    public interface OnActionBarClick{
	        void onActionBarClick(View view);
	    }


}
