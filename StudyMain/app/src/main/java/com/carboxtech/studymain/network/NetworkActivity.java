package com.carboxtech.studymain.network;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.carboxtech.studymain.R;
import com.carboxtech.studymain.tool.AssetsTool;

public class NetworkActivity extends AppCompatActivity {

    private TextView netInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);

        netInfo= (TextView) findViewById(R.id.netInfo);
        netInfo.setText( AssetsTool.getText("网络.txt",this));
    }


}
