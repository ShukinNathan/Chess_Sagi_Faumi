package com.example.chess_sagi_faumi;


import android.media.Image;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;

import org.w3c.dom.Node;

import java.util.ArrayList;

public class Piece extends Board{
    protected int vertical_position,  horizontal_position;
    protected char color;
    protected String type;
    protected boolean wasMoved;
    protected ScrollView scrollView;
    protected TextView text;
    protected ImageButton imgbtn;

    public Piece(Piece p){
        this.vertical_position = p.vertical_position;
        this.horizontal_position = p.horizontal_position;
        this.color = p.color;
        this.type = p.type;
        this.wasMoved = false;
    }

    public Piece(char color, String type){
        this.color = color;
        this.type = type;
    }
    public Piece(int horizontal_position, int vertical_position, char color, String type){
        this.horizontal_position = horizontal_position;
        this.vertical_position = vertical_position;
        this.color = color;
        this.type = type;
        this.wasMoved = false;

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


    public void wasMoved(){
        this.wasMoved = true;
    }
    public void setColor(char color) {
        this.color = color;
    }

    public void set_Position(int horizontal_position, int vertical_position){
        this.vertical_position = vertical_position;
        this.horizontal_position = horizontal_position;
    }

    public char oppositeColor(){
        if(this.color == 'b'){
            return 'w';
        }
        else{
             return 'b';
        }
    }
    public void setType(String type) {
        this.type = type;
    }



}

class Pawn extends Piece{
    public Pawn(int horizontal_position, int vertical_position, char color){
        super(horizontal_position, vertical_position, color, "Pawn");
    }

    public Pawn(Pawn p){
        super(p);
    }

    public Pawn clone(Pawn p){
        Pawn p2 = new Pawn(p);
        return p;
    }

    public ArrayList<ArrayList<Integer>> pawnMoves(int turn, Piece[][] board, int num1, int num2) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> arr2;
        int a = getHorizontal_position(), b = getVertical_position();
        if (this.color == 'b') {
            if (!wasMoved) {
                int i = 1;
                if(b - 1 >= 0){
                    if (board[a + i][b - 1] != null) {
                        if (board[a + i][b - 1].oppositeColor() == board[a][b].getColor()) {
                            arr2 = new ArrayList<Integer>();
                            arr2.add(a + i);
                            arr2.add(b - 1);
                            arr.add(arr2);
                        }
                    }
                }
                if(b + 1 < 8){
                    if (board[a + i][b + 1] != null) {
                        if (board[a + i][b + 1].oppositeColor() == board[a][b].getColor()) {
                            arr2 = new ArrayList<Integer>();
                            arr2.add(a + i);
                            arr2.add(b + 1);
                            arr.add(arr2);
                        }
                    }
                }
                while (i < 3 && board[a + i][b] == null) {
                    arr2 = new ArrayList<Integer>();
                    arr2.add(a + i);
                    arr2.add(b);
                    arr.add(arr2);
                    i++;
                }
            }
            else {
                if (a + 1 < 8 ) {
                    if(board[a + 1][b] == null) {
                        arr2 = new ArrayList<Integer>();
                        arr2.add(a + 1);
                        arr2.add(b);
                        arr.add(arr2);
                    }
                    if (b - 1 >= 0) {
                        if (board[a + 1][b - 1] != null) {
                            if (board[a + 1][b - 1].oppositeColor() == board[a][b].getColor()) {
                                arr2 = new ArrayList<Integer>();
                                arr2.add(a + 1);
                                arr2.add(b - 1);
                                arr.add(arr2);
                            }
                        }
                    }
                    if(b + 1 < 8){
                        if (board[a + 1][b + 1] != null) {
                            if (board[a + 1][b + 1].oppositeColor() == board[a][b].getColor()) {
                                arr2 = new ArrayList<Integer>();
                                arr2.add(a + 1);
                                arr2.add(b + 1);
                                arr.add(arr2);
                            }
                        }
                    }
                }
            }
        }
        else {
            int i = 1;
            if(!wasMoved) {
                if(b - 1 >= 0){
                    if (board[a - i][b - 1] != null) {
                        if (board[a - i][b - 1].oppositeColor() == board[a][b].getColor()) {
                            arr2 = new ArrayList<Integer>();
                            arr2.add(a - i);
                            arr2.add(b - 1);
                            arr.add(arr2);
                        }
                    }
                }
                if(b + 1 < 8){
                    if (board[a - i][b + 1] != null) {
                        if (board[a - i][b + 1].oppositeColor() == board[a][b].getColor()) {
                            arr2 = new ArrayList<Integer>();
                            arr2.add(a - i);
                            arr2.add(b + 1);
                            arr.add(arr2);
                        }
                    }
                }
                while (i < 3) {
                    arr2 = new ArrayList<Integer>();
                    arr2.add(a - i);
                    arr2.add(b);
                    arr.add(arr2);
                    i++;
                }
            } else {
                if (a - 1 >= 0) {
                    if(board[a - 1][b] == null){
                        arr2 = new ArrayList<Integer>();
                        arr2.add(a - 1);
                        arr2.add(b);
                        arr.add(arr2);
                    }
                    if(b - 1 >= 0){
                        if (board[a - i][b - 1] != null) {
                            if (board[a - i][b - 1].oppositeColor() == board[a][b].getColor()) {
                                arr2 = new ArrayList<Integer>();
                                arr2.add(a - i);
                                arr2.add(b - 1);
                                arr.add(arr2);
                            }
                        }
                    }
                    if(b +  1 < 8){
                        if (board[a - i][b + 1] != null) {
                            if (board[a - i][b + 1].oppositeColor() == board[a][b].getColor()) {
                                arr2 = new ArrayList<Integer>();
                                arr2.add(a - i);
                                arr2.add(b + 1);
                                arr.add(arr2);
                            }
                        }
                    }
                }
            }
        }
        return arr;
    }
}

