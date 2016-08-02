package com.gyw.groupbuttonview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

/**
 * 按钮数组，两个字符串数组names、codes，按钮上面显示names的内容，点击按钮 可以选中某个按钮并且根据codes的内容来判断选中的哪个按�?
 *
 */
public class GroupButtonView extends LinearLayout {

	RadioGroup mRg;

	private Context mContext;
	private OnGroupBtnClickListener listener;

	private String groupBtnName = "A#B";
	private String groupBtnCode = "1#2";

	public GroupButtonView(Context context) {
		this(context, null);
	}

	public GroupButtonView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public GroupButtonView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		this.mContext = context;

		TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.GroupButtonView);
		groupBtnName = ta.getString(R.styleable.GroupButtonView_groupBtnNameText);
		groupBtnCode = ta.getString(R.styleable.GroupButtonView_groupBtnCodeText);

		ta.recycle();

		initContentView();
		initView();
		initData();
	}

	private void initContentView() {
		View.inflate(mContext, R.layout.view_item_group_buttons, this);

		mRg = (RadioGroup) findViewById(R.id.rg_item_group_btn);

	}

	private void initView() {
		String[] btnNameArr = groupBtnName.split("#");
		String[] btnCodeArr = groupBtnCode.split("#");

		Log.d("gyw",  btnNameArr.length + "   length  :" + btnCodeArr.length);

		if ((btnNameArr.length < 2) || (btnCodeArr.length < 2)) {
			throw new RuntimeException("names和codes的格式不正确...");
		}

		for (int i = 0; i < btnCodeArr.length; i++) {

			//使用布局文件写方便
			RadioButton rb = (RadioButton) View.inflate(mContext, R.layout.view_item_group_radio_button, null);

			if (btnCodeArr.length == 2) {
				if (i == 0) {
					rb.setBackgroundResource(R.drawable.left_button_selector);
					rb.setChecked(true);
				} else if (i == 1) {
					rb.setBackgroundResource(R.drawable.right_button_selector);
				}
			} else {
				if (i == 0) {
					rb.setBackgroundResource(R.drawable.left_button_selector);
					rb.setChecked(true);
				} else if (i == btnCodeArr.length - 1) {
					rb.setBackgroundResource(R.drawable.right_button_selector);
				} else {

					rb.setBackgroundResource(R.drawable.mid_button_selector);
				}
			}

			rb.setId(i);
			rb.setTag(btnCodeArr[i]);
			rb.setText(btnNameArr[i]);

			mRg.addView(rb);
		}
	}

	private void initData() {
		mRg.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup rg, int i) {
				RadioButton rb = (RadioButton) findViewById(i);
				if (rb.isChecked()) {
					if (listener != null) {
						listener.groupBtnClick(rb.getTag().toString());
					}
				}
			}
		});
	}

	public interface OnGroupBtnClickListener {
		public void groupBtnClick(String code);
	}

	public void setOnGroupBtnClickListener(OnGroupBtnClickListener listener) {
		this.listener = listener;
	}
}
