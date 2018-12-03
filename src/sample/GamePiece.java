package sample;



public class GamePiece {

    private Seed content;
    private String piece;
    private int value;

    public GamePiece(Seed content) {

        this.content = content;

        switch(content){
            case PLAYER1:
                value = 1;
                piece = "X";
                break;
            case PLAYER2:
                value = 2;
                piece = "O";
                break;
            default:
                value = 0;
                piece = " ";
                break;
        }
    }

    @Override
    public String toString() {
        return content.toString();
    }

    public int getValue(){
        return value;
    }

    public void print(){
        System.out.print(piece);
    }
}
