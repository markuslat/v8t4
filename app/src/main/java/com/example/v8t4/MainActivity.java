package com.example.v8t4;

import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    TextView text;
    SeekBar seekBar;
    TextView seekText;

    BottleDispenser dispencer = BottleDispenser.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView) findViewById(R.id.text);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekText = findViewById(R.id.seekText);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue = progress;
                seekText.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    public void addMoney (View v){
        dispencer.addMoney(text, seekBar.getProgress());
        seekBar.setProgress(0);
    }
    public void buyBottle (View v){
        dispencer.buyBottle(text);
    }
    public void returnMoney (View v){
        dispencer.returnMoney(text);
    }
}
