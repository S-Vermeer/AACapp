package com.example.aacvoca;


import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void SoundButtonOnClick(View view) {
        findViewById(view.getId()).setBackgroundColor(R.color.colorPrimary);
    }
}

