package com.dgtech.sss.titlebarviewdemo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by sss on 2017/8/29.
 */

public class TitleBarView extends LinearLayout {
    private boolean isHideRight = false;
    private int leftImgId;
    private String title;
    private String right;
    private int titleSize;
    private int rightSize;
    private int bg;
    private int titleColor;
    private int rightColor;
    public TitleBarView(Context context) {
        this(context,null);
    }

    public TitleBarView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        View view = View.inflate(context, R.layout.title_bar,this);
        init(context, attrs, view);

    }

    private void init(Context context, @Nullable AttributeSet attrs, View view) {
        ImageView iv_back = view.findViewById(R.id.iv_back);
        TextView tv_right = view.findViewById(R.id.tv_right);
        TextView tv_title = view.findViewById(R.id.tv_title);
        RelativeLayout title_layout = view.findViewById(R.id.title_layout);
        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.TitleBarView);
        try {
            isHideRight = typedArray.getBoolean(R.styleable.TitleBarView_isHideRight,false);
            leftImgId = typedArray.getResourceId(R.styleable.TitleBarView_leftImg,R.mipmap.top_backup_black);
            title = typedArray.getString(R.styleable.TitleBarView_title);
            right = typedArray.getString(R.styleable.TitleBarView_right);
            titleSize = typedArray.getDimensionPixelSize(R.styleable.TitleBarView_titleSize,
                    (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 17, getResources().getDisplayMetrics()));
            rightSize = typedArray.getDimensionPixelSize(R.styleable.TitleBarView_rightSize,
                    (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics()));
            bg = typedArray.getColor(R.styleable.TitleBarView_content_bg, Color.parseColor("#ffffff"));
            titleColor = typedArray.getColor(R.styleable.TitleBarView_title_color,Color.parseColor("#474747"));
            rightColor = typedArray.getColor(R.styleable.TitleBarView_right_color,Color.parseColor("#474747"));
        }finally {
            typedArray.recycle();
        }
        if (isHideRight){
            tv_right.setVisibility(GONE);
        }else {
            tv_right.setVisibility(VISIBLE);
        }
        iv_back.setImageDrawable(context.getDrawable(leftImgId));
        if (title != null){
            tv_title.setText(title);
            tv_title.setVisibility(VISIBLE);
        }else {
            tv_title.setVisibility(GONE);
        }
        if (right != null){
            tv_right.setText(right);
            tv_right.setVisibility(VISIBLE);
        }else {
            tv_right.setVisibility(GONE);
        }
        tv_title.setTextSize(TypedValue.COMPLEX_UNIT_PX,titleSize);
        tv_right.setTextSize(TypedValue.COMPLEX_UNIT_PX,rightSize);
        title_layout.setBackgroundColor(bg);
        tv_title.setTextColor(titleColor);
        tv_right.setTextColor(rightColor);
    }

}
