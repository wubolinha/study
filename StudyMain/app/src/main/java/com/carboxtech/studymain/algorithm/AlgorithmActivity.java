package com.carboxtech.studymain.algorithm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.carboxtech.studymain.R;
import com.carboxtech.studymain.tool.AssetsTool;

public class AlgorithmActivity extends AppCompatActivity {

    private TextView algorithmInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_algorithm);

        algorithmInfo= (TextView) findViewById(R.id.algorithmInfo);
        algorithmInfo.setText( AssetsTool.getText("算法.txt",this));
    }



}
