package com.zmarkan.sample;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
                ComicViewer.INSTANCE.viewComicOfTheDAy(MainActivity.this, MainActivity.this);
            }
        });
    }

    @Override
    public void success(@NotNull ComicViewer.VotingResult result) {
        Snackbar.make(findViewById(R.id.main_container), result.toString(), Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void failure(@NotNull Throwable error) {
        Snackbar.make(findViewById(R.id.main_container), error.getMessage(), Snackbar.LENGTH_LONG).show();
    }
}
