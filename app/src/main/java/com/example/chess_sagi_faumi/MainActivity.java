package com.example.chess_sagi_faumi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button singleplayer, multiplayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.singleplayer = (Button)findViewById(R.id.choose_singleplayer);
        this.multiplayer = (Button)findViewById(R.id.choose_multiplayer);
        this.singleplayer.setOnClickListener(this);
        this.multiplayer.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        Intent intent = new Intent(MainActivity.this, name_getter.class);
        switch(view.getId()){
            case R.id.choose_multiplayer:
                intent.putExtra("multi", true);
                startActivity(intent);
                break;
            default:
                intent.putExtra("multi", false);
                startActivity(intent);
                break;
        }
        startActivity(new Intent(MainActivity.this, Board.class));
    }
}