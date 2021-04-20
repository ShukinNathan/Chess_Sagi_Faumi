package com.example.chess_sagi_faumi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

    public class Board extends AppCompatActivity implements View.OnClickListener {

        protected Piece[][] board;
        protected final int max = 8;

        protected  ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        protected String str2;
        protected int str, num, num1 = 0, num2 = 0;
        protected ImageButton[][] btn;
        protected int turn;
        protected boolean ok = true;
        protected GameManager gm;
        protected ScrollView scrollView;
        protected TextView text;
        protected ImageButton imgbtn;
        protected LinearLayout layout;
        protected androidx.gridlayout.widget.GridLayout g;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_board);
            this.turn = 1;
            this.btn = new ImageButton[this.max][this.max];
            this.arr = new ArrayList<ArrayList<Integer>>();

            this.scrollView = (ScrollView)findViewById(R.id.deadScroll);
            this.layout = (LinearLayout) findViewById(R.id.deadLayout);
            this.layout.setOrientation(LinearLayout.HORIZONTAL);
            this.imgbtn = new ImageButton(this);
            this.g = (androidx.gridlayout.widget.GridLayout) findViewById(R.id.board_layout);
            createTiles();


//            createBoard();


        this.board = new Piece[this.max][this.max];
//        this.board[4][4] = new Bishop(4, 4, 'w');
//        this.btn[4][4].setImageResource(R.drawable.bishopw);
//        this.board[4][4] = new Rook(4, 4, 'w');
//        this.btn[4][4].setImageResource(R.drawable.rookw);
//        this.board[4][0] = new Knight(4, 0, 'w');
//        this.btn[4][0].setImageResource(R.drawable.knightw1);
        this.board[1][4] = new Pawn(1, 4, 'w');
        this.btn[1][4].setImageResource(R.drawable.pawnw1);
        this.board[1][4].wasMoved();
