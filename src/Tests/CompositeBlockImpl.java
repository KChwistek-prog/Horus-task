package Tests;

import Java.Block;
import Java.CompositeBlock;

import java.util.List;

public class CompositeBlockImpl implements CompositeBlock {
    private String color;
    private String material;
    private List<Block> blocks;

    public CompositeBlockImpl(List<Block> blocks) {
        this.color = color;
        this.material = material;
        this.blocks = blocks;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getMaterial() {
        return material;
    }

    @Override
    public List<Block> getBlocks() {
        return blocks;
    }
}