class Rook extends Piece{
    public Rook(int horizontal_position, int vertical_position, char color){
        super(horizontal_position, vertical_position, color, "Rook");
    }

    public Rook(Rook r){
        super(r);
    }

    public Rook clone(Rook r){
        Rook r2 = new Rook(r);
        return r2;
    }

    public ArrayList<ArrayList<Integer>> rookMoves(Piece[][] board, int num1, int num2){
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> arr2 ;
        int a = getHorizontal_position(), b = getVertical_position();
        boolean ok = true, ok2 = true, ok3 = true, ok4 = true;
        for(int i = 1; i <= 8; i++){
            if(b + i < 8 && ok){
                if(board[a][b + i] == null){
                    arr2 = new ArrayList<Integer>();
                    arr2.add(a);
                    arr2.add(b + i);
                    arr.add(arr2);
                }
                else if(board[a][b + i].getColor() == board[a][b].oppositeColor()){
                    arr2 = new ArrayList<Integer>();
                    arr2.add(a);
                    arr2.add(b + i);
                    arr.add(arr2);
                    ok = false;
                }
                else{
                    ok = false;
                }
            }
            if(b - i >= 0 && ok2){
                if(board[a][b - i] == null){
                    arr2 = new ArrayList<Integer>();
                    arr2.add(a);
                    arr2.add(b - i);
                    arr.add(arr2);
                }
                else if(board[a][b - i].getColor() == board[a][b].oppositeColor()){
                    arr2 = new ArrayList<Integer>();
                    arr2.add(a);
                    arr2.add(b - i);
                    arr.add(arr2);
                    ok2 = false;
                }
                else{
                    ok2 = false;
                }
            }
            if(a + i < 8 && ok3){
                if(board[a + i][b] == null){
                    arr2 = new ArrayList<Integer>();
                    arr2.add(a + i);
                    arr2.add(b);
                    arr.add(arr2);
                }
                else if(board[a + i][b].getColor() == board[a][b].oppositeColor()){
                    arr2 = new ArrayList<Integer>();
                    arr2.add(a + i);
                    arr2.add(b);
                    arr.add(arr2);
                    ok3 = false;
                }
                else{
                    ok3 = false;
                }
            }
            if(a - i >= 0 && ok4){
                if(board[a - i][b] == null){
                    arr2 = new ArrayList<Integer>();
                    arr2.add(a - i);
                    arr2.add(b);
                    arr.add(arr2);
                }
                else if(board[a - i][b].getColor() == board[a][b].oppositeColor()){
                    arr2 = new ArrayList<Integer>();
                    arr2.add(a - i);
                    arr2.add(b);
                    arr.add(arr2);
                    ok4 = false;
                }
                else{
                    ok4 = false;
                }
            }
        }
        return arr;
    }

}

