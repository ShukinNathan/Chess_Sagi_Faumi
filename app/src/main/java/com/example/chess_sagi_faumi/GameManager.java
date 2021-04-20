package com.example.chess_sagi_faumi;

import android.view.View;
import android.content.Intent;
import android.widget.ImageButton;

import java.util.ArrayList;

public class GameManager {
    protected Board board2;
    protected Piece[][] board;
    protected int max = 8;
    protected ImageButton[][] btn;
    protected ArrayList<ArrayList<Integer>> arr;
    protected int turn, num1, num2;
    protected ArrayList<Piece> w_eaten, b_eaten;
    protected String type;

    public GameManager(Board board){
        this.board2 = board;
        this.btn = this.board2.btn;
        this.turn = this.board2.turn;
        this.board = this.board2.board;
        this.w_eaten = new ArrayList<Piece>();
        this.b_eaten = new ArrayList<Piece>();
        this.arr = new ArrayList<ArrayList<Integer>>();

        this.w_eaten.add(new Piece('w', "Rook"));
        this.w_eaten.add(new Piece('w', "Queen"));
        this.w_eaten.add(new Piece('w', "Bishop"));
    }
    public ArrayList<ArrayList<Integer>> showPieceMoves(View view){
        ArrayList<Integer> arr2;
        for(int i = 0; i < this.max; i++){
            for(int j = 0; j< this.max; j++){
                if(view.getId() == this.btn[i][j].getId()){

                    switch(this.board[i][j].getType()){
                        case "Bishop":
                            Bishop b = (Bishop) this.board[i][j];
                            arr = b.bishopMoves(this.board, i, j);
                            if(arr != null){
                                for(int k = 0; k < arr.size(); k++){
                                    arr2 = arr.get(k);
                                    this.btn[arr2.get(0)][arr2.get(1)].setBackgroundResource(R.color.colorPrimary);
                                }
                            }
                            break;

                        case "Rook":
                            Rook r = (Rook) this.board[i][j];
                            arr = r.rookMoves(this.board, i, j);
                            if(arr != null){
                                for(int k = 0; k < arr.size(); k++){
                                    arr2 = arr.get(k);
                                    this.btn[arr2.get(0)][arr2.get(1)].setBackgroundResource(R.color.colorPrimary);
                                }
                            }
                            break;

                        case "Knight":
                            Knight k = (Knight) this.board[i][j];
                            arr = k.knightMoves(this.board, i, j);
                            if(arr != null){
                                for(int h = 0; h < arr.size(); h++){
                                    arr2 = arr.get(h);
                                    this.btn[arr2.get(0)][arr2.get(1)].setBackgroundResource(R.color.colorPrimary);
                                }
                            }
                            break;

                        case "Pawn":
                            Pawn P = (Pawn) this.board[i][j];
                            arr = P.pawnMoves(this.turn, this.board, i, j);
                            if(arr != null){
                                for(int h = 0; h < arr.size(); h++){
                                    arr2 = arr.get(h);
                                    this.btn[arr2.get(0)][arr2.get(1)].setBackgroundResource(R.color.colorPrimary);
                                }
                            }
                            break;

                        case "Queen":
                            Queen q = (Queen) this.board[i][j];
                            arr = q.queenMoves(this.board, i, j);
                            if(arr != null){
                                for(int h = 0; h < arr.size(); h++){
                                    arr2 = arr.get(h);
                                    this.btn[arr2.get(0)][arr2.get(1)].setBackgroundResource(R.color.colorPrimary);
                                }
                            }
                            break;

                        case "King":
                            King K = (King) this.board[i][j];
                            arr = K.kingMoves(this.board, i, j);
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
        return arr;
    }

    public void movePiece(View view){
//        if(turn % 2 == 0){
//            blackMove(view);
//        }
//        else{
            whiteMove(view);
//        }
    }


    public void blackMove(View view) {
        if(this.arr.size() == 0){
            for(int i = 0; i < this.max; i++){
                for(int j = 0; j < this.max; j++){
                    if(this.btn[i][j].getId() == view.getId()){
                        if(this.board[i][j] != null){
                            if(this.board[i][j].getColor() == 'b'){
                                num1 = i;
                                num2 = j;
                                arr = showPieceMoves(view);
                            }
                        }
                    }
                }
            }
        }
        else{
            ArrayList<Integer> arr2;
            for(int h = 0; h < arr.size(); h++){
                arr2 = arr.get(h);
                int i = arr2.get(0), j = arr2.get(1);
                if(this.btn[i][j].getId() == view.getId()){
                    if(this.board[i][j] != null){
                        if (this.board[i][j].getColor() == 'w'  && this.board[i][j].getType() != "Pawn") {
                            this.w_eaten.add(this.board[i][j]);
                        }
                    }


                    switch (this.board[num1][num2].getType()){
                        case "Bishop":
                            this.board[i][j] = new Bishop((Bishop) this.board[num1][num2]);
                            break;

                        case "Rook":
                            this.board[i][j] = new Rook((Rook) this.board[num1][num2]);
                            break;

                        case "Knight":
                            this.board[i][j] = new Knight((Knight) this.board[num1][num2]);
                            break;

                        case "Queen":
                            this.board[i][j] = new Queen((Queen) this.board[num1][num2]);
                            break;

                        case "King":
                            this.board[i][j] = new King((King) this.board[num1][num2]);
                            break;

                        default:
                            this.board[i][j] = new Pawn((Pawn) this.board[num1][num2]);
                            break;
                    }


                    this.board[num1][num2] = null;
                    if(this.board[i][j] != null){
                        this.board[i][j].set_Position(i, j);

                        if(this.board[i][j].getType().equals("Pawn")){
                            Pawn p = (Pawn) this.board[i][j];
                            this.board[i][j] = p;
                            if(i == 7 || i == 0){
                                this.board2.otherSidePawn(this.board[i][j], this.b_eaten);
                            }
                        }
                    }

                    this.btn[i][j].setImageDrawable(this.btn[num1][num2].getDrawable());
                    this.btn[num1][num2].setImageResource(0);
                    this.board[i][j].wasMoved = true;
                    this.turn++;

                }

            }
            this.arr = null;
            this.arr = new ArrayList<ArrayList<Integer>>();
            this.board2.resetTiles();
        }
    }

    public void whiteMove(View view) {
        if(this.arr.size() == 0){
            for(int i = 0; i < this.max; i++){
                for(int j = 0; j < this.max; j++){
                    if(this.btn[i][j].getId() == view.getId()){
                        if(this.board[i][j] != null){
                            if(this.board[i][j].getColor() == 'w'){
                                num1 = i;
                                num2 = j;
                                arr = showPieceMoves(view); }
                        }
                    }
                }
            }
        }
        else{
            ArrayList<Integer> arr2;
            for(int h = 0; h < arr.size(); h++){
                arr2 = arr.get(h);
                int i = arr2.get(0), j = arr2.get(1);
                if(this.btn[i][j].getId() == view.getId()){
                    if(this.board[i][j] != null){
                        if (this.board[i][j].getColor() == 'w' && this.board[i][j].getType() != "Pawn") {
                            this.b_eaten.add(this.board[i][j]);
                        }
                    }


                    switch (this.board[num1][num2].getType()){
                        case "Bishop":
                            this.board[i][j] = new Bishop((Bishop) this.board[num1][num2]);
                            break;

                        case "Rook":
                            this.board[i][j] = new Rook((Rook) this.board[num1][num2]);
                            break;

                        case "Knight":
                            this.board[i][j] = new Knight((Knight) this.board[num1][num2]);
                            break;

                        case "Queen":
                            this.board[i][j] = new Queen((Queen) this.board[num1][num2]);
                            break;

                        case "King":
                            this.board[i][j] = new King((King) this.board[num1][num2]);
                            break;

                        default:
                            this.board[i][j] = new Pawn((Pawn) this.board[num1][num2]);
                            break;
                    }


                    this.board[num1][num2] = null;
                    if(this.board[i][j] != null){
                        this.board[i][j].set_Position(i, j);

                        if(this.board[i][j].getType().equals("Pawn")){
                            if(i == 0){
                                this.w_eaten.add(new Piece('w', "Rook"));
                                this.w_eaten.add(new Piece('w', "Queen"));
                                this.w_eaten.add(new Piece('w', "Bishop"));
                                this.board2.otherSidePawn(this.board[i][j], this.w_eaten);
                            }
                        }
                    }

                    this.btn[i][j].setImageDrawable(this.btn[num1][num2].getDrawable());
                    this.btn[num1][num2].setImageResource(0);
                    this.board[i][j].wasMoved = true;
                    this.turn++;
                }
            }
            this.arr = null;
            this.arr = new ArrayList<ArrayList<Integer>>();
            this.board2.resetTiles();
        }
    }
}
