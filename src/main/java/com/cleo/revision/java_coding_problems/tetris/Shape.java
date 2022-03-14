package com.cleo.revision.java_coding_problems.tetris;

import java.util.Random;

public class Shape {

    protected enum Tetrominoe{
        NoShape, ZShape, SShape,
        LineShape, TShape, SquareShape, LShape, MirroredLShape
    }

    private Tetrominoe pieceShape;

    private int[][] coords;

    public Shape(){
        this.coords = new int[4][2];
        setShape(Tetrominoe.NoShape);
    }

    public void setShape(Tetrominoe shape){

        int[][][] coOrdsTable = new int[][][]{
                {{0,0},{0,0},{0,0},{0,0}},
                {{0,-1},{0,0},{-1,0},{-1,1}},
                {{0,-1},{0,0},{1,0},{1,1}},
                {{0,-1},{0,0},{0,1},{0,2}},
                {{-1,0},{0,0},{1,0},{0,1}},
                {{0,0},{1,0},{0,1},{0,1}},
                {{-1,-1},{0,-1},{0,0},{0,1}},
                {{1,-1},{0,-1},{0,0},{0,1}}
        };
        for (int i = 0; i < 4; i++) {
            System.arraycopy(coOrdsTable[shape.ordinal()],0,coords,0,4);
        }
        pieceShape = shape;
    }

    private void setX(int index, int X){
        coords[index][0] = X;
    }

    private void setY(int index, int Y){
        coords[index][1] = Y;
    }
    int X(int index){
        return coords[index][0];
    }
    int Y(int index){
        return coords[index][1];
    }

    Tetrominoe getShape(){
        return pieceShape;
    }

    void setRandomShape(){
        var r = new Random();
        int x = Math.abs(r.nextInt())%7+1;
        Tetrominoe[] values = Tetrominoe.values();
        setShape(values[x]);
    }

    public  int minX(){
        int m = coords[0][0];

        for (int i = 0; i < 4; i++) {
            m = Math.min(m, coords[i][0]);

        }
        return m;
    }
    public  int minY(){
        int m = coords[0][0];

        for (int i = 0; i < 4; i++) {
            m = Math.min(m, coords[i][1]);

        }
        return m;
    }

    Shape rotateLeft(){
        if(pieceShape == Tetrominoe.SquareShape){
            return this;
        }

        var result = new Shape();
        result.pieceShape = pieceShape;
        for (int i = 0; i <4 ; i++) {
            result.setX(i,Y(i));
            result.setY(i,-X(i));

        }
        return result;
    }

    Shape rotateRight(){
        if(pieceShape == Tetrominoe.SquareShape){
            return this;
        }

        var result = new Shape();
        result.pieceShape = pieceShape;
        for (int i = 0; i <4 ; i++) {
            result.setX(i,-Y(i));
            result.setY(i,X(i));

        }
        return result;
    }





}
