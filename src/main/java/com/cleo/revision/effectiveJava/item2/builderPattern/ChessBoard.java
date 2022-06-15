package com.cleo.revision.effectiveJava.item2.builderPattern;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public abstract class ChessBoard {
/*
    public enum ChessPiece{
        KNIGHT,ROOK,KING,QUEEN
    }
    final Set<ChessPiece> chessPieceSet;
    abstract static class Builder<T extends Builder<T>>{

        EnumSet<ChessPiece> pieces = EnumSet.allOf(ChessPiece.class);
        public T addPiece(ChessPiece piece){
            pieces.add(Objects.requireNonNull(piece));
            return self();
        }
        abstract ChessBoard build();

    }

    public ChessBoard(Builder<?> builder) {
        this.chessPieceSet = builder.pieces.clone();
    }*/
}
