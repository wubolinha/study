package com.carboxtech.studymain.javabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.carboxtech.studymain.R;
import com.carboxtech.studymain.tool.AssetsTool;

import java.lang.reflect.Proxy;

public class JavaBaseTestActivity extends AppCompatActivity {

    TextView jbt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_base_test2);
        jbt1 = (TextView) findViewById(R.id.jbt1);
        jbt1.setText(    AssetsTool.getText("java基础.txt",this)    );

    }





}
