package com.example.chess_sagi_faumi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class multiplayer extends Board implements View.OnClickListener {
    private String str;
    private TextView textView;
    private Intent name_getter;
    int turn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplayer);

        Intent i = getIntent();
        Bundle b = i.getExtras();
        this.textView = (TextView)findViewById(R.id.multiplayer_title);
        this.str =(String) b.get("Text");
        this.textView.setText(this.str);
        this.turn = 1;
    }

    @Override
    public void onClick(View view) {

    }
}