class Bishop extends Piece{
    public Bishop(int horizontal_position, int vertical_position, char color){
        super(horizontal_position, vertical_position, color, "Bishop");
    }

    public Bishop(Bishop b){
        super(b);
    }



    public Bishop clone(Bishop b){
        Bishop b2 = new Bishop(b);
        return b2;
    }




    public ArrayList<ArrayList<Integer>> bishopMoves(Piece[][] board, int num1, int num2){
        int a = getHorizontal_position(), b = getVertical_position() ;
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> arr2;
        int k = 0, num;
        boolean ok3 = true, ok4 = true, ok5 = true, ok6 = true;
        for(int i = 1; i <= 8; i++){
            for (int j = 1; j <= 8; j++) {
                if (j == i && j != 0) {
                    if (a + i < 8 && b + j < 8 && ok3) {
                        if (board[a + i][b + i] == null) {
                            arr2 = new ArrayList<Integer>();
                            arr2.add(a + i);
                            arr2.add(b + i);
                            arr.add(arr2);
                        } else if (board[a + i][b + i].getColor() == board[a][b].oppositeColor()) {
                            arr2 = new ArrayList<Integer>();
                            arr2.add(a + i);
                            arr2.add(b + i);
                            arr.add(arr2);
                            ok3 = false;
                        } else {
                            ok3 = false;
                        }
                    }
                    if (a + i < 8 && b - j >= 0 && ok4) {
                        if (board[a + i][b - i] == null) {
                            arr2 = new ArrayList<Integer>();
                            arr2.add(a + i);
                            arr2.add(b - i);
                            arr.add(arr2);
                        } else if (board[a + i][b - i].getColor() == board[a][b].oppositeColor()) {
                            arr2 = new ArrayList<Integer>();
                            arr2.add(a + i);
                            arr2.add(b - i);
                            arr.add(arr2);
                            ok4 = false;
                        } else {
                            ok4 = false;
                        }
                    }
                    if (a - i >= 0 && b + j < 8 && ok5) {
                        if (board[a - i][b + i] == null) {
                            arr2 = new ArrayList<Integer>();
                            arr2.add(a - i);
                            arr2.add(b + i);
                            arr.add(arr2);
                        } else if (board[a - i][b + i].getColor() == board[a][b].oppositeColor()) {
                            arr2 = new ArrayList<Integer>();
                            arr2.add(a - i);
                            arr2.add(b + i);
                            arr.add(arr2);
                            ok5 = false;
                        } else {
                            ok5 = false;
                        }
                    }
                    if (a - i >= 0 && b - j >= 0 && ok6) {
                        if (board[a - i][b - i] == null) {
                            arr2 = new ArrayList<Integer>();
                            arr2.add(a - i);
                            arr2.add(b - i);
                            arr.add(arr2);
                        } else if (board[a - i][b - i].getColor() == board[a][b].oppositeColor()) {
                            arr2 = new ArrayList<Integer>();
                            arr2.add(a - i);
                            arr2.add(b - i);
                            arr.add(arr2);
                            ok6 = false;
                        } else {
                            ok6 = false;
                        }
                    }
                }
            }
        }
        return arr;
    }
}

