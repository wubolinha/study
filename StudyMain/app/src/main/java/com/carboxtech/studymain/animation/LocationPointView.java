package com.carboxtech.studymain.animation;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by admin on 2018/11/26.
 * <p>
 * 地图定位点波纹效果  使用属性动画（Property Animation） ValueAnimator 类 & ObjectAnimator 类，ObjectAnimator是从ValueAnimator中继承的
 *   雷达搜索扩散圆从无到有： https://juejin.im/entry/597095ef5188254d351682d0
 *  混合绘制：  https://blog.csdn.net/u014452224/article/details/55193542?utm_source=blogxgwz9
 */

public class LocationPointView extends View {

    private Paint mDiffusePaint, mCenterPaint;
    //透明度
    private int mAlpha = 255;
    //圆心X
    private float mCenterX;
    //圆心Y
    private float mCenterY;
    //中心圆半径
    private float mInnerCircleRadius = 50;
    //扩散圆 半径 取控件的长度最小值
    private  float minRadius;
    //扩散圆扩散宽度
    private float mDiffuseWidth = 0;
    // 开始扩散
    private boolean startDiffseBoolean=true;

    public LocationPointView(Context context) {
        super(context);
        initView();
    }

    public LocationPointView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public LocationPointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        //扩散圆画笔初始化,抗锯齿
        mDiffusePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        //防抖动
        mDiffusePaint.setDither(true);
        mDiffusePaint.setColor(Color.BLUE);
        //填充
        mDiffusePaint.setStyle(Paint.Style.FILL);
        mDiffusePaint.setStrokeWidth(4);

        //中心画笔初始化
        mCenterPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        //防抖动
        mCenterPaint.setDither(true);
        mCenterPaint.setStyle(Paint.Style.FILL);
        mCenterPaint.setColor(Color.RED);
    }

    /************** 测量控件宽高
     *  测量模式: UNSPECIFIED:父容器没有对当前View有任何限制，当前View可以任意取尺寸
     *            EXACTLY:	当前的尺寸就是当前View应该取的尺寸
     *            AT_MOST:	当前尺寸是当前View能取的最大尺寸
     *
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getSize( 100 , widthMeasureSpec );
        int height = getSize( 100 , heightMeasureSpec );
        if(width<height){
            height=width;
        }else {
            width=height;
        }
        setMeasuredDimension( width ,height);// 决定了当前View的大小
    }

    private int getSize(int defaultSize, int measureSpec) {
        int resultSize = defaultSize;
        int mode = MeasureSpec.getMode(measureSpec);
        int size = MeasureSpec.getSize(measureSpec);
        switch (mode) {
            case MeasureSpec.UNSPECIFIED:  //父容器没有对当前View有任何限制，当前View可以任意取尺寸
                resultSize =defaultSize;
                break;
            case MeasureSpec.AT_MOST:  //当前尺寸是当前View能取的最大尺寸
                resultSize =size;
                break;
            case MeasureSpec.EXACTLY:  //当前的尺寸就是当前View应该取的尺寸
                resultSize =size;
                break;

        }
        return resultSize;
    }


    // onLayout方法是ViewGroup中子View的布局方法,用于放置子View的位置
    // 传下来的l,t,r,b分别是放置父控件的矩形可用空间
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    // 在控件大小发生改变时调用。所以这里初始化会被调用一次
    //  作用：获取控件的宽和高度
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        //获取到中心圆坐标
        mCenterX = w/2;
        mCenterY = h/2;
        minRadius = Math.min(mCenterX,mCenterY);
        mInnerCircleRadius = w/8;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 设置透明度
        mDiffusePaint.setAlpha(mAlpha);
        //画扩散圆
        mAlpha=mAlpha-5;
        mDiffuseWidth =mDiffuseWidth+1;
        if(mAlpha<= 0 || mDiffuseWidth >= minRadius){
            mAlpha =255;
            mDiffuseWidth = mInnerCircleRadius;
        }
        //画扩散圆
        canvas.drawCircle(mCenterX, mCenterY, mDiffuseWidth, mDiffusePaint);
        //画中心圆
        canvas.drawCircle(mCenterX, mCenterY, mInnerCircleRadius, mCenterPaint);
        if (startDiffseBoolean) {
            postInvalidate();  // 会触发onDraw() ，实现重复重绘
        }
        Log.w("test","onDraw   扩散圆扩散宽度: "+mDiffuseWidth+"  透明度: "+mAlpha);
    }

    @Override
    public void postInvalidate() {
        if( hasWindowFocus() ){
            super.postInvalidate();
        }
    }



}
