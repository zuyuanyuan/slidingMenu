package com.example.slidingdrawer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.Window;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public class MainActivity extends FragmentActivity {
	private SlidingMenu menu;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		// ���ñ���
		setTitle("Attach");

		// ��ʼ�������˵�
		initSlidingMenu();
	}

	/**
	 * ��ʼ�������˵�
	 */
	private void initSlidingMenu() {
		// ������������ͼ
		setContentView(R.layout.content_frame);
		getFragmentManager().beginTransaction()
				.replace(R.id.content_frame, new SampleListFragment(menu)).commit();

		// ���û����˵�������ֵ
		menu = new SlidingMenu(this);
		menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		menu.setShadowWidthRes(R.dimen.shadow_width);
		menu.setShadowDrawable(R.drawable.shadow);
		menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		menu.setFadeDegree(0.35f);
		menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
		// ���û����˵�����ͼ����
		menu.setMenu(R.layout.menu_frame);
		getFragmentManager().beginTransaction()
				.replace(R.id.menu_frame, new SampleListFragment(menu)).commit();
	}
 
	@Override
	public void onBackPressed() {
		// ������ؼ��رջ����˵�
		if (menu.isMenuShowing()) {
			menu.showContent();
		} else {
			super.onBackPressed();
		}
	}

}