class Knight extends Piece{
    public Knight(int horizontal_position, int vertical_position, char color){
        super(horizontal_position, vertical_position, color, "Knight");
    }

    public Knight(Knight k){
        super(k);
    }

    public Knight clone(Knight k){
        Knight k2 = new Knight(k);
        return k2;
    }



    public ArrayList<ArrayList<Integer>> knightMoves(Piece[][] board, int num1, int num2){
        int a = getHorizontal_position(), b = getVertical_position() ;
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> arr2;

        if(a + 2 < 8){
            if(b + 1 < 8){
                if(board[a + 2][b + 1] == null){
                    arr2 = new ArrayList<Integer>();
                    arr2.add(a + 2);
                    arr2.add(b + 1);
                    arr.add(arr2);
                }
                else{
                    if(board[a][b].oppositeColor() == board[a + 2][b + 1].getColor()){
                        arr2 = new ArrayList<Integer>();
                        arr2.add(a + 2);
                        arr2.add(b + 1);
                        arr.add(arr2);
                    }
                }
            }
            if(b - 1  >= 0){
                if(board[a + 2][b - 1] == null){
                    arr2 = new ArrayList<Integer>();
                    arr2.add(a + 2);
                    arr2.add(b - 1);
                    arr.add(arr2);
                }
                else{
                    if(board[a][b].oppositeColor() == board[a + 2][b - 1].getColor()){
                        arr2 = new ArrayList<Integer>();
                        arr2.add(a + 2);
                        arr2.add(b - 1);
                        arr.add(arr2);
                    }
                }
            }

        }
        if(a - 2 >= 0){
            if(b + 1 < 8){
                if(board[a - 2][b + 1] == null){
                    arr2 = new ArrayList<Integer>();
                    arr2.add(a - 2);
                    arr2.add(b + 1);
                    arr.add(arr2);
                }
                else{
                    if(board[a][b].oppositeColor() == board[a - 2][b + 1].getColor()){
                        arr2 = new ArrayList<Integer>();
                        arr2.add(a - 2);
                        arr2.add(b + 1);
                        arr.add(arr2);
                    }
                }
            }
            if(b - 1  >= 0){
                if(board[a - 2][b - 1] == null){
                    arr2 = new ArrayList<Integer>();
                    arr2.add(a - 2);
                    arr2.add(b - 1);
                    arr.add(arr2);
                }
                else{
                    if(board[a][b].oppositeColor() == board[a - 2][b - 1].getColor()){
                        arr2 = new ArrayList<Integer>();
                        arr2.add(a - 2);
                        arr2.add(b - 1);
                        arr.add(arr2);
                    }
                }
            }
        }
        if(b + 2 < 8){
            if(a + 1 < 8){
                if(board[a + 1][b + 2] == null){
                    arr2 = new ArrayList<Integer>();
                    arr2.add(a + 1);
                    arr2.add(b + 2);
                    arr.add(arr2);
                }
                else{
                    if(board[a][b].oppositeColor() == board[a + 1][b + 2].getColor()){
                        arr2 = new ArrayList<Integer>();
                        arr2.add(a + 1);
                        arr2.add(b + 2);
                        arr.add(arr2);
                    }
                }
            }

            if(a - 1  >= 0){
                if(board[a - 1][b + 2] == null){
                    arr2 = new ArrayList<Integer>();
                    arr2.add(a - 1);
                    arr2.add(b + 2);
                    arr.add(arr2);
                }
                else{
                    if(board[a][b].oppositeColor() == board[a - 1][b + 2].getColor()){
                        arr2 = new ArrayList<Integer>();
                        arr2.add(a - 1);
                        arr2.add(b + 2);
                        arr.add(arr2);
                    }
                }
            }

        }
        if(b - 2 >= 0){
            if(a + 1 < 8){
                if(board[a + 1][b - 2] == null){
                    arr2 = new ArrayList<Integer>();
                    arr2.add(a + 1);
                    arr2.add(b - 2);
                    arr.add(arr2);
                }
                else{
                    if(board[a][b].oppositeColor() == board[a + 1][b - 2].getColor()){
                        arr2 = new ArrayList<Integer>();
                        arr2.add(a + 1);
                        arr2.add(b - 2);
                        arr.add(arr2);
                    }
                }
            }
            if(a - 1  >= 0 ){
                if(board[a - 1][b - 2] == null){
                    arr2 = new ArrayList<Integer>();
                    arr2.add(a - 1);
                    arr2.add(b - 2);
                    arr.add(arr2);
                }
                else{
                    if(board[a][b].oppositeColor() == board[a - 1][b - 2].getColor()){
                        arr2 = new ArrayList<Integer>();
                        arr2.add(a - 1);
                        arr2.add(b - 2);
                        arr.add(arr2);
                    }
                }
            }

        }
        return arr;
    }
}

