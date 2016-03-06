package com.zmarkan.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.zmarkan.xkcdlib.ComicViewer;

import org.jetbrains.annotations.NotNull;


public class MainActivity extends AppCompatActivity implements ComicViewer.Callback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, COTDActivity.class);
//                startActivity(intent);

                ComicViewer.INSTANCE.viewComicOfTheDAy(MainActivity.this, MainActivity.this);
            }
        });
    }



    @Override
    public void success(@NotNull ComicViewer.VotingResult result) {
        Log.d(">>>>>>", ">>>>>>" + result.name());
//        SnackBar.
    }

    @Override
    public void failure(@NotNull Throwable error) {
        Log.d(">>>>>>", ">>>>>>>>>>" + error.getMessage());
    }
}
