package com.carboxtech.studymain.androidBase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.carboxtech.studymain.R;
import com.carboxtech.studymain.tool.AssetsTool;

public class AndroidBaseActivity extends AppCompatActivity {

    private TextView androidBaseInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_base);
        androidBaseInfo= (TextView) findViewById(R.id.androidBaseInfo);
        androidBaseInfo.setText( AssetsTool.getText("Android基础.txt",this));
    }
}
