/** Face Class
 * @author Ashley
 * September 2018
 */
package com.example.ashley.homework2;

import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.Random;

public class Face extends SurfaceView{

    protected int hairColor;
    protected int eyeColor;
    protected int skinColor;
    protected int hairStyle;

    private int radioSelect;
    private int selectedItem;

    public Face(Context context, AttributeSet set){
        super(context, set);
        setWillNotDraw(false);

        this.selectedItem = 0;


    }

    /**
     * initializes all the variables to randomly selected valid values
     */
    public void randomize() {
        Random random = new Random();

        this.hairStyle = random.nextInt(3);
        this.skinColor = Color.argb(225, random.nextInt(225),
                random.nextInt(225), random.nextInt(225));
        this.hairColor = Color.argb(225, random.nextInt(225),
                random.nextInt(225), random.nextInt(225));
        this.eyeColor = Color.argb(225, random.nextInt(225),
                random.nextInt(225), random.nextInt(225));
    }

    public int randomizeHair(){
        Random random = new Random();
        int hairNumber = random.nextInt(3);
        return hairNumber;
    }

    /**
     * draws the Face object upon a given Canvas
     * @param canvas
     */
    public void onDraw(Canvas canvas){
        //Draws the face in the surface view
        Paint p = new Paint();

        p.setColor(skinColor);
        canvas.drawCircle(1000, 300, 200, p);

        //Draws the left eye in the surface view
        p.setColor(eyeColor);
        canvas.drawCircle(900, 300, 20, p);

        //Draws the right eye in the surface view
        p.setColor(eyeColor);
        canvas.drawCircle(1100, 300, 20, p);

    }


    /**
     * picks and draws the hairstyle based on the user's pick
     * @param canvas
     * @param hairStyle
     */
    public void drawHairStyle(Canvas canvas, int hairStyle) {
        int x = canvas.getWidth();
        int y = canvas.getHeight();

        Paint hairColor = new Paint();
        hairColor.setStyle(Paint.Style.FILL);
        hairColor.setColor(this.hairColor);

        if(hairStyle == 0) {
            canvas.drawArc(700,5,1100, 200,0, -180, true, hairColor);
        } else if(hairStyle == 1){
            canvas.drawArc(600,5,1200, 400,0, -180, true, hairColor);
        }

        invalidate();
    }
    public int getSkin() {return skinColor;}
    public void setSkin(int skinColor) { this.skinColor = skinColor; }
    public int getHair() {return hairColor;}
    public void setHair(int hairColor) { this.hairColor = hairColor; }
    public int getEye(int eyeColor) { return eyeColor; }
    public void setEye(int eyeColor) { this.eyeColor = eyeColor; }
    public int getHairStyle() { return hairStyle; }


    /*SetHairStyle
    @param hairStyle
     */
    protected void setHairStyle(int hairStyle) {
        this.hairStyle = hairStyle;
        invalidate();
    }

}





