package com.example.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ShowList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        ArrayList<String> lista = intent.getStringArrayListExtra(MainActivity.EXTRA_TEXT);
        Button back = (Button) findViewById(R.id.button4);
        TextView textView = (TextView) findViewById(R.id.textView);

        StringBuilder builder = new StringBuilder();
        for (String details: lista ){
            builder.append(details + "\n");
        }
        textView.setText(builder.toString());

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
