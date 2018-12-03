package com.carboxtech.studymain.mvp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.carboxtech.studymain.R;
import com.carboxtech.studymain.mvp.Interface.MvpView;
import com.carboxtech.studymain.mvp.Presenter.MvpPresenter;
/*****
 *
 *    mvp 与 dagger2  混合使用
 *
 *    Android MVP架构搭建:
 *   http://www.jcodecraeer.com/a/anzhuokaifa/2017/1020/8625.html?1508484926
 *
 * *****/

public class MvpTestActivity extends Activity implements MvpView {

    TextView mvpinfo;
    Button mvpbt1, mvpbt2, mvpbt3;
    MvpPresenter presenter;
    //进度条
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp_test);

        mvpinfo = findViewById(R.id.mvpinfo);
        mvpbt1 = findViewById(R.id.mvpbt1);
        mvpbt2 = findViewById(R.id.mvpbt2);
        mvpbt3 = findViewById(R.id.mvpbt3);

        mvpinfo.setText("mvp 信息： ");
        mvpbt1.setText("获取网络数据成功");
        mvpbt2.setText("获取网络数据异常");
        mvpbt3.setText("获取网络数据失败");

        presenter = new MvpPresenter();
        presenter.attachActivity(this);

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("正在加载数据");

        mvpbt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.getData("success");
            }
        });
        mvpbt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.getData("failure");
            }
        });
        mvpbt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.getData("error");
            }
        });
    }

    /*******
     *
     *  在请求过程中当前Activity突然因为某种原因被销毁，Presenter收到后台反馈并调用View接口处理UI逻辑时
     *  由于Activity已经被销毁，就会引发空指针异常。
     *
     * ********/
    @Override
    public void showLoading() {
        mvpinfo.setText("数据加载中.... ");
        if (!progressDialog.isShowing()) {
            progressDialog.show();
        }
    }

    @Override
    public void hideLoading() {
        //  mvpinfo.setText("数据加载完毕 ..... ");
        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    @Override
    public void showData(String data) {
        mvpinfo.setText("显示数据： " + data);
    }

    @Override
    public void showFailureMessage(String msg) {
        mvpinfo.setText("异常信息： " + msg);
    }

    @Override
    public void showErrorMessage() {
        mvpinfo.setText("数据加载错误 ");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachActivity();
    }

    @Override
    public Context getContext() {
        return this;
    }
}
