#discription
Android 只显示的TextView，显示不了的字体缩小显示 ! 

#usage

xml : 
```

<com.gyw.groupbuttonview.GroupButtonView
            android:id="@+id/gbv2"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginTop="40dp"
            app:groupBtnCodeText="week#mon#year#all"
            app:groupBtnNameText="周#月#年#总">
</com.gyw.groupbuttonview.GroupButtonView>
```


code:

```

GroupButtonView gbv1 = (GroupButtonView) findViewById(R.id.gbv1);
gbv1.setOnGroupBtnClickListener(new GroupButtonView.OnGroupBtnClickListener() {
	@Override
	public void groupBtnClick(String code) {
		Toast.makeText(MainActivity.this, code, Toast.LENGTH_SHORT).show();
	}
});
```




#Screenshot
screenshot/GroupButtonView.gif
