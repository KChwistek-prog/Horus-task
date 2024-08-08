package Java;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Wall implements Structure {
    private List<Block> blocks;

    public Wall(List<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        return findByColor(blocks, color);
    }

    private Optional<Block> findByColor(List<Block> blocks, String color) {
        return blocks.stream()
                .flatMap(block -> {
                    if (block.getColor().equals(color)) {
                        return Stream.of(block);
                    } else if (block instanceof CompositeBlock) {
                        return findByColor(((CompositeBlock) block).getBlocks(), color).stream();
                    } else {
                        return Stream.empty();
                    }
                })
                .findFirst();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        return findByMaterial(blocks, material);
    }

    private List<Block> findByMaterial(List<Block> blocks, String material) {
        List<Block> result = new ArrayList<>();
        for (Block block : blocks) {
            if (block.getMaterial().equals(material)) {
                result.add(block);
            }
            if (block instanceof CompositeBlock) {
                result.addAll(findByMaterial(((CompositeBlock) block).getBlocks(), material));
            }
        }
        return result;
    }

    @Override
    public int count() {
        return countBlocks(blocks);
    }

    private int countBlocks(List<Block> blocks) {
        int count = 0;
        for (Block block : blocks) {
            count++;
            if (block instanceof CompositeBlock) {
                count += countBlocks(((CompositeBlock) block).getBlocks());
            }
        }
        return count;
    }
}