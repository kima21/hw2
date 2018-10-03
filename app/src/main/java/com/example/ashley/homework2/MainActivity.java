/**
 * Main Activity Class
 *
 * @author Ashley
 * September 2018
 *
 */

package com.example.ashley.homework2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Face aFace;
    private Spinner spinner;
    private static final String[] paths = {"Hairstyle 1", "Hairstyle 2", "Bald"};
    SeekBar redSeekBar, greenSeekBar, blueSeekBar;

    /*
        Initialize
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aFace = (Face) findViewById(R.id.Face);

        Button randomButton =
                (Button) findViewById(R.id.randomButton);
        randomButton.setOnClickListener(new randomButtonListener());

        android.widget.SeekBar redSeekBar =
                (SeekBar) findViewById(R.id.redSeek);
        redSeekBar.setOnSeekBarChangeListener
                (new redSeekBarListener(aFace));

        android.widget.SeekBar greenSeekBar =
                (SeekBar) findViewById(R.id.greenSeek);
        greenSeekBar.setOnSeekBarChangeListener
                (new greenSeekBarListener());

        android.widget.SeekBar blueSeekBar =
                (SeekBar) findViewById(R.id.blueSeek);
        blueSeekBar.setOnSeekBarChangeListener
                (new blueSeekBarListener());

        spinner = (Spinner) findViewById(R.id.hairSpinner);
        spinner.setOnItemSelectedListener(new hairOptionsListener());
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item,paths);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


        RadioGroup buttonGroup = findViewById(R.id.buttonGroup);
        RadioButton hairButton = findViewById(R.id.hairButton);
        RadioButton eyesButton = findViewById(R.id.eyesButton);
        RadioButton skinButton = findViewById(R.id.skinButton);
    }

    /**
     External Citation
     Date: September 2018
     Problem: Could not get the incorporate the spinner drop down list
     Resource:
     https://stackoverflow.com/questions/13377361/how-to-create-a-drop-down-list
     Solution: I used the example code from this post.
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                aFace.setHairStyle(0);
                break;
            case 1:
                aFace.setHairStyle(1);
                break;
        }
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) { }

    /* randomButtonListener method
     *
     */
    private class randomButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View button) {
            Random random = new Random();

            int hairStyle = random.nextInt(1);
            aFace.setHairStyle(hairStyle);
            aFace.setEye(Color.argb(225, random.nextInt(255),
                    random.nextInt(255), random.nextInt(255)));
            aFace.setHair(Color.argb(225, random.nextInt(255),
                    random.nextInt(255), random.nextInt(255)));
            aFace.setSkin(Color.argb(225, random.nextInt(255),
                    random.nextInt(255), random.nextInt(255)));
        }
    }

    /** redSeekBarListener method
     *
     */
    private class redSeekBarListener
            implements SeekBar.OnSeekBarChangeListener {
        private Face aFace;
        redSeekBarListener(Face fv){
            this.aFace=fv;
        }

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            aFace.setSkin(666);// get alpha, red green blue values, keep it, then set the red value to a new one

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    }

    /** greenSeekBarListener method
     *
     */
    private class greenSeekBarListener
            implements SeekBar.OnSeekBarChangeListener {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    }


    /** blueSeekBarListener method
     *
     */
    private class blueSeekBarListener
            implements SeekBar.OnSeekBarChangeListener {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    }

    /** hairOptionsListener method
     *
     */
    public class hairOptionsListener implements Spinner.OnItemSelectedListener{

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }





}
