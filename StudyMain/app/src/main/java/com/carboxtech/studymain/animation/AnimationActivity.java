package com.carboxtech.studymain.animation;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.carboxtech.studymain.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/****
 *
 *  参考： https://www.jianshu.com/p/2412d00a0ce4
 *
 *  逐帧动画实现对象： AnimationDrawable
 *  逐帧动画 & 补间动画（Tween）存在一定的缺点：
 *  1， 作用对象局限：View
 *  2，没有改变View的属性，只是改变视觉效果，比如平移后view的位置实际上没有改变
 *  3，补间动画只能实现平移、旋转、缩放 & 透明度这些简单的动画需求，动画效果单一
 *
 *  三种动画(逐帧动画，补间动画，属性动画)：可以以xml的方式实现，也可以以代码的方式实现
 *
 *
 * *******/


public class AnimationActivity extends AppCompatActivity {

    Button animBt1,animBt2,animBt3,animBt4;
    TextView showInfo;
    ImageView image;
    String[]  title={"补间动画：位移", "补间动画：旋转","补间动画：透明度","补间动画：缩放" };

    private AnimationDrawable animationDrawable; // 逐帧动画实现对象：



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim);

        image = (ImageView) findViewById(R.id.image);
        showInfo = (TextView) findViewById(R.id.showInfo);
        animBt1 = (Button) findViewById(R.id.animBt1);
        animBt1.setText( title[0] );
        animBt2 = (Button) findViewById(R.id.animBt2);
        animBt2.setText( title[1] );
        animBt3 = (Button) findViewById(R.id.animBt3);
        animBt3.setText( title[2] );
        animBt4 = (Button) findViewById(R.id.animBt4);
        animBt4.setText( title[3] );

        animBt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tween_effect("translate");
            }
        });
        animBt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tween_effect("rotate");
            }
        });
        animBt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tween_effect("alpha");
            }
        });
        animBt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tween_effect("scale");
            }
        });

        String info="三种动画(逐帧动画，补间动画，属性动画)：可以以xml的方式实现，也可以以代码的方式实现\n";
        showInfo.setText(info);
        try {
            getAssetsImage();
        } catch (IOException e) {
            e.printStackTrace();
        }
        frame_effect(false);
    }

    // 补间动画
    private void tween_effect(String type){

        switch (type){
            case "alpha":
//                 纯代码实现
//                AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
//                anim.setDuration(3000);
//                image.startAnimation(anim);

                Animation animation_alpha=AnimationUtils.loadAnimation(this, R.anim.alpha_one);
                image.startAnimation( animation_alpha );
                break;
            case "scale":
                Animation animation_scale=AnimationUtils.loadAnimation(this, R.anim.scale_one);
                image.startAnimation( animation_scale );
                break;

            case "rotate":
                Animation animation_rotate=AnimationUtils.loadAnimation(this, R.anim.rotate_one);
                image.startAnimation( animation_rotate );
                break;
            case "translate":
                Animation animation_translate=AnimationUtils.loadAnimation(this, R.anim.translate_one);
                image.startAnimation( animation_translate );
                break;

        }



    }


    //实现帧动画
    private void  frame_effect (boolean isXml){
        if(isXml){
            //  1. xml实现帧动画：
            image.setImageResource(R.drawable.wuzei_animation);
            animationDrawable= (AnimationDrawable) image.getDrawable();
            animationDrawable.start();
        }else {
            //  2. 代码实现帧动画：
            animationDrawable = new AnimationDrawable();
            try {
                List<Drawable> pciDrawable= getAssetsImage();
                for(Drawable drawable: pciDrawable ){
                    animationDrawable.addFrame(drawable,100);
                    Log.w("test"," animationDrawable.addFrame: "+ drawable.getAlpha());
                }
                animationDrawable.setOneShot(false);
                image.setBackground(animationDrawable);


            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        animationDrawable.start();  //view 在  onResume 才完成了宽高的测量
    }

    // 从 assets 中读取图片转化为 Drawable
    private  List<Drawable>  getAssetsImage() throws IOException {
        String folderName="reqiqiu";
        List<Drawable> pciDrawable = new ArrayList<>();
        String[] path = getAssets().list(folderName);//填入目录获取该目录下所有资源
        for(int i = 0; i < path.length; i++){
            if (path[i].endsWith(".png")  ){  // 根据图片特征找出图片
                InputStream is = getResources().getAssets().open(folderName+"/"+path[i]);
                pciDrawable.add( Drawable.createFromStream(is, null) ) ;
            }
        }
        return pciDrawable;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        animationDrawable.stop();
    }
}
