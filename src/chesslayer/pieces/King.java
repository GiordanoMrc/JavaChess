package chesslayer.pieces;

import boardlayer.Board;
import boardlayer.Position;
import chesslayer.ChessMatch;
import chesslayer.ChessPiece;
import chesslayer.Color;

public class King extends ChessPiece {

    private ChessMatch chessMatch;
    public King(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    private boolean testRookCastling(Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return  p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() ==0 ;
    }
    private boolean canMove(Position position){
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

    @Override
    public String toString() {
        return "K";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] matrix = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0,0);

        // walking above
        p.setValues(position.getRow()-1, position.getColumn());
        if(getBoard().positionExists(p) && canMove(p)){
            matrix[p.getRow()][p.getColumn()] = true;
        }

        // walking above + left

        p.setValues(position.getRow()-1, position.getColumn()-1);

        if(getBoard().positionExists(p) && canMove(p)){
            matrix[p.getRow()][p.getColumn()] = true;
        }

        // walking above + right

        p.setValues(position.getRow()-1, position.getColumn()+1);
        if(getBoard().positionExists(p) && canMove(p)){
            matrix[p.getRow()][p.getColumn()] = true;
        }

        // walking left

        p.setValues(position.getRow(), position.getColumn()-1);
        if(getBoard().positionExists(p) && canMove(p)){
            matrix[p.getRow()][p.getColumn()] = true;
        }

        // walking right

        p.setValues(position.getRow(), position.getColumn()+1);
        if(getBoard().positionExists(p) && canMove(p)){
            matrix[p.getRow()][p.getColumn()] = true;
        }

        // walking below

        p.setValues(position.getRow()+1, position.getColumn());

        if(getBoard().positionExists(p) && canMove(p)){
            matrix[p.getRow()][p.getColumn()] = true;
        }

        // walking below + left

        p.setValues(position.getRow()+1, position.getColumn()-1);

        if(getBoard().positionExists(p) && canMove(p)){
            matrix[p.getRow()][p.getColumn()] = true;
        }

        // walking below + right

        p.setValues(position.getRow()+1, position.getColumn()+1);
        if(getBoard().positionExists(p) && canMove(p)){
            matrix[p.getRow()][p.getColumn()] = true;
        }

        // castling

        if(getMoveCount() == 0 && !chessMatch.getCheck()) {
            Position pT1 = new Position(position.getRow(), position.getColumn()+ 3);
            if(testRookCastling(pT1)) {
                Position p1 = new Position(position.getRow(), position.getColumn() +1);
                Position p2 = new Position(position.getRow(), position.getColumn()+2);
                if(getBoard().piece(p1) == null && getBoard().piece(p2) == null) {
                    matrix[position.getRow()][position.getColumn()+2] = true;
                    }
                }

            Position pT2 = new Position(position.getRow(), position.getColumn()- 4);
            if(testRookCastling(pT2)) {
                Position p1 = new Position(position.getRow(), position.getColumn()-1);
                Position p2 = new Position(position.getRow(), position.getColumn()-2);
                Position p3 = new Position(position.getRow(), position.getColumn()-3);
                if(getBoard().piece(p1) == null && getBoard().piece(p2) == null &&  getBoard().piece(p3) == null) {
                    matrix[position.getRow()][position.getColumn()-2] = true;
                }
            }
        }

        return matrix;
    }
}
