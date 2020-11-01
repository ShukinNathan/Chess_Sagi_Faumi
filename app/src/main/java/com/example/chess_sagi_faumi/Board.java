package com.example.chess_sagi_faumi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Picture;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class Board extends AppCompatActivity implements View.OnClickListener {

    protected Piece[][] board;
    protected final int max = 8;

    protected String str2;
    protected int str, num;
    protected ImageButton[][] btn;
    protected int turn;
    protected boolean ok = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);
        this.turn = 1;
        this.btn = new ImageButton[this.max][this.max];
        createTiles();
        createBoard();

//        this.board = new Piece[this.max][this.max];
//        this.board[4][4] = new Bishop(4, 4, 'w');
//        this.btn[4][4].setImageResource(R.drawable.bishopw);
//        this.board[4][4] = new Rook(4, 4, 'w');
//        this.btn[4][4].setImageResource(R.drawable.rookw);
//        this.board[4][4] = new Knight(4, 4, 'w');
//        this.btn[4][4].setImageResource(R.drawable.knightw1);
//        this.board[4][4] = new Pawn(4, 4, 'w');
//        this.btn[4][4].setImageResource(R.drawable.pawnw1);
//        this.board[4][4] = new Queen(4, 4, 'w');
//        this.btn[4][4].setImageResource(R.drawable.queenw);
//        this.board[4][4] = new King(4, 4, 'w');
//        this.btn[4][4].setImageResource(R.drawable.knightw1);
    }


    public void createTiles(){
        for(int i = 0; i < this.max; i++){
            switch(i) {
                case 6:
                    for (int j = 0; j < this.btn[i].length; j++) {
                        num = j + 1;
                        this.str2 = "b" + num;
                        str = getResources().getIdentifier(str2, "id", this.getPackageName());
                        this.btn[i][j] = (ImageButton) findViewById(str);
                        this.btn[i][j].setOnClickListener(this);
                    }
                    break;

                case 5:
                    for (int j = 0; j < this.btn[i].length; j++) {
                        num = j + 1;
                        this.str2 = "c" + num;
                        str = getResources().getIdentifier(str2, "id", this.getPackageName());
                        this.btn[i][j] = (ImageButton) findViewById(str);
                        this.btn[i][j].setOnClickListener(this);
                    }
                    break;

                case 4:
                    for (int j = 0; j < this.btn[i].length; j++) {
                        num = j + 1;
                        this.str2 = "d" + num;
                        str = getResources().getIdentifier(str2, "id", this.getPackageName());
                        this.btn[i][j] = (ImageButton) findViewById(str);
                        this.btn[i][j].setOnClickListener(this);
                    }
                    break;

                case 3:
                    for (int j = 0; j < this.btn[i].length; j++) {
                        num = j + 1;
                        this.str2 = "e" + num;
                        str = getResources().getIdentifier(str2, "id", this.getPackageName());
                        this.btn[i][j] = (ImageButton) findViewById(str);
                        this.btn[i][j].setOnClickListener(this);
                    }
                    break;

                case 2:
                    for (int j = 0; j < this.btn[i].length; j++) {
                        num = j + 1;
                        this.str2 = "f" + num;
                        str = getResources().getIdentifier(str2, "id", this.getPackageName());
                        this.btn[i][j] = (ImageButton) findViewById(str);
                        this.btn[i][j].setOnClickListener(this);
                    }
                    break;

                case 1:
                    for (int j = 0; j < this.btn[i].length; j++) {
                        num = j + 1;
                        this.str2 = "g" + num;
                        str = getResources().getIdentifier(str2, "id", this.getPackageName());
                        this.btn[i][j] = (ImageButton) findViewById(str);
                        this.btn[i][j].setOnClickListener(this);
                    }
                    break;

                case 0:
                    for (int j = 0; j < this.btn[i].length; j++) {
                        num = j + 1;
                        this.str2 = "h" + num;
                        str = getResources().getIdentifier(str2, "id", this.getPackageName());
                        this.btn[i][j] = (ImageButton) findViewById(str);
                        this.btn[i][j].setOnClickListener(this);
                    }
                    break;

                default:
                    for (int j = 0; j < this.btn[i].length; j++) {
                        num = j + 1;
                        str2 = "a" + num;
                        str = getResources().getIdentifier(str2, "id", this.getPackageName());
                        this.btn[i][j] = (ImageButton) findViewById(str);
                        this.btn[i][j].setOnClickListener(this);
                    }
                    break;

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
                                this.btn[i][j].setImageResource(R.drawable.knightb1);
                                this.board[i][7-j] = new Knight(i, 7-j, 'b');
                                this.btn[i][7-j].setImageResource(R.drawable.knightb1);
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
                                this.btn[i][j].setImageResource(R.drawable.knightw1);
                                this.board[i][7-j] = new Knight(i, 7-j, 'w');
                                this.btn[i][7-j].setImageResource(R.drawable.knightw1);
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

    @Override
    public void onClick(View view) {
        resetTiles();
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> arr2;
        for(int i = 0; i < this.max; i++){
            for(int j = 0; j< this.max; j++){
                if(view.getId() == this.btn[i][j].getId()){
                    Piece p = this.board[i][j];
                    switch(this.board[i][j].getType()){
                        case "bishop":
                            Bishop b = (Bishop) this.board[i][j];
                            arr = b.bishopMoves();
                            if(arr != null){
                                for(int k = 0; k < arr.size(); k++){
                                    arr2 = arr.get(k);
                                    this.btn[arr2.get(0)][arr2.get(1)].setBackgroundResource(R.color.colorPrimary);
                                }
                            }
                            break;

                        case "rook":
                            Rook r = (Rook) this.board[i][j];
                            arr = r.rookMoves();
                            if(arr != null){
                                for(int k = 0; k < arr.size(); k++){
                                    arr2 = arr.get(k);
                                    this.btn[arr2.get(0)][arr2.get(1)].setBackgroundResource(R.color.colorPrimary);
                                }
                            }
                            break;

                        case "knight":
                            Knight k = (Knight) this.board[i][j];
                            arr = k.knightMoves();
                            if(arr != null){
                                for(int h = 0; h < arr.size(); h++){
                                    arr2 = arr.get(h);
                                    this.btn[arr2.get(0)][arr2.get(1)].setBackgroundResource(R.color.colorPrimary);
                                }
                            }
                            break;

                        case "pawn":
                            Pawn P = (Pawn) this.board[i][j];
                            arr = P.pawnMoves(this.turn);
                            if(arr != null){
                                for(int h = 0; h < arr.size(); h++){
                                    arr2 = arr.get(h);
                                    this.btn[arr2.get(0)][arr2.get(1)].setBackgroundResource(R.color.colorPrimary);
                                }
                            }
                            break;

                        case "queen":
                            Queen q = (Queen) this.board[i][j];
                            arr = q.queenMoves();
                            if(arr != null){
                                for(int h = 0; h < arr.size(); h++){
                                    arr2 = arr.get(h);
                                    this.btn[arr2.get(0)][arr2.get(1)].setBackgroundResource(R.color.colorPrimary);
                                }
                            }
                            break;

                        case "king":
                            King K = (King) this.board[i][j];
                            arr = K.kingMoves();
                            if(arr != null){
                                for(int h = 0; h < arr.size(); h++){
                                    arr2 = arr.get(h);
                                    this.btn[arr2.get(0)][arr2.get(1)].setBackgroundResource(R.color.colorPrimary);
                                }
                            }
                            break;

                        default:
                            break;

                    }
                }
            }
        }
    }
}