package com.example.chess_sagi_faumi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class singleplayer extends Board implements View.OnClickListener {
    private TextView textview;
    private View view;
    private String name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singleplayer);
        this.textview = (TextView)findViewById(R.id.singleplayer_view);
        Intent i = getIntent();
        Bundle b = i.getExtras();
        this.name = (String) b.get("name") + "VS computer";
        this.textview.setText(this.name);
    }

    @Override
    public void onClick(View view) {
    }
}