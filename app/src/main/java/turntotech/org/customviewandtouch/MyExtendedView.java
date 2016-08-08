package turntotech.org.customviewandtouch;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class MyExtendedView extends View {

    static String DEBUG_TAG = "CUSTOM_VIEW_INFO";

    float x=0, y=0, x1=0, y1=0, x2=0, y2=0, x3=0, y3=0, x4=0, y4=0;

    int pc=0;

    Paint p = new Paint(), p1 = new Paint(), p2 = new Paint(), p3 = new Paint(), p4 = new Paint();

    //1.1 The constructor is called first
    public MyExtendedView(Context ctx, AttributeSet attrs) {

        super(ctx, attrs);

        //1.1.1 Set the background color to black
        this.setBackgroundColor(Color.BLACK);
    }

    //1.2 This method is called before the view is drawn first, on screen rotation and when forceredraw is called
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);

        p.setColor(Color.YELLOW);
        p1.setColor(Color.CYAN);
        p2.setColor(Color.RED);
        p3.setColor(Color.GREEN);
        p4.setColor(Color.WHITE);

        if (pc == 5){
            canvas.drawCircle(x, y, 90f, p);
            canvas.drawCircle(x1, y1, 90f, p1);
            canvas.drawCircle(x2, y2, 90f, p2);
            canvas.drawCircle(x3, y3, 90f, p3);
            canvas.drawCircle(x4, y4, 90f, p4);
        }else if (pc == 4){
            canvas.drawCircle(x, y, 90f, p);
            canvas.drawCircle(x1, y1, 90f, p1);
            canvas.drawCircle(x2, y2, 90f, p2);
            canvas.drawCircle(x3, y3, 90f, p3);
        }else if (pc == 3){
            canvas.drawCircle(x, y, 90f, p);
            canvas.drawCircle(x1, y1, 90f, p1);
            canvas.drawCircle(x2, y2, 90f, p2);
        }else if (pc == 2){
            canvas.drawCircle(x, y, 90f, p);
            canvas.drawCircle(x1, y1, 90f, p1);
        }else if (pc == 1){
            canvas.drawCircle(x, y, 90f, p);
        }else{

        }


    }

    //1.3 This is called when a touch is registered
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        final int action = event.getAction();

        //1.4 Here were are just logging the kind of event we got
        switch (action) {
            case (MotionEvent.ACTION_DOWN):
                Log.d(DEBUG_TAG, "Action was DOWN");
                 break;

            case (MotionEvent.ACTION_MOVE):
                Log.d(DEBUG_TAG, "Action was MOVE");
                break;

            case (MotionEvent.ACTION_UP):

                Log.d(DEBUG_TAG, "Action was UP");
                pc = 0;
                break;
            default:
                 return super.onTouchEvent(event);
        }

        if(action != MotionEvent.ACTION_UP)
        pc = event.getPointerCount();


        //1.5 at this point we re-draw the circle where the touch occurred

        if (pc == 5) {
            redrawViewWithCircle1(event);
            redrawViewWithCircle2(event);
            redrawViewWithCircle3(event);
            redrawViewWithCircle4(event);
            redrawViewWithCircle5(event);
        }else if (pc == 4){
            redrawViewWithCircle1(event);
            redrawViewWithCircle2(event);
            redrawViewWithCircle3(event);
            redrawViewWithCircle4(event);
        }else if (pc == 3){
            redrawViewWithCircle1(event);
            redrawViewWithCircle2(event);
            redrawViewWithCircle3(event);
        }else if (pc == 2) {
            redrawViewWithCircle1(event);
            redrawViewWithCircle2(event);
        }else if (pc == 1){
            redrawViewWithCircle1(event);
        }else{
            redrawViewWithCircle1(event);
        }

        return true;
    }

    //1.6
    public void redrawViewWithCircle1(MotionEvent event) {

        //1.6.1 Get index
        int index = event.getActionIndex();

        //1.6.2 Get coordinates for circle center. Set the instance variables.
        this.x = event.getX(index);
        this.y = event.getY(index);

        //1.6.3 Force the view to redraw. Comment this and see what happens.
        this.postInvalidate();

    }

    public void redrawViewWithCircle2(MotionEvent event) {

        int index = 1;

        //1.6.2 Get coordinates for circle center. Set the instance variables.
        this.x1 = event.getX(index);
        this.y1 = event.getY(index);

        //1.6.3 Force the view to redraw. Comment this and see what happens.
        this.postInvalidate();

    }

    public void redrawViewWithCircle3(MotionEvent event) {

        int index = 2;

        //1.6.2 Get coordinates for circle center. Set the instance variables.
        this.x2 = event.getX(index);
        this.y2= event.getY(index);

        //1.6.3 Force the view to redraw. Comment this and see what happens.
        this.postInvalidate();

    }

    public void redrawViewWithCircle4(MotionEvent event) {

        int index = 3;

        //1.6.2 Get coordinates for circle center. Set the instance variables.
        this.x3 = event.getX(index);
        this.y3 = event.getY(index);

        //1.6.3 Force the view to redraw. Comment this and see what happens.
        this.postInvalidate();

    }

    public void redrawViewWithCircle5(MotionEvent event) {

        int index = 4;

        //1.6.2 Get coordinates for circle center. Set the instance variables.
        this.x4 = event.getX(index);
        this.y4 = event.getY(index);

        //1.6.3 Force the view to redraw. Comment this and see what happens.
        this.postInvalidate();

    }

}