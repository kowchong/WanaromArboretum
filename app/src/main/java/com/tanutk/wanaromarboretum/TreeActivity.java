package com.tanutk.wanaromarboretum;

import android.app.Activity;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TreeActivity extends Activity {
    private static final String TAG = TreeActivity.class.getSimpleName();

    private ArrayList<String> mFileNameList = new ArrayList<>();
    private String mImageFileName;
    private ScrollView mScrollView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tree);
        try {
            addImagesToThegallery();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void addImagesToThegallery() throws IOException {

        AssetManager assetManager = getAssets();
        String[] files = assetManager.list("Herb");

        BufferedReader reader = null;
        reader = new BufferedReader(
                new InputStreamReader(assetManager.open("Herb/herb_name_list.txt"), "UTF-8"));
        String line;
        LinearLayout imageGallery = (LinearLayout) findViewById(R.id.imageGallery);
        for (String fileName : files) {
            if (fileName.indexOf(".txt") == -1) {
                imageGallery.addView(getImageView(fileName));
                if ((line = reader.readLine()) != null) {
                    String[] arrayOfImageName = line.split(",");
                    String imageName = arrayOfImageName[1];
                    TextView textView = new TextView(getApplicationContext());
                    textView.setText(imageName);
                    textView.setTextColor(Color.BLACK);
                    imageGallery.addView(textView);
                }
            }
        }
    }


    private View getImageView(String fileName) {
        ImageView imageView = new ImageView(getApplicationContext());
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(1000, 600);
        lp.setMargins(0, 0, 10, 0);
        lp.gravity = Gravity.CENTER;
        imageView.setLayoutParams(lp);
        try {
            // get input stream
            InputStream ims = getAssets().open("Herb/" + fileName);
            // load image as Drawable
            Drawable d = Drawable.createFromStream(ims, null);
            // set image to ImageView
            imageView.setImageDrawable(d);
        } catch (IOException ex) {
            return imageView;
        }

        imageView.setScaleType(ImageView.ScaleType.FIT_XY);

        return imageView;
    }

    private void addImageName() {
        TextView textView = new TextView(getApplicationContext());

    }
}