package com.nathansass.funfacts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class FunFactsActivty extends AppCompatActivity {

    public static final String TAG = FunFactsActivty.class.getSimpleName();

    private FactBook mFactBook = new FactBook();
    private ColorWheel mColorWheel = new ColorWheel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // create activity and hook it up to main xml screen
        setContentView(R.layout.activity_fun_facts);

        // create view variables and hook them up to the view by their ids
        final TextView factlabel = (TextView) findViewById(R.id.factTextView);
        final Button showFactButton = (Button) findViewById(R.id.showFactButton);
        final RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fact = mFactBook.getFact();

                factlabel.setText(fact);
                int color = mColorWheel.getColor();
                relativeLayout.setBackgroundColor(color);

                showFactButton.setTextColor(color);
            }
        };

        showFactButton.setOnClickListener(listener);

//        Toast.makeText(this, "Yay! Activity created", Toast.LENGTH_LONG).show();
        Log.d(TAG, "----------------      We're logging from the onCreate() method!");
    }
}
