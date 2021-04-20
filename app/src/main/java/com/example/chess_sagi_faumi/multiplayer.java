package com.example.chess_sagi_faumi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class multiplayer extends Board implements View.OnClickListener {
    private String str, name1, name2;
    private TextView textView;
    private Intent name_getter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplayer);

        Intent i = getIntent();
        Bundle b = i.getExtras();
        this.textView = (TextView)findViewById(R.id.multiplayer_title);
        this.name1 = (String) b.get("name1");
        this.name2 = (String) b.get("name2");
        this.str = this.name1 + " vs " + this.name2;
        this.textView.setText(this.str);
    }

    @Override
    public void onClick(View view) {

    }
}