package com.example.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_TEXT = "com.example.shoppinglist.EXTRA_TEXT";

     Button button_save;
     private Button button_done;
     EditText EditText_content;

     ArrayList<String> lista = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_save = (Button) findViewById(R.id.button);
        button_done = (Button) findViewById(R.id.button2);
        EditText_content = (EditText) findViewById(R.id.simpleEditText);


        button_save.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (EditText_content.length() < 3){
                    Toast.makeText(getApplicationContext(), "too short", Toast.LENGTH_SHORT).show();
                }
                else if(EditText_content.length() > 15){
                    Toast.makeText(getApplicationContext(), "too long", Toast.LENGTH_SHORT).show();
                }
                else{
                    lista.add(EditText_content.getText().toString());
                    Toast.makeText(getApplicationContext(), "Item added to shoppinglist", Toast.LENGTH_SHORT).show();
                }
            }
        });

        button_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openShowlist();
            }
        });

    }
    public void openShowlist(){
            Intent intent = new Intent(this, ShowList.class);
            intent.putExtra(EXTRA_TEXT, lista);
            startActivity(intent);
    }
}
