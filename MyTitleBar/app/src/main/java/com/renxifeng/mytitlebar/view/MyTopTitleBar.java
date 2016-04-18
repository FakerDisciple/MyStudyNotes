package com.renxifeng.mytitlebar.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.renxifeng.mytitlebar.R;

/**
 * Created by Rxf on 2016/4/15 0015.
 */
public class MyTopTitleBar extends RelativeLayout {

    private OnMyTopTitleBarClickListener onMyTopTitleBarClickListener;

    public void setOnMyTopTitleBarClickListener(OnMyTopTitleBarClickListener onMyTopTitleBarClickListener) {
        this.onMyTopTitleBarClickListener = onMyTopTitleBarClickListener;
    }

    public MyTopTitleBar(Context context) {
        super(context);
    }

    public MyTopTitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initProperty(context,attrs);
        initView(context);
    }




    public MyTopTitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initProperty(context,attrs);
        initView(context);
    }

    private String titleTextStr;
    private int titleColor;
    private float titleSize;
    private int leftTextColor;
    private Drawable leftBackground;
    private String leftText;
    private String rightText;
    private Drawable rightBackground;
    private int rightTextColor;
    private void initProperty(Context context,AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.MyTopTitleBar);

        titleTextStr = typedArray.getString(R.styleable.MyTopTitleBar_titleText);
        titleColor = typedArray.getColor(R.styleable.MyTopTitleBar_titleColor, 0);
        titleSize = typedArray.getDimension(R.styleable.MyTopTitleBar_titleSize, 0);

        leftTextColor = typedArray.getColor(R.styleable.MyTopTitleBar_leftTextColor, 0);
        leftBackground = typedArray.getDrawable(R.styleable.MyTopTitleBar_leftBackground);
        leftText = typedArray.getString(R.styleable.MyTopTitleBar_leftText);

        rightText = typedArray.getString(R.styleable.MyTopTitleBar_rightText);
        rightBackground = typedArray.getDrawable(R.styleable.MyTopTitleBar_rightBackground);
        rightTextColor = typedArray.getColor(R.styleable.MyTopTitleBar_rightTextColor, 0);

        typedArray.recycle();
    }

    private Button leftButton;
    private Button rightButton;
    private TextView titleText;
    private void initView(Context context) {
        leftButton = new Button(context);
        rightButton = new Button(context);
        titleText = new TextView(context);


        leftButton.setBackground(leftBackground);
        leftButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                onMyTopTitleBarClickListener.onLeftClick();
            }
        });
        LayoutParams leftLayoutParams = new LayoutParams(
                70,
                70
        );
        leftLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT,TRUE);
        leftLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
        leftLayoutParams.leftMargin = 10;
        addView(leftButton, leftLayoutParams);

        rightButton.setBackground(rightBackground);
        rightButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                onMyTopTitleBarClickListener.onRightClick();
            }
        });
        LayoutParams rightLayoutParams  = new LayoutParams(
                70,
                70
        );
        rightLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,TRUE);
        rightLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
        rightLayoutParams.rightMargin = 10;
        addView(rightButton, rightLayoutParams);

        titleText.setText(titleTextStr);
        titleText.setTextColor(titleColor);
        titleText.setTextSize(titleSize);
        LayoutParams titleLayoutParams = new LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        titleLayoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        titleLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
        addView(titleText,titleLayoutParams);


        setBackgroundColor(getResources().getColor(R.color.colorAccent));
    }
    public interface OnMyTopTitleBarClickListener{
        void onLeftClick();
        void onRightClick();
    }
}
