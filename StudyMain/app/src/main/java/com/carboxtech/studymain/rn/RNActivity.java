package com.carboxtech.studymain.rn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.carboxtech.studymain.R;
import com.carboxtech.studymain.tool.AssetsTool;

public class RNActivity extends AppCompatActivity {

    private TextView rnDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rn);
        rnDetail = (TextView) findViewById(R.id.rnDetail);

        rnDetail.setText(    AssetsTool.getText("RN总结.txt",this)    );
    }
}
