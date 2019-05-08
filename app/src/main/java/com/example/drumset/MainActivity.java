package com.example.drumset;

import android.graphics.PointF;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private LinearLayout mainLayout;
    private TextView status;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        status = (TextView) findViewById(R.id.status);
        mainLayout = (LinearLayout) findViewById(R.id.layout);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        Position position = getPosition(event.getX(), event.getY());

        switch(position){
            case TOP_LEFT1:
                status.setText("Open Hi-Hat");
                break;

            case TOP_LEFT2:
                status.setText("Close Hi-Hat");
                break;

            case TOP_RIGHT1:
                status.setText("Cymbal");
                break;

            case TOP_RIGHT2:
                status.setText("High Tom");
                break;

            case BOTTOM_LEFT1:
                status.setText("Snare Drum");
                break;

            case BOTTOM_LEFT2:
                status.setText("Bass Drum");
                break;

            case BOTTOM_RIGHT1:
                status.setText("Mid Tom");
                break;

            case BOTTOM_RIGHT2:
                status.setText("Open Hi-Hat");
                break;

            case MIDDLE:
                status.setText("Floor Tom");
                break;

        }

        return super.onTouchEvent(event);

    }

    private PointF getCenter(){
        return new PointF(mainLayout.getWidth()/2f, mainLayout.getHeight()/2f);
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
}
