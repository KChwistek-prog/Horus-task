package Tests;

import Java.Block;
import Java.Wall;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.List;


public class WallTest {

    SingleBlock blockBlue = new SingleBlock("Blue", "Brick");
    SingleBlock blockRed = new SingleBlock("Red", "Brick");
    SingleBlock blockWhite = new SingleBlock("White", "Wood");
    SingleBlock blockBlack = new SingleBlock("Black", "Brick");
    public List<Block> blockList = Arrays.asList(blockBlack, blockBlue, blockRed, blockRed, blockWhite);


    public CompositeBlockImpl compositeBlock = new CompositeBlockImpl(blockList);
    public Wall wall = new Wall(blockList);

    @Test
    public void testCount() {
        Assertions.assertEquals(5, wall.count());
    }

    @Test
    public void testFindByColor() {
        Assertions.assertEquals("Red", wall.findBlockByColor("Red").get().getColor());
    }

    @Test
    public void testFindByMaterial() {
        Assertions.assertEquals(4, wall.findBlocksByMaterial("Brick").size());
        Assertions.assertEquals("Brick", wall.findBlocksByMaterial("Brick").get(0).getMaterial());

    }
}