package sample;

public class Player {
    int score;
    String name;
    GamePiece piece;
    Board board;

    public Player(String name, GamePiece piece) {
        this.name = name;
        this.piece = piece;
        score = 0;

    }

    public void init(Board board){
        this.board = board;

    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score += score;
    }

    public String getName() {
        return name;
    }

    public GamePiece getPiece() {
        return piece;
    }
}
