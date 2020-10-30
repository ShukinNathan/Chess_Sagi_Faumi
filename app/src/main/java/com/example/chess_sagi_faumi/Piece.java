package com.example.chess_sagi_faumi;


import android.media.Image;
import android.widget.ImageButton;

import org.w3c.dom.Node;

public class Piece {
    private int vertical_position, horizontal_position;
    private char color;
    private String type;
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
}

class Rook extends Piece{
    public Rook(int horizontal_position, int vertical_position, char color){
        super(horizontal_position, vertical_position, color, "rook");
    }
}

class Bishop extends Piece{
    public Bishop(int horizontal_position, int vertical_position, char color){
        super(horizontal_position, vertical_position, color, "bishop");
    }
    public int[] BishopMoves(){
        int a = getHorizontal_position(), b = getVertical_position() ;
        int[] arr = new int [64];
        int k = 0, num;
        for(int i = 1; i <= 8; i++){
            for(int j = 1; j <= 8; j++){
                if(j == i && j != 0){
                    if(a+i < 8 && b+j < 8){
                        num = (a + j) * 10 + (b + j);
                        arr[k] = num;
                        k++;
                    }
                    if(a+i < 8 && b-j >= 0){
                        num = (a + j) * 10 + (b - j);
                        arr[k] = num;
                        k++;
                    }
                    if(a-i >=0 && b+j < 8){
                        num = (a - j) * 10 + (b + j);
                        arr[k] = num;
                        k++;
                    }
                    if(a-i >= 0 && b-j >= 0){
                        num = (a - j) * 10 + (b - j);
                        arr[k] = num;
                        k++;
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
}

class Queen extends Piece{
    public Queen(int horizontal_position, int vertical_position, char color){
        super(horizontal_position, vertical_position, color, "queen");
    }
}

class King extends Piece{
    public King(int horizontal_position, int vertical_position, char color){
        super(horizontal_position, vertical_position, color, "king");
    }


}










