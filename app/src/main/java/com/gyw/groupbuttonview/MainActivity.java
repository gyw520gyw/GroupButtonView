package com.gyw.groupbuttonview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GroupButtonView gbv1 = (GroupButtonView) findViewById(R.id.gbv1);

        gbv1.setOnGroupBtnClickListener(new GroupButtonView.OnGroupBtnClickListener() {
            @Override
            public void groupBtnClick(String code) {
                Toast.makeText(MainActivity.this, code, Toast.LENGTH_SHORT).show();
            }
        });


        GroupButtonView gbv2 = (GroupButtonView) findViewById(R.id.gbv2);

        gbv2.setOnGroupBtnClickListener(new GroupButtonView.OnGroupBtnClickListener() {
            @Override
            public void groupBtnClick(String code) {
                Toast.makeText(MainActivity.this, code, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
