package test;

import main.Game;
import main.Printer;
import main.World;
import org.junit.Assert;
import org.junit.Test;

public class GameClassTest {

    @Test
    public void givenNumberOfGenerationReturnsArrayOfWorld() throws InterruptedException {
        World world = new World(new boolean[3][3]);
        Printer printer = new Printer();
        Game game = new Game(world, printer);
        World[] actual = game.getNextWorlds(5);
        Assert.assertEquals(actual.length, 5);
    }
}
