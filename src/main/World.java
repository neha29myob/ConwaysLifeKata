package main;

public class World {

    private boolean[][] world;

    public World(boolean[][] world) {
        this.world = world;
    }

    public boolean[][] getWorld() {
        return world;
    }

    private boolean isNorthOutOfBounds(int y) {
        return y < 0;
    }

    private boolean isEastOutOfBounds(int x, int y) {
        return x > world[y].length - 1;
    }

    private boolean isSouthOutOfBounds(int y) {
        return y > world.length - 1;
    }

    private boolean isWestOutOfBounds(int x) {
        return x < 0;
    }

    private boolean getNorth(int x, int y) {
        int newY = y - 1;
        int newX = x;

        if (isNorthOutOfBounds(newY)) {
            return false;
        }
        return world[newY][newX];
    }

    private boolean getNorthEast(int x, int y) {
        int newY = y - 1;
        int newX = x + 1;

        if (isNorthOutOfBounds(newY)) {
            return false;
        }
        if (isEastOutOfBounds(newX, newY)) {
            newX = 0;
        }
        return world[newY][newX];
    }

    private boolean getEast(int x, int y) {
        int newY = y;
        int newX = x + 1;

        if (isEastOutOfBounds(newX, newY)) {
            newX = 0;
        }
        return world[newY][newX];
    }

    private boolean getSouthEast(int x, int y) {
        int newY = y + 1;
        int newX = x + 1;

        if (isSouthOutOfBounds(newY)) {
            return false;
        }
        if (isEastOutOfBounds(newX, newY)) {
            newX = 0;
        }
        return world[newY][newX];
    }

    private boolean getSouth(int x, int y) {
        int newY = y + 1;
        int newX = x;

        if (isSouthOutOfBounds(newY)) {
            return false;
        }
        return world[newY][newX];
    }

    private boolean getSouthWest(int x, int y) {
        int newY = y + 1;
        int newX = x - 1;

        if (isSouthOutOfBounds(newY)) {
            return false;
        }
        if (isWestOutOfBounds(newX)) {
            newX = world[y].length - 1;
        }
        return world[newY][newX];
    }

    private boolean getWest(int x, int y) {
        int newY = y;
        int newX = x - 1;

        if (isWestOutOfBounds(newX)) {
            newX = world[y].length - 1;
        }
        return world[newY][newX];
    }

    private boolean getNorthWest(int x, int y) {
        int newY = y - 1;
        int newX = x - 1;

        if (isNorthOutOfBounds(newY)) {
            return false;
        }
        if (isWestOutOfBounds(newX)) {
            newX = world[y].length - 1;
        }
        return world[newY][newX];
    }

    private int getNumberOfLivingNeighbours(int x, int y) {
        int livingCounter = 0;

        if (getNorth(x, y)) {
            livingCounter++;
        }
        if (getNorthEast(x, y)) {
            livingCounter++;
        }
        if (getEast(x, y)) {
            livingCounter++;
        }
        if (getSouthEast(x, y)) {
            livingCounter++;
        }
        if (getSouth(x, y)) {
            livingCounter++;
        }
        if (getSouthWest(x, y)) {
            livingCounter++;
        }
        if (getWest(x, y)) {
            livingCounter++;
        }

        if (getNorthWest(x, y)) {
            livingCounter++;
        }
        return livingCounter;
    }

    public World getNextWorld() {
        World nextWorld = new World(new boolean[world.length][world.length == 0 ? 0 : world[0].length]);
        for (int y = 0; y < world.length; y++) {
            for (int x = 0; x < world[y].length; x++) {
                if (world[y][x] && (getNumberOfLivingNeighbours(x, y) == 2 || getNumberOfLivingNeighbours(x, y) == 3)) {
                    nextWorld.getWorld()[y][x] = true;
                }
                if (!world[y][x] && (getNumberOfLivingNeighbours(x, y) == 3)) {
                    nextWorld.getWorld()[y][x] = true;
                }
            }
        }
        return nextWorld;
    }
}
