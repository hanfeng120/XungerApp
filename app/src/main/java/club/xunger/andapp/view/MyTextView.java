package club.xunger.andapp.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import club.xunger.xungerapp.R;

/**
 * Created by zhaoxunyi on 2016/5/10.
 */
public class MyTextView extends View {

    private String titleText;
    private int titleColor;
    private int titleSize;

    private Paint paint = new Paint();
    private Rect rect = new Rect();

    public MyTextView(Context context) {
        this(context, null);
    }

    public MyTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typeArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.MyTextView, defStyleAttr, 0);
        for (int i = 0; i < typeArray.getIndexCount(); i++) {
            int attr = typeArray.getIndex(i);
            switch (attr) {
                case R.styleable.MyTextView_titleText:
                    titleText = typeArray.getString(attr);
                    break;
                case R.styleable.MyTextView_titleColor:
                    titleColor = typeArray.getColor(attr, Color.BLACK);
                    break;
                case R.styleable.MyTextView_titleSize:
                    titleSize = typeArray.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(
                            TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics()));
                    break;
            }
        }
        typeArray.recycle();
        initPaint();
    }

    private void initPaint() {
        paint.setAntiAlias(true);
        paint.setTextSize(titleSize);
        paint.getTextBounds(titleText, 0, titleText.length(), rect);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int width;
        int height;
        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthSize;
        } else {
            paint.setTextSize(titleSize);
            paint.getTextBounds(titleText, 0, titleText.length(), rect);
            float textWidth = rect.width();
            int desired = (int) (getPaddingLeft() + textWidth + getPaddingRight());
            width = desired;
        }

        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else {
            paint.setTextSize(titleSize);
            paint.getTextBounds(titleText, 0, titleText.length(), rect);
            float textHeight = rect.height();
            int desired = (int) (getPaddingTop() + textHeight + getPaddingBottom());
            height = desired;
        }
        setMeasuredDimension(width, height);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        paint.setColor(Color.GRAY);
        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), paint);
        paint.setColor(titleColor);
        canvas.drawText(titleText, getWidth() / 2 - rect.width() / 2, getHeight() / 2 + rect.height() / 2, paint);

    }
}
