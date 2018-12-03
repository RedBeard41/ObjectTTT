package sample;

public class Cell {

    GamePiece piece;
    private int row, col, value;

    public Cell(int row,int col) {
        this.row = row;
        this.col = col;


    }

    public void clear(){
        piece = new GamePiece(Seed.EMPTY);
    }

    public void setPiece(GamePiece piece) {
        this.piece = piece;
        value = piece.getValue();
    }

    public GamePiece getPiece(){
        return piece;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getValue() {
        return value;
    }

    public void print(){
        piece.print();

}

}
