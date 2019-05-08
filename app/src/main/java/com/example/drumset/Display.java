package com.example.drumset;

import android.content.Context;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class Display extends View {

    public Display(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    private PointF getCenter(){
        return new PointF(getWidth()/2f, getHeight()/2f);
    }

    public Position getPosition(float x, float y){
        PointF center = getCenter();

        if(y < center.y){
            if(x < (center.x/2))
            return Position.TOP_LEFT1;

            else if (x > (center.x/2) && x < center.x)
                return Position.TOP_LEFT2;

            else if (x > center.x && x < (center.x + (center.x/2)))
                return Position.TOP_RIGHT1;

            else if (x > (center.x + (center.x/2)))
                return Position.TOP_RIGHT2;
        }

        else if (y > center.y){
            if(x < (center.x/2))
                return Position.BOTTOM_LEFT1;

            else if (x > (center.x/2) && x < center.x)
                return Position.BOTTOM_LEFT2;

            else if (x > center.x && x < (center.x + (center.x/2)))
                return Position.BOTTOM_RIGHT1;

            else if (x > (center.x + (center.x/2)))
                return Position.BOTTOM_RIGHT2;
        }

        return Position.MIDDLE;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
