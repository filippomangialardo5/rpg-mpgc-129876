package it.unicam.cs.mpgc.rpg129876.map;

import java.util.ArrayList;
import java.util.List;

public class MapManager {

    private List<GameMap> maps;

    private int currentMapIndex;

    public MapManager() {

        maps = new ArrayList<>();

        maps.add(new GameMap());

        maps.add(createSecondMap());

        currentMapIndex = 0;
    }

    private GameMap createSecondMap() {

        return new GameMap(

                new int[][]{

                        {1,1,1,1,1,1,1},
                        {1,2,0,3,0,4,1},
                        {1,0,1,1,0,0,1},
                        {1,0,0,0,0,0,1},
                        {1,1,1,0,1,5,1},
                        {1,0,0,0,0,0,1},
                        {1,1,1,1,1,1,1}
                },

                1,
                1
        );
    }

    public GameMap getCurrentMap() {

        return maps.get(currentMapIndex);
    }

    public boolean nextMap() {

        if (currentMapIndex
                < maps.size() - 1) {

            currentMapIndex++;

            return true;
        }

        return false;
    }
}