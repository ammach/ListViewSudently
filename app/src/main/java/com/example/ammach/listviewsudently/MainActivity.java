package com.example.ammach.listviewsudently;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.parse.ParseFile;
import com.parse.ParseImageView;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;

public class MainActivity extends AppCompatActivity {

    class MyAdapter extends ParseQueryAdapter<ParseObject> {

        public MyAdapter(Context context) {
            super(context, new ParseQueryAdapter.QueryFactory<ParseObject>() {
                public ParseQuery create() {
                    ParseQuery query = new ParseQuery("Item");
                    return query;
                }
            });
        }

        // Customize the layout by overriding getItemView
        @Override
        public View getItemView(ParseObject object, View v, ViewGroup parent) {
            super.getItemView(object, v, parent);
            if (v == null) {
                v = View.inflate(getContext(), R.layout.row, null);
            }
            TextView titleTextView = (TextView) v.findViewById(R.id.txt);
            titleTextView.setText(object.getString("ItemField"));

            ParseImageView todoImage = (ParseImageView) v.findViewById(R.id.img);
            ParseFile imageFile = object.getParseFile("image");
            if (imageFile != null) {
                todoImage.setParseFile(imageFile);
                todoImage.loadInBackground();
            }
            return v;
        }
    }

    ParseQueryAdapter<ParseObject> mainAdapter;
    MyAdapter myAdapter;
    ListView listView;
    Handler handler;
   //ArrayList<String> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainAdapter = new ParseQueryAdapter<ParseObject>(this, "Item");
        mainAdapter.setTextKey("ItemField");
        mainAdapter.setImageKey("image");

        myAdapter=new MyAdapter(this);

        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(mainAdapter);
        mainAdapter.loadObjects();




    }



}
