package fragment.bwie.com.ballviewdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by CZ on 2017/11/2.
 */
public class CustProgress extends View{

    private int cx = 200;
    private int cy = 200;
    //
    private Paint paint;

    public CustProgress(Context context) {
        super(context);
    }

    public CustProgress(Context context, AttributeSet attrs) {
        super(context, attrs);
        //画笔
        paint = new Paint();
        //图形颜色
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);
        //球的宽度
        paint.setStrokeWidth(10);
    }

    public CustProgress(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            //按下
            case MotionEvent.ACTION_DOWN:
                //打印坐标
                System.out.println("event ACTION_DOWN = "+event.getRawX()+" "+event.getRawY());
                break;
            //移动
            case MotionEvent.ACTION_MOVE:
                //打印坐标
                System.out.println("event ACTION_MOVE = "+event.getRawX()+" "+event.getRawY());
                cx = (int) event.getX();
                cy = (int) event.getY();
                invalidate();
                break;
            //抬起
            case MotionEvent.ACTION_UP:
                //打印坐标
                System.out.println("event ACTION_UP = "+event.getRawX()+" "+event.getRawY());
                break;
        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画布
        canvas.drawCircle(cx,cy,10,paint);
    }
}
