package chesslayer.pieces;

import boardlayer.Board;
import boardlayer.Position;
import chesslayer.ChessPiece;
import chesslayer.Color;

public class Queen extends ChessPiece {
    public Queen(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "Q";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] matrix = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0,0);

        p.setValues(position.getRow()- 1, position.getColumn()-1);
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            matrix[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow()-1, p.getColumn()-1);
        }
        if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
            matrix[p.getRow()][p.getColumn()] = true;
        }

        p.setValues(position.getRow()-1, position.getColumn()+1);
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            matrix[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow()-1,p.getColumn()+1);
        }
        if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
            matrix[p.getRow()][p.getColumn()] = true;
        }

        p.setValues(position.getRow()+1, position.getColumn()-1);
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            matrix[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow()+1,p.getColumn()-1);
        }
        if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
            matrix[p.getRow()][p.getColumn()] = true;
        }

        p.setValues(position.getRow() + 1, position.getColumn()+1);
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            matrix[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() + 1, p.getColumn()+1);
        }
        if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
            matrix[p.getRow()][p.getColumn()] = true;
        }

        p.setValues(position.getRow(), position.getColumn()+1);
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            matrix[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow(), p.getColumn()+1);
        }
        if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
            matrix[p.getRow()][p.getColumn()] = true;
        }

        p.setValues(position.getRow(), position.getColumn()-1);
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            matrix[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() , p.getColumn()-1);
        }
        if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
            matrix[p.getRow()][p.getColumn()] = true;
        }

        p.setValues(position.getRow()-1, position.getColumn());
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            matrix[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow()-1, p.getColumn());
        }
        if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
            matrix[p.getRow()][p.getColumn()] = true;
        }

        p.setValues(position.getRow()+1, position.getColumn());
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            matrix[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() + 1, p.getColumn());
        }
        if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
            matrix[p.getRow()][p.getColumn()] = true;
        }

        return matrix;
    }
}
