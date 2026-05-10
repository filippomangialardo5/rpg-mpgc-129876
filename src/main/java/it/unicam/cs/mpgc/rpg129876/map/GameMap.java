package it.unicam.cs.mpgc.rpg129876.map;

public class GameMap {

    private int[][] map;

    private int playerRow;
    private int playerCol;

    public GameMap() {

        map = new int[][]{

                {1,1,1,1,1,1,1},
                {1,2,0,0,3,0,1},
                {1,0,1,0,1,0,1},
                {1,0,0,0,1,0,1},
                {1,4,1,0,0,0,1},
                {1,0,0,0,1,0,1},
                {1,1,1,1,1,1,1}
        };

        playerRow = 1;
        playerCol = 1;
    }

    public int[][] getMap() {
        return map;
    }

    public int getPlayerRow() {
        return playerRow;
    }

    public int getPlayerCol() {
        return playerCol;
    }

    public boolean movePlayer(int dRow, int dCol) {

        int newRow = playerRow + dRow;
        int newCol = playerCol + dCol;

        if (map[newRow][newCol] == 1) {
            return false;
        }

        map[playerRow][playerCol] = 0;

        playerRow = newRow;
        playerCol = newCol;

        map[playerRow][playerCol] = 2;

        return true;
    }
}