class Queen extends Piece {
    public Queen(int horizontal_position, int vertical_position, char color) {
        super(horizontal_position, vertical_position, color, "Queen");
    }

    public Queen(Queen q){
        super(q);
    }


    public Queen clone(Queen q){
        Queen q2 = new Queen(q);
        return  q2;
    }

    public ArrayList<ArrayList<Integer>> queenMoves(Piece[][] board, int num1, int num2) {
        int a = num1, b = num2;
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> arr2;
        boolean ok1 = true, ok2 = true, ok3 = true, ok4 = true, ok5 = true, ok6 = true, ok7 = true, ok8 = true;

        for (int i = 1; i <= 8; i++) {
            if (b + i < 8 && ok1) {
                if(board[a][b + i] == null){
                    arr2 = new ArrayList<Integer>();
                    arr2.add(a);
                    arr2.add(b + i);
                    arr.add(arr2);
                }
                else if(board[a][b + i].getColor() == board[a][b].oppositeColor()){
                    arr2 = new ArrayList<Integer>();
                    arr2.add(a);
                    arr2.add(b + i);
                    arr.add(arr2);
                    ok1 = false;
                }
                else{
                    ok1 = false;
                }

            }
            if (b - i >= 0 && ok2) {
                if(board[a][b - i] == null){
                    arr2 = new ArrayList<Integer>();
                    arr2.add(a);
                    arr2.add(b - i);
                    arr.add(arr2);
                }
                else if(board[a][b - i].getColor() == board[a][b].oppositeColor()){
                    arr2 = new ArrayList<Integer>();
                    arr2.add(a);
                    arr2.add(b - i);
                    arr.add(arr2);
                    ok2 = false;
                }
                else{
                    ok2 = false;
                }
            }
            for (int j = 1; j <= 8; j++) {
                if (j == i && j != 0) {
                    if (a + i < 8 && b + j < 8 && ok3) {
                        if(board[a + i][b + i] == null){
                            arr2 = new ArrayList<Integer>();
                            arr2.add(a + i);
                            arr2.add(b + i);
                            arr.add(arr2);
                        }
                        else if(board[a + i][b + i].getColor() == board[a][b].oppositeColor()){
                            arr2 = new ArrayList<Integer>();
                            arr2.add(a + i);
                            arr2.add(b + i);
                            arr.add(arr2);
                            ok3 = false;
                        }
                        else{
                            ok3 = false;
                        }
                    }
                    if (a + i < 8 && b - j >= 0 && ok4) {
                        if(board[a + i][b - i] == null){
                            arr2 = new ArrayList<Integer>();
                            arr2.add(a + i);
                            arr2.add(b - i);
                            arr.add(arr2);
                        }
                        else if(board[a + i][b - i].getColor() == board[a][b].oppositeColor()){
                            arr2 = new ArrayList<Integer>();
                            arr2.add(a + i);
                            arr2.add(b - i);
                            arr.add(arr2);
                            ok4 = false;
                        }
                        else{
                            ok4 = false;
                        }
                    }
                    if (a - i >= 0 && b + j < 8 && ok5) {
                        if(board[a - i][b + i] == null){
                            arr2 = new ArrayList<Integer>();
                            arr2.add(a - i);
                            arr2.add(b + i);
                            arr.add(arr2);
                        }
                        else if(board[a - i][b + i].getColor() == board[a][b].oppositeColor()){
                            arr2 = new ArrayList<Integer>();
                            arr2.add(a - i);
                            arr2.add(b + i);
                            arr.add(arr2);
                            ok5 = false;
                        }
                        else{
                            ok5 = false;
                        }
                    }
                    if (a - i >= 0 && b - j >= 0 && ok6) {
                        if(board[a - i][b - i] == null){
                            arr2 = new ArrayList<Integer>();
                            arr2.add(a - i);
                            arr2.add(b - i);
                            arr.add(arr2);
                        }
                        else if(board[a - i][b - i].getColor() == board[a][b].oppositeColor()){
                            arr2 = new ArrayList<Integer>();
                            arr2.add(a - i);
                            arr2.add(b - i);
                            arr.add(arr2);
                            ok6 = false;
                        }
                        else{
                            ok6 = false;
                        }
                    }
                }
            }
            if (a + i < 8 && ok7) {
                if(board[a + i][b] == null){
                    arr2 = new ArrayList<Integer>();
                    arr2.add(a + i);
                    arr2.add(b);
                    arr.add(arr2);
                }
                else if(board[a + i][b].getColor() == board[a][b].oppositeColor()){
                    arr2 = new ArrayList<Integer>();
                    arr2.add(a + i);
                    arr2.add(b);
                    arr.add(arr2);
                    ok7 = false;
                }
                else{
                    ok7 = false;
                }
            }
            if (a - i >= 0 && ok8) {
                if(board[a - i][b] == null){
                    arr2 = new ArrayList<Integer>();
                    arr2.add(a - i);
                    arr2.add(b);
                    arr.add(arr2);
                }
                else if(board[a - i][b].getColor() == board[a][b].oppositeColor()){
                    arr2 = new ArrayList<Integer>();
                    arr2.add(a - i);
                    arr2.add(b);
                    arr.add(arr2);
                    ok8 = false;
                }
                else{
                    ok8 = false;
                }
            }
        }
        return arr;
    }

}

