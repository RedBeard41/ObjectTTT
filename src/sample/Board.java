package sample;

public class Board {

    private int rows, cols, winTotal;
    Cell[][] cells;

    public Board(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;

        cells = new Cell[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                cells[row][col] = new Cell(row, col);
            }
        }
    }

    public void init() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                cells[row][col].clear();
            }
        }
    }

    public boolean validMove(int row, int col) {
        if (row < 0 || row > rows || col < 0 || col > cols) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isAvailable(int row, int col) {
        System.out.println(cells[row][col].getValue());
        if (cells[row][col].getValue() != 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isDraw() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (cells[row][col].getValue() == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public void placePiece(int row, int col, GamePiece piece){
        cells[row][col].setPiece(piece);

    }

    public boolean checkWin(Cell cell) {
        int value = cell.getValue();
        int pieceCol = cell.getCol();
        int pieceRow = cell.getRow();
        if (checkHorizontal(value, pieceRow) || checkVertical(value, pieceCol) || checkLeftDiagonal(value) || checkRightDiagonal(value)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkHorizontal(int value, int line) {
        for (int col = 0; col < cols; col++) {
            if (cells[line][col].getValue() != value) {
                return false;
            }


        }
        return true;
    }

    private boolean checkVertical(int value, int line) {
        for (int row = 0; row < cols; row++) {
            if (cells[row][line].getValue() != value) {
                return false;
            }


        }
        return true;
    }

    private boolean checkLeftDiagonal(int value) {
        int count = 0;
        int length = rows;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (row == col && cells[row][col].getValue() == value) {
                    count++;
                }
            }
        }
        return count == length ? true : false;

    }

    private boolean checkRightDiagonal(int value) {
        int length;
        int count = 0;

        length = rows;
        //this should run everytime
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (row + col == length - 1 && cells[row][col].getValue() == value) {
                    count++;
                }
            }
        }

        return count == length ? true : false;

    }

    public void print() {
           
        for (int row = 0; row < rows; row++) {
            printHorizontalLine();
            for (int col = 0; col < cols; col++) {
                System.out.print("| ");
                cells[row][col].print();
                System.out.print(" ");
            }
            System.out.println("|");

        }
        printHorizontalLine();
    }


        /*
        +---+---+---+
        |   |   |   |
        +---+---+---+
        |   |   |   |
        +---+---+---+
        |   |   |   |
        +---+---+---+

         */




    private void printHorizontalLine() {
        for (int j = 0; j <= cols; j++) {
            System.out.print("+");
            if (j < cols) {
                System.out.print("---");
            }
            if (j == cols) {
                System.out.print("\n");
            }

        }

    }



    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
}

