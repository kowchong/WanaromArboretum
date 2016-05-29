package com.tanutk.wanaromarboretum;

import android.content.Intent;
import android.graphics.LinearGradient;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button howToGoButton = (Button) findViewById(R.id.button);

        LinearLayout treeType = (LinearLayout)findViewById(R.id.tree_type_layout);
        assert treeType != null;
        treeType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, TreeActivity.class);
                startActivity(i);
            }
        });

        LinearLayout animalType = (LinearLayout)findViewById(R.id.animal_type_layout);
        assert animalType != null;
        animalType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AnimalActivity.class);
                startActivity(i);
            }
        });




        assert howToGoButton != null;
        howToGoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGoogleMap();
            }
        });





    }

    private void openGoogleMap() {
        String uri = String.format(Locale.ENGLISH, "https://goo.gl/maps/48HVcCy2ADL2");
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        startActivity(intent);
    }
}
