package com.reallycool.harsha.buss;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.constraint.solver.widgets.Rectangle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by harsha on 19/12/17.
 */

public class Dataclass extends Activity {
    static String str;
    static ArrayList<String> al;
    boolean drag=false;
    float dy=0,y1=0;
    float var=0;
    ArrayList<String> exist;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new Selection(this));

    }
 class Selection extends View implements View.OnTouchListener{
    Bitmap seat2;
    Bitmap seat5;
    Bitmap seat3;
    Paint p;
    float f,w;
        public Selection(Context context) {
            super(context);
            setOnTouchListener(this);
            p=new Paint();
            w=0;
            exist = new ArrayList<>();
            p.setFakeBoldText(true); 
            al = new ArrayList<String>();
            seat2 = BitmapFactory.decodeResource(getResources(), R.drawable.seat);
            seat3 = BitmapFactory.decodeResource(getResources(),R.drawable.seat2);
            seat5 = BitmapFactory.decodeResource(getResources(), R.drawable.seat5);
            Helper h = new Helper(Dataclass.this, str);
            h.getReadableDatabase();
            List<Seat> l=h.getallseats(1);
            for (Seat s : l) {
                int t=(s.id);
                int one=t/10;
                t%=10;
                exist.add(one+" "+t);
            }

            Log.e("Size" + l.isEmpty(), "Here"+exist.size()  );
        }
        @Override
        protected void onDraw(Canvas c){
            super.onDraw(c); f=getWidth()/5;
            w=getWidth()/480;

            p.setTextSize(25*(w));
            c.drawColor(Color.WHITE);
            for(int i=0;i<10;i++ ) {
                for(int j=0;j<5;j++) {
                    if(j==2)continue;
                    Rect src=new Rect(0, 0, seat2.getWidth(), seat2.getHeight());
                    int y1=(int)(100*w+i*(seat2.getWidth())+dy);
                    int y2=(int)(100*w+i*(seat2.getWidth())+f+dy);
                    Rect dest=new Rect((int)(j*f),y1,
                                    (int)((j+1)*f),y2);
                    if(exist.contains(j+" "+i))
                        c.drawBitmap(seat2,src,dest,p);
                    else if(al.contains(j+" "+i) )
                            c.drawBitmap(seat5,src,dest,p);
                    else
                    c.drawBitmap(seat3,src,dest,p);
                    c.drawText(j+" "+i,j*f,y2,p);

                }
            }
            p.setColor(Color.WHITE);
            c.drawRect(0,0,getWidth(),100*w,p);
            p.setColor(Color.BLACK);
            c.drawText("Driver's Cabin",getWidth()/2 ,50*w,p);
            c.drawText("Next",0,50*w,p);
            c.drawLine(0,90*w,getWidth(),90*w,p);

        }

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
           int a=0,b=0;
            if(motionEvent.getAction()==MotionEvent.ACTION_DOWN) {
                float x = motionEvent.getX();
                float y = motionEvent.getY() ;
                if(x>2*getWidth()/5&&x<3*getWidth()/5){var=y;drag=true;return true;}
                if(x<100*w&&y<w*150){
                    Intent intent = new Intent(Dataclass.this, Names.class);
                    startActivity(intent);
                    return true;
                }
                if((y<w*100))return true;
                y-=100*w;
                a = (int) (x / f);
                b = (int) ((y-dy) / (seat2.getWidth()));
                Log.e(a+"", b+"");
                if(exist.contains(a+" "+b)){return true;}
                Log.e("adding", a + " " + b);
                if(!al.contains(a+" "+b))
                al.add(a + " " + b);
                else al.remove(a + " " + b);
            }
            if(motionEvent.getAction()==MotionEvent.ACTION_MOVE){if(drag){

            if(var==motionEvent.getY())return true;
                dy+=motionEvent.getY()-var;
                var=motionEvent.getY();
                if(dy>0)dy=0;if(dy<-1100)dy=-1100;
                Log.e(dy + " watch", " hey");
            invalidate();
            return true;
            }
            }
            if(motionEvent.getAction()==MotionEvent.ACTION_UP){drag=false;return true;}
            Log.e(a + "", b + "");
            invalidate();
            return true;
        }
    }
}