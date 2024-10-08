package Tests;

import Java.Block;

public class SingleBlock implements Block {
    private String color;
    private String material;

    public SingleBlock(String color, String material) {
        this.color = color;
        this.material = material;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getMaterial() {
        return material;
    }
}