//        this.board[5][3] = new Queen(5, 4, 'w');
//        this.btn[5][3].setImageResource(R.drawable.queenw);
//        this.board[4][4] = new King(4, 4, 'w');
//        this.btn[4][4].setImageResource(R.drawable.kingw);



            this.gm = new GameManager(this);
        }


        public void createTiles(){
            for(int i = this.max; i > 0; i--){
                for (int j = 0; j < this.max; j++) {
                    num = j + 1;
                    this.str2 = String.valueOf((char) (i + 96)) + num;
                    str = getResources().getIdentifier(str2, "id", this.getPackageName());
                    this.btn[8 - i][j] = (ImageButton) findViewById(str);
                    this.btn[8 - i][j].setOnClickListener(this);
                }
            }
        }

        public void resetTiles(){
            for(int i = 0; i < this.max; i++){
                for(int j = 0; j < this.max; j++){
                    if(i % 2 == j % 2){
                        this.btn[i][j].setBackgroundResource(R.drawable.tile2);
                    }
                    else{
                        this.btn[i][j].setBackgroundResource(R.drawable.tile1);
                    }
                }
            }
        }

        public void createBoard(){
            this.board = new Piece[this.max][this.max];
            for(int i = 0; i < this.max; i++){
                for(int j = 0; j < 5; j++){
                    switch(i){
                        case 0:
                            switch (j){
                                case 0:
                                    this.board[i][j] = new Rook(i, j, 'b');
                                    this.btn[i][j].setImageResource(R.drawable.rookb);
                                    this.board[i][7-j] = new Rook(i, 7-j, 'b');
                                    this.btn[i][7-j].setImageResource(R.drawable.rookb);
                                    break;

                                case 1:
                                    this.board[i][j] = new Knight(i, j, 'b');
                                    this.btn[i][j].setImageResource(R.drawable.knightb);
                                    this.board[i][7-j] = new Knight(i, 7-j, 'b');
                                    this.btn[i][7-j].setImageResource(R.drawable.knightb);
                                    break;
                                case 2:
                                    this.board[i][j] = new Bishop(i, j, 'b');
                                    this.btn[i][j].setImageResource(R.drawable.bishopb);
                                    this.board[i][7-j] = new Bishop(i, 7-j, 'b');
                                    this.btn[i][7-j].setImageResource(R.drawable.bishopb2);
                                    break;
                                case 3:
                                    this.board[i][j] = new Queen(i, j, 'b');
                                    this.btn[i][j].setImageResource(R.drawable.queenb);
                                    break;
                                case 4:
                                    this.board[i][j] = new King(i, j, 'b');
                                    this.btn[i][j].setImageResource(R.drawable.kingb);
                                    break;
                            }
                            break;
                        case 1:
                            this.board[i][j] = new Pawn(i, j, 'b');
                            this.btn[i][j].setImageResource(R.drawable.pawnb8);
                            this.board[i][7-j] = new Pawn(i, 7-j, 'b');
                            this.btn[i][7-j].setImageResource(R.drawable.pawnb8);
                            break;

                        case 6:
                            this.board[i][j] = new Pawn(i, j, 'w');
                            this.btn[i][j].setImageResource(R.drawable.pawnw1);
                            this.board[i][7-j] = new Pawn(i, 7-j, 'w');
                            this.btn[i][7-j].setImageResource(R.drawable.pawnw1);
                            break;

                        case 7:
                            switch (j){
                                case 0:
                                    this.board[i][j] = new Rook(i, j, 'w');
                                    this.btn[i][j].setImageResource(R.drawable.rookw);
                                    this.board[i][7-j] = new Rook(i, 7-j, 'w');
                                    this.btn[i][7-j].setImageResource(R.drawable.rookw);
                                    break;

                                case 1:
                                    this.board[i][j] = new Knight(i, j, 'w');
                                    this.btn[i][j].setImageResource(R.drawable.knightw);
                                    this.board[i][7-j] = new Knight(i, 7-j, 'w');
                                    this.btn[i][7-j].setImageResource(R.drawable.knightw);
                                    break;
                                case 2:
                                    this.board[i][j] = new Bishop(i, j, 'w');
                                    this.btn[i][j].setImageResource(R.drawable.bishopw);
                                    this.board[i][7-j] = new Bishop(i, 7-j, 'w');
                                    this.btn[i][7-j].setImageResource(R.drawable.bishopw2);
                                    break;
                                case 3:
                                    this.board[i][j] = new Queen(i, j, 'w');
                                    this.btn[i][j].setImageResource(R.drawable.queenw);
                                    break;
                                case 4:
                                    this.board[i][j] = new King(i, j, 'w');
                                    this.btn[i][j].setImageResource(R.drawable.kingw);
                                    break;
                            }
                            break;
                        default:
                            this.board[i][j] = null;
                            this.board[i][7-j] = null;
                    }
                }

            }
        }


        public void otherSidePawn(Piece p, ArrayList<Piece> eaten){

//            this.layout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            this.layout.addView(createScrollView(eaten));
            this.layout.setVisibility(View.VISIBLE);
            Context context = getApplicationContext();
            CharSequence text;
            this.scrollView.setVisibility(View.VISIBLE);
            this.g.setVisibility(View.INVISIBLE);
            if(this.layout.isShown()){
                text = "yes" ;
            }
            else{
               text = "no" ;
            }

            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();


        }

        public LinearLayout createScrollView(ArrayList<Piece> arr){
            Piece p;
            LinearLayout l = new LinearLayout(this);
            l.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            this.imgbtn.setBackgroundResource(R.drawable.tile2);
            this.imgbtn.setLayoutParams(l.getLayoutParams());

            for(int i = 0; i < arr.size(); i++){
                p = arr.get(i);
                this.imgbtn.setVisibility(View.VISIBLE);
                switch (p.getType()){
                    case "Bishop":
                        if (p.getColor() == 'w') {
                            this.imgbtn.setImageResource(R.drawable.bishopw);

                        }
                        else{
                            this.imgbtn.setImageResource(R.drawable.bishopb);
                        }
                        break;

                    case "Rook":
                        if (p.getColor() == 'w') {
                            this.imgbtn.setImageResource(R.drawable.rookw);
                        }
                        else{
                            this.imgbtn.setImageResource(R.drawable.rookb);
                        }
                        break;

                    case "Knight":
                        if (p.getColor() == 'w') {
                            this.imgbtn.setImageResource(R.drawable.knightw);
                        }
                        else{
                            this.imgbtn.setImageResource(R.drawable.knightb);
                        }
                        break;

                    case "Queen":
                        if (p.getColor() == 'w') {
                            this.imgbtn.setImageResource(R.drawable.queenw);
                        }
                        else{
                            this.imgbtn.setImageResource(R.drawable.queenb);
                        }
                        break;

                    case "King":
                        if (p.getColor() == 'w') {
                            this.imgbtn.setImageResource(R.drawable.kingw);

                        }
                        else{
                            this.imgbtn.setImageResource(R.drawable.kingb);
                        }
                        break;
                }
            }
            return l;
        }

        @Override
        public void onClick(View view) {
            boolean ok = false;
            for(int i = this.max; i > 0; i--){
                for(int j = 0; j < this.max; j++){
                    num = j + 1;
                    this.str2 = String.valueOf((char) (i + 96)) + num;
                    str = getResources().getIdentifier(str2, "id", this.getPackageName());
                    if(view.getId() == str){
                        this.gm.movePiece(view);
                        ok = true;
                    }
                }
            }

            if(!ok){

            }
        }
}