package com.max.administrator.commonlayout.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * 获取屏幕信息类
 * @author max
 *
 */
public class DisplayUtils {
	
	private static WindowManager wm = null;
	private static DisplayMetrics dm = null;
	
	/**
	 * 获取屏幕宽度
	 * @return
	 */
	public static int getDisplayWidth(Context context){
		if(wm == null){
			wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		}
		
		if(dm == null){
			dm = new DisplayMetrics();
		}
		 
		wm.getDefaultDisplay().getMetrics(dm);

        return dm.widthPixels;
	}
	
	/**
	 * 获取屏幕高度
	 * @return
	 */
	public static int getDisplayHeight(Context context){
		if(wm == null){
			wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		}
		
		if(dm == null){
			dm = new DisplayMetrics();
		}
		
		wm.getDefaultDisplay().getMetrics(dm);

        return dm.heightPixels;
	}
	/**
	 * 根据手机的分辨率从 dp的单位 转成为 px
	 */
	public static int dip2px(Context context, float dpValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dpValue * scale + 0.5f);
	}

	/**
	 * 根据手机的分辨率从 px的单位 转成为 dp
	 */
	public static int px2dip(Context context, float pxValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (pxValue / scale + 0.5f);
	}

	/**
	 * sp转px
	 *
	 * @param context
	 * @param spVal
	 * @return
	 */
	public static int sp2px(Context context, float spVal)
	{
		final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
		return (int) (spVal * fontScale + 0.5f);
	}

	/**
	 * px转sp
	 *
	 * @param context
	 * @param pxVal
	 * @return
	 */
	public static float px2sp(Context context, float pxVal)
	{
		final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
		return (int) (pxVal / fontScale + 0.5f);
	}
}
