package Chess;

import java.util.HashMap;
import java.util.Map;

//inheritance - animal is a biter
//composition - animal has teeth
public class chess {

}

class Position {

}

enum color {
    WHITE, BLACK;
}

abstract class piece {
    private color color;
    Board currentBoard;
    color geColor() {
        return color;
    }
    

    Position currentPosition;

    public void move(Position destination) {
        if (isValid(currentPosition, destination)) {
            currentPosition = destination;
        }
    }

    public boolean isValid(Position currentPosition, Position destination) {
        Board temp = currentBoard;
        temp.makeMove(this, destination);
        if (currentKingInCheck(temp))
            return false;
        else {
            piece p = temp.get(destination);
            if (p != null && p.geColor() == color)
                return false;
            return isValidMove();
        }
    }

    public boolean currentKingInCheck(Board b) {
        return true;
    }

    protected abstract boolean isValidMove();
}

class Board {
    Map<Position, piece> map = new HashMap<>();

    void makeMove(piece piece, Position destination) {
        map.remove(piece.currentPosition);
        map.put(destination, piece);
    }

    piece get(Position p) {
        return map.get(p);
    }
}

class pawn extends piece {
    protected boolean isValidMove(){
        return true;
    }
}

class knight extends piece {
    protected boolean isValidMove(){
        return true;
    }
}

class rook extends piece {
    protected boolean isValidMove(){
        return true;
    }
}

class queen extends piece {
    protected boolean isValidMove(){
        return true;
    }
}

class bishop extends piece {
    protected boolean isValidMove(){
        return true;
    }
}