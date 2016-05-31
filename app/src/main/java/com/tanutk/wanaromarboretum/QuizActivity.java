package com.tanutk.wanaromarboretum;

import android.app.Activity;
import android.os.Bundle;

public class QuizActivity extends Activity {

    int [] sequence;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        //prepareSequence();
    }
}
