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

    public MoveResult movePlayer(int dRow, int dCol) {

        int newRow = playerRow + dRow;
        int newCol = playerCol + dCol;

        int destination = map[newRow][newCol];

        if (destination == 1) {
            return MoveResult.WALL;
        }

        if (destination == 3) {

            map[newRow][newCol] = 0;

            map[playerRow][playerCol] = 0;

            playerRow = newRow;
            playerCol = newCol;

            map[playerRow][playerCol] = 2;

            return MoveResult.ENEMY;
        }

        if (destination == 4) {

            map[newRow][newCol] = 0;

            map[playerRow][playerCol] = 0;

            playerRow = newRow;
            playerCol = newCol;

            map[playerRow][playerCol] = 2;

            return MoveResult.TREASURE;
        }

        map[playerRow][playerCol] = 0;

        playerRow = newRow;
        playerCol = newCol;

        map[playerRow][playerCol] = 2;

        return MoveResult.MOVED;
    }
}