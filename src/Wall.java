import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Wall implements Structure {
    private List<Block> blocks;

    public Wall(List<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        return findBlockByColorInList(blocks, color);
    }

    private Optional<Block> findBlockByColorInList(List<Block> blocks, String color) {
        for (Block block : blocks) {
            if (block.getColor().equals(color)) {
                return Optional.of(block);
            }
            if (block instanceof CompositeBlock) {
                Optional<Block> foundBlock = findBlockByColorInList(((CompositeBlock) block).getBlocks(), color);
                if (foundBlock.isPresent()) {
                    return foundBlock;
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        return findBlocksByMaterialInList(blocks, material);
    }

    private List<Block> findBlocksByMaterialInList(List<Block> blocks, String material) {
        List<Block> result = new ArrayList<>();
        for (Block block : blocks) {
            if (block.getMaterial().equals(material)) {
                result.add(block);
            }
            if (block instanceof CompositeBlock) {
                result.addAll(findBlocksByMaterialInList(((CompositeBlock) block).getBlocks(), material));
            }
        }
        return result;
    }

    @Override
    public int count() {
        return countBlocksInList(blocks);
    }

    private int countBlocksInList(List<Block> blocks) {
        int count = 0;
        for (Block block : blocks) {
            count++;
            if (block instanceof CompositeBlock) {
                count += countBlocksInList(((CompositeBlock) block).getBlocks());
            }
        }
        return count;
    }
}