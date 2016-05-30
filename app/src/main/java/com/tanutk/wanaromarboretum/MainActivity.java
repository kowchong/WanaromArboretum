package com.tanutk.wanaromarboretum;

import android.content.Context;
import android.content.Intent;
import android.graphics.LinearGradient;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.tanutk.wanaromarboretum.model.TitleModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private List<TitleModel> titleModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button howToGoButton = (Button) findViewById(R.id.button);

        titleModelList = new ArrayList<>();
        PrepareTitleList(titleModelList);



//        LinearLayout treeType = (LinearLayout) findViewById(R.id.tree_type_layout);
//        assert treeType != null;
//        treeType.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(MainActivity.this, TreeActivity.class);
//                startActivity(i);
//            }
//        });
//
//        LinearLayout animalType = (LinearLayout) findViewById(R.id.animal_type_layout);
//        assert animalType != null;
//        animalType.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(MainActivity.this, AnimalActivity.class);
//                startActivity(i);
//            }
//        });

        ListView lvTitle = (ListView) findViewById(R.id.listView);
        TitleAdapter adapter = new TitleAdapter(getApplicationContext(), R.layout.row, titleModelList);
        lvTitle.setAdapter(adapter);

        assert howToGoButton != null;
        howToGoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGoogleMap();
            }
        });


    }

    private void PrepareTitleList(List<TitleModel> titleModelList) {

        TitleModel titleModelAnimal = new TitleModel();
        TitleModel titleModelTree = new TitleModel();
        TitleModel titleModelQuiz = new TitleModel();

        titleModelAnimal.setImageDrawableID(R.drawable.tiger);
        titleModelAnimal.setTitle("สัตว์ป่าน่ารัก");
        titleModelTree.setImageDrawableID(R.drawable.tree);
        titleModelTree.setTitle("ต้นไม้ในสวน");
        titleModelQuiz.setImageDrawableID(R.drawable.question_mark);
        titleModelQuiz.setTitle("ต้นอะไรเอ่ย");



        titleModelList.add(titleModelTree);
        titleModelList.add(titleModelAnimal);
        titleModelList.add(titleModelQuiz);


    }

    private void openGoogleMap() {
        String uri = String.format(Locale.ENGLISH, "https://goo.gl/maps/48HVcCy2ADL2");
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        startActivity(intent);
    }

    public class TitleAdapter extends ArrayAdapter {

        private List<TitleModel> titleModelList;
        private int resource;
        private LayoutInflater inflater;

        public TitleAdapter(Context context, int resource, List<TitleModel> objects) {
            super(context, resource, objects);
            titleModelList = objects;
            this.resource = resource;
            inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = inflater.inflate(resource, null);

            }
            ImageView ivTitleChoice;
            TextView tvTitleChoice;

            ivTitleChoice = (ImageView) convertView.findViewById(R.id.ivTitleChoice);
            tvTitleChoice = (TextView) convertView.findViewById(R.id.tvTitleChoice);

            // Then later, when you want to display image
            //ImageLoader.getInstance().displayImage(hSportModelList.get(position).getThumbnail(), ivHSport); // Default options will be used

            ivTitleChoice.setImageDrawable(getResources().getDrawable(titleModelList.get(position).getImageDrawableID()));

            //ivHSport.setImageBitmap(getBitmapFromURL(hSportModelList.get(position).getThumbnail()));
            tvTitleChoice.setText(titleModelList.get(position).getTitle());
            return convertView;

        }
    }
}

