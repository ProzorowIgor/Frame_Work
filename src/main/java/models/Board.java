package models;

public class Board {
    private  String boardName;



    public String getBoardName() {
        return boardName;
    }

    public Board withName(String boardName) {
        this.boardName = boardName;
        return this;
    }

    @Override
    public String toString() {
        return "Board{" +
                "boardName='" + boardName + '\'' +
                '}';
    }



}
