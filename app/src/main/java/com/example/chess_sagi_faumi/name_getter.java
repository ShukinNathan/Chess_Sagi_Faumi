package com.example.chess_sagi_faumi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class name_getter extends AppCompatActivity implements View.OnClickListener{

    private Button btn;
    private EditText edittext;
    public Editable name1;
    public String text;
    public boolean multi, ok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_getter);
        this.btn = (Button)findViewById(R.id.multi_name_btn);
        this.btn.setOnClickListener(this);
        this.edittext = (EditText)findViewById(R.id.multi_name_edit);
        Intent intent = getIntent();
        Bundle b =  intent.getExtras();
        this.multi = (boolean) b.get("multi");
        if(multi){
            this.edittext.setText("first player name");
            this.ok = true;
        }
        else{
            this.edittext.setText("enter name");
        }

        this.ok = true;
    }


    @Override
    public void onClick(View view) {
        Intent intent = new Intent(name_getter.this, multiplayer.class);
        if(multi){
            if(ok){
                this.name1 = this.edittext.getText();
                this.edittext.setText("second player name");
                this.ok = false;
                intent.putExtra("name1", this.name1);
            }
            else{
                this.text = this.name1 + " VS " + this.edittext.getText();
                intent.putExtra("name2", this.name1);
                startActivity(intent);
            }
        }
        else {
            this.name1 = this.edittext.getText();
            this.name1 = this.name1;
            intent.putExtra("name", this.name1);
            startActivity(intent);
        }
    }


}