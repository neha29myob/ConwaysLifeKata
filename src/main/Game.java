package main;

import java.util.Arrays;

public class Game {

    private World currentWorld;
    private Printer printer;

    public Game(World world, Printer printer) {
        this.currentWorld = world;
        this.printer = printer;
    }

    public World[] getNextWorlds(int numGenerations) {
        World[] worlds = new World[numGenerations];
        for (int i = 0; i < numGenerations; i++) {
            World nextWorld = currentWorld.getNextWorld();
            worlds[i] = nextWorld;
            currentWorld = nextWorld;
        }
        return worlds;
    }

    public void run(int numGenerations) {
        Arrays.stream(getNextWorlds(numGenerations)).forEach(world -> {
            try {
                printer.print(world);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
    }
}
