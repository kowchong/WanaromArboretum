package com.tanutk.wanaromarboretum;

import android.app.Activity;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.io.IOException;
import java.io.InputStream;

public class AnimalActivity extends Activity {

    private static final String TAG = AnimalActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);
//        try {
//            //addImagesToThegallery();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    private void addImagesToThegallery() throws IOException {
        AssetManager assetManager = getAssets();
        String[] files = assetManager.list("Herb");

        LinearLayout imageGallery = (LinearLayout) findViewById(R.id.imageGallery);
        for (String fileName : files) {
            imageGallery.addView(getImageView(fileName));
        }
    }


    private View getImageView(String fileName) {
        ImageView imageView = new ImageView(getApplicationContext());
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(0, 0, 10, 0);
        imageView.setLayoutParams(lp);
        try {
            // get input stream
            InputStream ims = getAssets().open("Herb/"+ fileName);
            // load image as Drawable
            Drawable d = Drawable.createFromStream(ims, null);
            // set image to ImageView
            imageView.setImageDrawable(d);
        }
        catch(IOException ex) {
            return imageView;
        }
        return imageView;
    }

}



