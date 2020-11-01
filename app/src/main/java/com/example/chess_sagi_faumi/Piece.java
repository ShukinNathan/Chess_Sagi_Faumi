package com.example.chess_sagi_faumi;


import android.media.Image;
import android.widget.ImageButton;

import org.w3c.dom.Node;

import java.util.ArrayList;

public class Piece extends Board{
    protected int vertical_position, horizontal_position;
    protected char color;
    protected String type;
    public Piece(int horizontal_position, int vertical_position, char color, String type){
        this.horizontal_position = horizontal_position;
        this.vertical_position = vertical_position;
        this.color = color;
        this.type = type;
    }

    public char getColor() {
        return color;
    }

    public int getHorizontal_position() {
        return horizontal_position;
    }

    public int getVertical_position() {
        return vertical_position;
    }

    public String getType() {
        return type;
    }


    public void setColor(char color) {
        this.color = color;
    }

    public void setHorizontal_position(int horizontal_position) {
        this.horizontal_position = horizontal_position;
    }

    public void setVertical_position(int vertical_position) {
        this.vertical_position = vertical_position;
    }

    public void setType(String type) {
        this.type = type;
    }
}

class Pawn extends Piece{
    public Pawn(int horizontal_position, int vertical_position, char color){
        super(horizontal_position, vertical_position, color, "pawn");
    }

    public ArrayList<ArrayList<Integer>> pawnMoves(int turn){
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> arr2;
        int a = getHorizontal_position(), b = getVertical_position();
        if(this.color == 'b'){
            if(turn == 1){
                int i = 1;
                while(i < 3){
                    arr2 = new ArrayList<Integer>();
                    arr2.add(a + i);
                    arr2.add(b);
                    arr.add(arr2);
                    i++;
                }
            }
            else{
                arr2 = new ArrayList<Integer>();
                arr2.add(a + 1);
                arr2.add(b);
                arr.add(arr2);
            }
        }
        else{
            if(turn == 1){
                int i = 1;
                while(i < 3){
                    arr2 = new ArrayList<Integer>();
                    arr2.add(a - i);
                    arr2.add(b);
                    arr.add(arr2);
                    i++;
                }
            }
            else{
                arr2 = new ArrayList<Integer>();
                arr2.add(a - 1);
                arr2.add(b);
                arr.add(arr2);
            }
        }
        return arr;
    }
}

class Rook extends Piece{
    public Rook(int horizontal_position, int vertical_position, char color){
        super(horizontal_position, vertical_position, color, "rook");
        for(int i = 1; i <= 8; i++){

        }
    }

    public ArrayList<ArrayList<Integer>> rookMoves(){
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> arr2 ;
        int a = getHorizontal_position(), b = getVertical_position();
        for(int i = 1; i <= 8; i++){
            for(int j = 1; j <= 8; j++){
                if(b + j < 8){
                    arr2 = new ArrayList<Integer>();
                    arr2.add(a);
                    arr2.add(b + j);
//                    if(this.board[a][b+j] != null){
                        arr.add(arr2);
//                    }
                }
                if(b - j >= 0){
                    arr2 = new ArrayList<Integer>();
                    arr2.add(a);
                    arr2.add(b - j);
//                    if(this.board[a][b-j] == null){
                        arr.add(arr2);
//                    }
                }
            }
            if(a + i < 8){
                arr2 = new ArrayList<Integer>();
                arr2.add(a + i);
                arr2.add(b);
//                if(this.board[a+i][b] == null){
                    arr.add(arr2);
//                }
            }
            if(a - i >= 0){
                arr2 = new ArrayList<Integer>();
                arr2.add(a - i);
                arr2.add(b);
//                if(this.board[a-i][b] == null){
                    arr.add(arr2);
//                }
            }
        }
        return arr;
    }

}

class Bishop extends Piece{
    public Bishop(int horizontal_position, int vertical_position, char color){
        super(horizontal_position, vertical_position, color, "bishop");
    }
    public ArrayList<ArrayList<Integer>> bishopMoves(){
        int a = getHorizontal_position(), b = getVertical_position() ;
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> arr2;
        int k = 0, num;
        for(int i = 1; i <= 8; i++){
            for(int j = 1; j <= 8; j++){
                if(j == i && j != 0){
                    if(a + i < 8 && b + j < 8){
                        arr2 = new ArrayList<Integer>();
                        arr2.add(a + i);
                        arr2.add(b + j);
//                        if( p == null){
                            arr.add(arr2);
//                        }
                    }
                    if(a + i < 8 && b - j >= 0){
                        arr2 = new ArrayList<Integer>();
                        arr2.add(a + i);
                        arr2.add(b - j);
//                        if(getPiece(a + i, b - j) == null){
                            arr.add(arr2);
//                        }
                    }
                    if(a - i >=0 && b + j < 8){
                        arr2 = new ArrayList<Integer>();
                        arr2.add(a - i);
                        arr2.add(b + j);
//                        if(p == null){
                            arr.add(arr2);
//                        }
                    }
                    if(a - i >= 0 && b - j >= 0){
                        arr2 = new ArrayList<Integer>();
                        arr2.add(a - i);
                        arr2.add(b - j);
//                        if(p == null){
                            arr.add(arr2);
//                        }
                    }
                }
            }
        }
        return arr;
    }
}

class Knight extends Piece{
    public Knight(int horizontal_position, int vertical_position, char color){
        super(horizontal_position, vertical_position, color, "knight");
    }

