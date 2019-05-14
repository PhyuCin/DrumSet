package com.example.drumset;

import android.graphics.PointF;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SoundManager soundManager;
    private LinearLayout mainLayout;

//    private TextView status;

    private int bassDrum;
    private int closeHiHat;
    private int openHiHat;
    private int cymbal;
    private int floorTom;
    private int midTom;
    private int highTom;
    private int snareDrum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        status = (TextView) findViewById(R.id.status);

        mainLayout = (LinearLayout) findViewById(R.id.layout);

        soundManager = new SoundManager(this);

        bassDrum = soundManager.addSound(R.raw.bassdrum);
        closeHiHat = soundManager.addSound(R.raw.closehihatcymbals);
        openHiHat = soundManager.addSound(R.raw.openhihatcymbals);
        cymbal = soundManager.addSound(R.raw.cymbal);
        floorTom = soundManager.addSound(R.raw.floortom);
        midTom = soundManager.addSound(R.raw.midtom);
        highTom = soundManager.addSound(R.raw.hightom);
        snareDrum = soundManager.addSound(R.raw.snaredrum);


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (event.getAction() != MotionEvent.ACTION_DOWN){
            return super.onTouchEvent(event);
        }

        Position position = getPosition(event.getX(), event.getY());

        switch(position){
            case TOP_LEFT1:
//                status.setText("Open Hi-Hat");
                soundManager.play(openHiHat);
                break;

            case TOP_LEFT2:
//                status.setText("Close Hi-Hat");
                soundManager.play(closeHiHat);
                break;

            case TOP_RIGHT1:
//                status.setText("Cymbal");
                soundManager.play(cymbal);
                break;

            case TOP_RIGHT2:
//                status.setText("High Tom");
                soundManager.play(highTom);
                break;

            case BOTTOM_LEFT1:
//                status.setText("Snare Drum");
                soundManager.play(snareDrum);
                break;

            case BOTTOM_LEFT2:
//                status.setText("Bass Drum");
                soundManager.play(bassDrum);
                break;

            case BOTTOM_RIGHT1:
//                status.setText("Mid Tom");
                soundManager.play(midTom);
                break;

            case BOTTOM_RIGHT2:
//                status.setText("Floor Tom");
                soundManager.play(floorTom);
                break;

            case MIDDLE:
//                status.setText("None");
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