class King extends Piece {
    public King(int horizontal_position, int vertical_position, char color) {
        super(horizontal_position, vertical_position, color, "King");
    }

    public King(King k){
        super(k);
    }

    public King clone(King k){
        King k2 = new King(k);
        return k2;
    }

    public ArrayList<ArrayList<Integer>> kingMoves(Piece[][] board, int num1, int num2) {
        int a = horizontal_position, b = vertical_position;
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> arr2;

        boolean ok1 = true, ok2 = true, ok3 = true, ok4 = true, ok5 = true, ok6 = true, ok7 = true, ok8 = true;

        for (int i = 1; i <= 1; i++) {
            if (b + i < 8 && ok1) {
                if(board[a][b + i] == null){
                    arr2 = new ArrayList<Integer>();
                    arr2.add(a);
                    arr2.add(b + i);
                    arr.add(arr2);
                }
                else if(board[a][b + i].getColor() == board[a][b].oppositeColor()){
                    arr2 = new ArrayList<Integer>();
                    arr2.add(a);
                    arr2.add(b + i);
                    arr.add(arr2);
                    ok1 = false;
                }
                else{
                    ok1 = false;
                }

            }
            if (b - i >= 0 && ok2) {
                if(board[a][b - i] == null){
                    arr2 = new ArrayList<Integer>();
                    arr2.add(a);
                    arr2.add(b - i);
                    arr.add(arr2);
                }
                else if(board[a][b - i].getColor() == board[a][b].oppositeColor()){
                    arr2 = new ArrayList<Integer>();
                    arr2.add(a);
                    arr2.add(b - i);
                    arr.add(arr2);
                    ok2 = false;
                }
                else{
                    ok2 = false;
                }
            }
            for (int j = 1; j <= 1; j++) {

                if (j == i && j != 0) {
                    if (a + i < 8 && b + j < 8 && ok3) {
                        if(board[a + i][b + i] == null){
                            arr2 = new ArrayList<Integer>();
                            arr2.add(a + i);
                            arr2.add(b + i);
                            arr.add(arr2);
                        }
                        else if(board[a + i][b + i].getColor() == board[a][b].oppositeColor()){
                            arr2 = new ArrayList<Integer>();
                            arr2.add(a + i);
                            arr2.add(b + i);
                            arr.add(arr2);
                            ok3 = false;
                        }
                        else{
                            ok3 = false;
                        }
                    }
                    if (a + i < 8 && b - j >= 0 && ok4) {
                        if(board[a + i][b - i] == null){
                            arr2 = new ArrayList<Integer>();
                            arr2.add(a + i);
                            arr2.add(b - i);
                            arr.add(arr2);
                        }
                        else if(board[a + i][b - i].getColor() == board[a][b].oppositeColor()){
                            arr2 = new ArrayList<Integer>();
                            arr2.add(a + i);
                            arr2.add(b - i);
                            arr.add(arr2);
                            ok4 = false;
                        }
                        else{
                            ok4 = false;
                        }
                    }
                    if (a - i >= 0 && b + j < 8 && ok5) {
                        if(board[a - i][b + i] == null){
                            arr2 = new ArrayList<Integer>();
                            arr2.add(a - i);
                            arr2.add(b + i);
                            arr.add(arr2);
                        }
                        else if(board[a - i][b + i].getColor() == board[a][b].oppositeColor()){
                            arr2 = new ArrayList<Integer>();
                            arr2.add(a - i);
                            arr2.add(b + i);
                            arr.add(arr2);
                            ok5 = false;
                        }
                        else{
                            ok5 = false;
                        }
                    }
                    if (a - i >= 0 && b - j >= 0 && ok6) {
                        if(board[a - i][b - i] == null){
                            arr2 = new ArrayList<Integer>();
                            arr2.add(a - i);
                            arr2.add(b - i);
                            arr.add(arr2);
                        }
                        else if(board[a - i][b - i].getColor() == board[a][b].oppositeColor()){
                            arr2 = new ArrayList<Integer>();
                            arr2.add(a - i);
                            arr2.add(b - i);
                            arr.add(arr2);
                            ok6 = false;
                        }
                        else{
                            ok6 = false;
                        }
                    }
                }
            }
            if (a + i < 8 && ok7) {
                if(board[a + i][b] == null){
                    arr2 = new ArrayList<Integer>();
                    arr2.add(a + i);
                    arr2.add(b);
                    arr.add(arr2);
                }
                else if(board[a + i][b].getColor() == board[a][b].oppositeColor()){
                    arr2 = new ArrayList<Integer>();
                    arr2.add(a + i);
                    arr2.add(b);
                    arr.add(arr2);
                    ok7 = false;
                }
                else{
                    ok7 = false;
                }
            }
            if (a - i >= 0 && ok8) {
                if(board[a - i][b] == null){
                    arr2 = new ArrayList<Integer>();
                    arr2.add(a - i);
                    arr2.add(b);
                    arr.add(arr2);
                }
                else if(board[a - i][b].getColor() == board[a][b].oppositeColor()){
                    arr2 = new ArrayList<Integer>();
                    arr2.add(a - i);
                    arr2.add(b);
                    arr.add(arr2);
                    ok8 = false;
                }
                else{
                    ok8 = false;
                }
            }
        }
        return arr;
    }
}