    public ArrayList<ArrayList<Integer>> knightMoves(){
        int a = getHorizontal_position(), b = getVertical_position() ;
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> arr2;

        if(a + 2 < 8){
            if(b + 1 < 8){
                arr2 = new ArrayList<Integer>();
                arr2.add(a + 2);
                arr2.add(b + 1);
                arr.add(arr2);
            }
            if(b - 1  >= 0){
                arr2 = new ArrayList<Integer>();
                arr2.add(a + 2);
                arr2.add(b - 1);
                arr.add(arr2);
            }
        }
        if(a - 2 >= 0){
            if(b + 1 < 8){
                arr2 = new ArrayList<Integer>();
                arr2.add(a - 2);
                arr2.add(b + 1);
                arr.add(arr2);
            }
            if(b - 1  >= 0){
                arr2 = new ArrayList<Integer>();
                arr2.add(a - 2);
                arr2.add(b - 1);
                arr.add(arr2);
            }
        }
        if(b + 2 < 8){
            if(a + 1 < 8){
                arr2 = new ArrayList<Integer>();
                arr2.add(a + 1);
                arr2.add(b + 2);
                arr.add(arr2);
            }
            if(a-1  >= 0){
                arr2 = new ArrayList<Integer>();
                arr2.add(a - 1);
                arr2.add(b + 2);
                arr.add(arr2);
            }
        }
        if(b - 2 >= 0){
            if(a + 1 < 8){
                arr2 = new ArrayList<Integer>();
                arr2.add(a + 1);
                arr2.add(b - 2);
                arr.add(arr2);
            }
            if(a - 1  >= 0){
                arr2 = new ArrayList<Integer>();
                arr2.add(a - 1 );
                arr2.add(b - 2);
                arr.add(arr2);
            }
        }
        return arr;
    }
}

class Queen extends Piece{
    public Queen(int horizontal_position, int vertical_position, char color){
        super(horizontal_position, vertical_position, color, "queen");
    }

    public ArrayList<ArrayList<Integer>> queenMoves(){
        int a = getHorizontal_position(), b = getVertical_position() ;
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> arr2;

        for(int i = 1; i <= 8; i++){
            for(int j = 1; j <= 8; j++){
                if(b + j < 8){
                    arr2 = new ArrayList<Integer>();
                    arr2.add(a);
                    arr2.add(b + j);
                    arr.add(arr2);
                }
                if(b - j >= 0){
                    arr2 = new ArrayList<Integer>();
                    arr2.add(a);
                    arr2.add(b - j);
                    arr.add(arr2);
                }
                if(j == i && j != 0){
                    if(a + i < 8 && b + j < 8){
                        arr2 = new ArrayList<Integer>();
                        arr2.add(a + i);
                        arr2.add(b + j);
                        arr.add(arr2);
                    }
                    if(a + i < 8 && b - j >= 0){
                        arr2 = new ArrayList<Integer>();
                        arr2.add(a + i);
                        arr2.add(b - j);
                        arr.add(arr2);
                    }
                    if(a - i >=0 && b + j < 8){
                        arr2 = new ArrayList<Integer>();
                        arr2.add(a - i);
                        arr2.add(b + j);
                        arr.add(arr2);
                    }
                    if(a-i >= 0 && b-j >= 0){
                        arr2 = new ArrayList<Integer>();
                        arr2.add(a - i);
                        arr2.add(b - j);
                        arr.add(arr2);
                    }
                }
            }
            if(a + i < 8){
                arr2 = new ArrayList<Integer>();
                arr2.add(a + i);
                arr2.add(b);
                arr.add(arr2);
            }
            if(a - i >= 0){
                arr2 = new ArrayList<Integer>();
                arr2.add(a - i);
                arr2.add(b);
                arr.add(arr2);
            }
        }
        return arr;
    }
}

class King extends Piece{
    public King(int horizontal_position, int vertical_position, char color){
        super(horizontal_position, vertical_position, color, "king");
    }

    public ArrayList<ArrayList<Integer>> kingMoves(){
        int a = getHorizontal_position(), b = getVertical_position() ;
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> arr2;

        for(int i = 1; i <= 1; i++){
            for(int j = 1; j <= 1; j++){
                if(b + j < 8){
                    arr2 = new ArrayList<Integer>();
                    arr2.add(a);
                    arr2.add(b + j);
                    arr.add(arr2);
                }
                if(b - j >= 0){
                    arr2 = new ArrayList<Integer>();
                    arr2.add(a);
                    arr2.add(b - j);
                    arr.add(arr2);
                }
                if(j == i && j != 0){
                    if(a + i < 8 && b + j < 8){
                        arr2 = new ArrayList<Integer>();
                        arr2.add(a + i);
                        arr2.add(b + j);
                        arr.add(arr2);
                    }
                    if(a + i < 8 && b - j >= 0){
                        arr2 = new ArrayList<Integer>();
                        arr2.add(a + i);
                        arr2.add(b - j);
                        arr.add(arr2);
                    }
                    if(a - i >=0 && b + j < 8){
                        arr2 = new ArrayList<Integer>();
                        arr2.add(a - i);
                        arr2.add(b + j);
                        arr.add(arr2);
                    }
                    if(a-i >= 0 && b-j >= 0){
                        arr2 = new ArrayList<Integer>();
                        arr2.add(a - i);
                        arr2.add(b - j);
                        arr.add(arr2);
                    }
                }
            }
            if(a + i < 8){
                arr2 = new ArrayList<Integer>();
                arr2.add(a + i);
                arr2.add(b);
                arr.add(arr2);
            }
            if(a - i >= 0){
                arr2 = new ArrayList<Integer>();
                arr2.add(a - i);
                arr2.add(b);
                arr.add(arr2);
            }
        }
        return arr;
    }


}










