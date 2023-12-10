package com.example.mobilebank_;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
    // TODO - добавить возможность смены аватара(хз), в принципе что-то добавить и подредачить дизайн
    private TextView mTextView;
    private int limited;
    private SharedPreferences limit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_profile);

        final SeekBar seekBar = (SeekBar)findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(this);

        mTextView = findViewById(R.id.textLabel2);
        mTextView.setText("0");

        limit = getSharedPreferences("limit", MODE_PRIVATE);
        limited = limit.getInt("save_limit", limited);

        mTextView.setText(String.valueOf(limited));
        seekBar.setProgress(limited);

    }
    public void menuClick(View view){
        Intent menu = new Intent(this, MainActivity.class);
        menu.putExtra("limit", limited);
        startActivity(menu);
    }

    public void exitClick(View view){
        this.finishAffinity();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        limited = seekBar.getProgress();
        mTextView.setText(String.valueOf(limited));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

        SharedPreferences.Editor editor = limit.edit();
        editor.putInt("save_limit", limited);
        editor.commit();
    }
}